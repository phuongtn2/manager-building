package com.building.services;

import com.building.dto.AuthorizedUserInfo;
import com.building.services.error.ServiceException;

import javax.ws.rs.core.MultivaluedMap;
import java.security.Principal;

public interface AuthorizedUserTokenService {
	// 認証トークンによる既存認証情報検索
	AuthorizedUserInfo checkAuthorizedUserInfo(String token);
	
	//社員IDから社員の情報を参照する
	AuthorizedUserInfo findAuthorizedUserInfoByEmployeeId(int employeeId) throws ServiceException;

	// ログアウト処理(認証済みTokenの抹消)を行う
	String logoutAuthorizedUserInfo(String token);

	// SSO認証ユーザの取得
	String findSsoAuthorizedUserId(Principal p) throws ServiceException;

	// 認証結果のレスポンスヘッダー反映
	void storeResponseHeader(MultivaluedMap<String, Object> mm, AuthorizedUserInfo aui);

	// 認証後のログイン・事業部ロールの確認
	void checkAuthorized(AuthorizedUserInfo aui) throws ServiceException;

	//AuthorizedUserInfo checkGoogleAuthorizedUserInfo(String accessToken, String token,
													 //String remoteAddr, String remoteHost) throws ServiceException;
	AuthorizedUserInfo doLogin(String userName, String passw) throws ServiceException;

}
