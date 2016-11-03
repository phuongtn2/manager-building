package com.building.services.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import phuongtn2.cache.AuthorizedUserTokenCache;
import phuongtn2.dao.AuthorizedUserTokenMapper;
import phuongtn2.dto.AuthorizedUserInfo;
import phuongtn2.rest.ApiDefs;
import phuongtn2.service.AuthorizedUserTokenService;
import phuongtn2.service.Role;
import phuongtn2.service.error.ServiceException;
import phuongtn2.util.net.SslSocketFactory;
import phuongtn2.util.str.NumConverter;
import phuongtn2.util.str.StringUtil;
import phuongtn2.util.str.TokenGenerator;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.util.*;

@Service
public class AuthorizedUserTokenServiceImpl implements
		AuthorizedUserTokenService {
	/** ログ出力(認証フィルター用) */
	private static final Logger log = Logger.getLogger(AuthorizedUserTokenServiceImpl.class);

	/** DIシステム設定Bean */
	@Resource
	private Properties setting;

	@Autowired
	private AuthorizedUserTokenCache authCache;

	@Autowired
	private AuthorizedUserTokenMapper authMapper;

	@Autowired
	private ApplicationContext applicationContext;

	/** 乱数発生部分の長さ(日時・社員IDに加える) */
	private int randomTokenLength = 20;
	/** LDAP認証先URL */
	private String ldapAuthorizedUrl;
	/** LDAP認証先ADドメイン名 */
	private String ldapAdDomainName;
	
	
	/**
	 * 初期化時に認証関連パラメータの読み込み初期化処理を行う
	 */
	@PostConstruct
	public void initPathPatternList() {
		randomTokenLength = NumConverter.parseIntProperty(setting, "authorized.token.randomLength", randomTokenLength);
		ldapAuthorizedUrl = setting.getProperty("authorized.ldap.url");// ldap://192.178.120.1
		ldapAdDomainName = setting.getProperty("authorized.ldap.domain", ""); // "@open.local"

		final String keystoreDefKey = "authorized.ldap.ssl.keystore.filename";
		if(setting.containsKey(keystoreDefKey)) {
			final String pass = setting.getProperty("authorized.ldap.ssl.keystore.password", "");
			SslSocketFactory.init(applicationContext.getResource(setting.getProperty(keystoreDefKey)), pass);
			//loadKeystore(applicationContext.getResource(setting.getProperty(keystoreDefKey)), pass);
		}
	}

	@Override
	public AuthorizedUserInfo checkAuthorizedUserInfo(String token) {
		return authCache.findToken(token);//登録済み認証トークン情報（存在しない場合null）
	}
	

	/**
	 * AD想定のLDAPsでの直接問い合わせ処理.
	 * @param userName
	 * @param password
	 * @return
	 */
	protected boolean ldapLoginCheck(String userName, String password) throws ServiceException {
		if(StringUtils.isEmpty(ldapAuthorizedUrl)) {
			throw new ServiceException("notAcceptLDAPAuth");//LDAP認証の構成がOFF
		}

		final Hashtable<String, String> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, ldapAuthorizedUrl);
		env.put(Context.SECURITY_PRINCIPAL, userName + ldapAdDomainName);
		env.put(Context.SECURITY_CREDENTIALS, password);
		if(ldapAuthorizedUrl.startsWith("ldaps:")) {
			env.put("java.naming.ldap.factory.socket", "phuongtn2.util.net.SslSocketFactory");
			env.put(Context.SECURITY_PROTOCOL, "ssl");
		}
		DirContext ctx;
		try {
		    ctx = new InitialDirContext(env);
		    ctx.close();//AD認証成功
		    return true;
		} catch (NamingException ex) {
		    //"AD認証失敗";
			ex.printStackTrace();
		}
		return false;
	}

//	/**
//	 * SSL証明書の取り込み
//	 * @param keyResource
//	 * @param keypass
//	 */
//	protected void loadKeystore(org.springframework.core.io.Resource keyResource, String keypass) {
//		try {
//			char[] storePass = keypass.toCharArray();
//			KeyStore keyStore = KeyStore.getInstance("JKS");
//
//			try (InputStream is = keyResource.getInputStream()) {
//				keyStore.load(is, storePass);
//			}
//
//			KeyManagerFactory keyManFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//			keyManFactory.init(keyStore, storePass);
//
//			TrustManagerFactory trustManFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//			trustManFactory.init(keyStore);
//
//			KeyManager[] keyManager = keyManFactory.getKeyManagers();
//			TrustManager[] trustManager = trustManFactory.getTrustManagers();
//
//			SSLContext sslContext = SSLContext.getInstance("SSL");
//			sslContext.init(keyManager, trustManager, null);
//			SSLContext.setDefault(sslContext);
//		} catch (Exception e) {
//			throw new RuntimeException("Failed to load KeyStore", e);
//		}
//	}

	/**
	 * 社員IDからみなし認証情報を生成する.
	 * (内部処理用のためトランザクション対象外)
	 * 通常の認証と異なる部分：
	 * 		TOKENなし・キャッシュ保存なし、実行時事業部指定なし（ロールで事業部実行許可の確認は可能）
	 */
	@Override
	public AuthorizedUserInfo findAuthorizedUserInfoByEmployeeId(int employeeId) throws ServiceException {
		//ユーザ情報をDBから検索
		final AuthorizedUserInfo userInfo = authMapper.findAuthorizedUserInfoByEmployeeId(employeeId);
		if (userInfo != null) {
			userInfo.setIpAddress("");
			userInfo.setComputerName("");
			log.info("ユーザ認証情報確認:" + employeeId);
			//共通の認証関連情報処理
			registerUserInfoUserInfo(userInfo);
		} else {
			log.warn("マニュアルログインNG:" + employeeId);
			throw new ServiceException("noEmpIdUser", employeeId);
		}
		return userInfo;
	}

	/**
	 * SSOのユーザ情報を取得する.
	 *
	 * 現在は暫定的にSSOのユーザが発見されない例外か、固定のみなしユーザを返す。
	 *
	 * @param p ユーザプリンシパル
	 * @return SSOユーザID(SFAのDBに存在するユーザでない場合、あとの処理でエラーになる）
	 * @throws ServiceException SSOのユーザが発見されない場合
	 */
	@Override
	public String findSsoAuthorizedUserId(Principal p) throws ServiceException {
		if(p!=null) {
			return p.getName();
		}
		// TODO SSOのユーザ情報発見処理を確認する ADFS? OAuthなど
		// 処理方法によっては別サーバや別の処理系が必要になる
		throw new ServiceException("noSSOUser");
	}

	/**
	 * 事業部の評価結果が実行できないものの場合例外を発行する
	 * @param aui
	 * @throws ServiceException
	 */
	public void checkAuthorized(AuthorizedUserInfo aui) throws ServiceException {
		switch(aui.getUserId()) {
		case AuthorizedUserInfo.DEPT_NO_LOGIN:
			throw new ServiceException("noLoginRole");
		}
	}

	@Override
	public AuthorizedUserInfo checkGoogleAuthorizedUserInfo(String accessToken, String token, String remoteAddr, String remoteHost) throws ServiceException {
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
				.setAudience(Collections.singletonList(setting.getProperty("authorized.google.client_id")))
				.setIssuer("accounts.google.com")
				.build();

		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(token);
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
		if (idToken != null) {
			GoogleIdToken.Payload payload = idToken.getPayload();

			// Get profile information from payload
			final String email = payload.getEmail(); 
			final AuthorizedUserInfo userInfo = authMapper.findAuthorizedUserInfoByEmail(email);
			if (userInfo == null) {
				throw new ServiceException("noDBGoogleUser", email);
			} else {
				userInfo.setIpAddress(remoteAddr);
				userInfo.setComputerName(remoteHost);
				userInfo.setGoogleToken(accessToken);
				// related authentication information processing
				registerUserInfoUserInfo(userInfo);
			}
			return userInfo;
		}
		throw new ServiceException("noGoogleUserData");
	}

	protected void registerUserInfoUserInfo(AuthorizedUserInfo userInfo)  {

		final int userId = userInfo.getUserId();
		// search and setup user roles
		userInfo.setRoleSet(Role.toRoleList(authMapper.findUserRoleList(userId)));
        final Date createAt = new Date();
        // generate authenticate token
        final String token = TokenGenerator.create(createAt, userInfo.getUserId(), randomTokenLength);
        userInfo.setToken(token);
        userInfo.setCreateAt(createAt);
        // and save it into cache
        authCache.registerUserInfoToken(userInfo);
        userInfo.setNew(true);
	}

	/**
	 * レスポンスヘッダーに認証情報由来の情報を格納する.
	 * 認証フィルターがかかっているか、手動ログインのあとにセットする想定（認証が必須でない処理は対象外）
	 * この処理は有効な認証情報(AuthorizedUserInfo)が存在している必要がある。
	 *
	 * @param mm ヘッダー値
	 * @param aui 認証情報
	 */
	@Override
	public void storeResponseHeader(MultivaluedMap<String, Object> mm, AuthorizedUserInfo aui) {
		if (aui.isNew()) {
			mm.add(ApiDefs.TOKEN_HEADER_NAME, aui.getToken());
			mm.add(ApiDefs.EMPLOYEE_DIVISION_ID_HEADER_NAME, String.valueOf(aui.getDivisionId()));
			mm.add(ApiDefs.EMPLOYEE_DIVISION_NAME_HEADER_NAME, StringUtil.base64EncodeString(aui.getDivisionName()));
			mm.add(ApiDefs.LOGIN_USER_ID_HEADER_NAME, String.valueOf(aui.getUserId()));
			mm.add(ApiDefs.LOGIN_USER_NAME_HEADER_NAME, StringUtil.base64EncodeString(aui.getFullName()));
			mm.add(ApiDefs.ROLE_LIST_HEADER_NAME,
					Role.toHeaderRoleListValue(aui.getRoleSet()));
			mm.add(ApiDefs.AUTH_PROP_NAME, aui);
		}
	}

	/**
	 * キャッシュ中のログイントークンを抹消する.
	 */
	@Override
	public String logoutAuthorizedUserInfo(String token) {
		final AuthorizedUserInfo removed = authCache.removeToken(token);
		return removed != null ? String.valueOf(removed.getLoginName()) : "未登録";
	}

	public void setRandomTokenLength(int len) {
		randomTokenLength = len;
	}

}
