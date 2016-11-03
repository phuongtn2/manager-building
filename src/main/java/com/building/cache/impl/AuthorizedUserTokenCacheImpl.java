package com.building.cache.impl;

import com.building.cache.AuthorizedUserTokenCache;
import com.building.dto.AuthorizedUserInfo;
import com.building.services.Role;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

//FIXME memcachedなどのキャッシュ層の実装方針が決まるまで暫定でMapを利用
@Service

public class AuthorizedUserTokenCacheImpl implements AuthorizedUserTokenCache {

	/** 認証情報のキャッシュマップ */
	private final HashMap<String, AuthorizedUserInfo> cacheMap = new HashMap<String, AuthorizedUserInfo>();

	/** 認証情報のキャッシュ有効期限(ms) */
	private long expireInterval = 86400000L;
	/*** チェックを行う最小間隔(ms) */
	private long cleaningMinInterval = 600000L;
	/** 前回実行時(初回はクラスロード時間を便宜上つめる) */
	private long previous = System.currentTimeMillis();

	@Override
	public AuthorizedUserInfo findToken(String token) {
		final long now = System.currentTimeMillis();
		synchronized (cacheMap) {
			clean(now);
			return cacheMap.get(token);
		}
	}

	@Override
	public void registerUserInfoToken(AuthorizedUserInfo userInfo) {
		final AuthorizedUserInfo caui = userInfo.deepClone();
		final String token = caui.getToken();
		synchronized (cacheMap) {
			cacheMap.put(token, caui);
		}
	}

	@Override
	public AuthorizedUserInfo removeToken(String token) {
		synchronized (cacheMap) {
			return cacheMap.remove(token);
		}
	}

	/**
	 * キャッシュの経過したデータのクリーニング.
	 *
	 * さほどキャッシュが厳密に消されなくても問題ないので、一定時間(cleaningMinInterval)以上経過したもののみチェックする
	 */
	protected void clean(long now) {
		if (now > previous + cleaningMinInterval) { //最終実行時間から最小実行間隔が経過している
			previous = now;//最終実行時刻を更新
			final long at = now - expireInterval;//このシステムミリ秒より前の場合キャッシュ無効に
			final LinkedList<String> removeKeyList = new LinkedList<String>();
			for (final Map.Entry<String, AuthorizedUserInfo> em : cacheMap.entrySet()) {
				final AuthorizedUserInfo aui = em.getValue();
				if (aui.getCreateAt().getTime() < at) {
					removeKeyList.add(em.getKey());
				}
			}
			for (final String key : removeKeyList) {
				cacheMap.remove(key);
			}
		}
	}

	//DI
	public void setExpireInterval(long interval) {
		expireInterval = interval;
	}

	//DI
	public void setcleaningMinInterval(long cleaningMinInterval) {
		this.cleaningMinInterval = cleaningMinInterval;
	}

	////一時的な試験用認証情報
	@PostConstruct
	public void registerUserInfoBypassAuthToken() {
		synchronized (cacheMap) {
			final AuthorizedUserInfo aui1 = makeAuthorizedUserInfo(//
					101, 21, "adUser1", "A1", "0.0.0.0", "dummyMachine1", false, //
					new Date(), "DUMMY_ROLE_GROUP1", Role.MEMBER, Role.ADMIN);
			registerUserInfoToken(aui1);
		}
	}
	private static AuthorizedUserInfo makeAuthorizedUserInfo(int userID, int divisionID, String adId, String token,//
			String ipAddress, String computerName, boolean isNew, Date createAt, String roleGroupName, Role... roles) {
		final AuthorizedUserInfo aui = new AuthorizedUserInfo();
		aui.setUserId(userID);
		aui.setLoginName(adId);
		aui.setToken(token);
		aui.setIpAddress(ipAddress);
		aui.setComputerName(computerName);
		aui.setNew(isNew);
		aui.setCreateAt(createAt);
		aui.setRoleGroupName(roleGroupName);
		if (roles != null) {
			aui.setRoleSet(Arrays.asList(roles));
		}
		return aui;
	}


}
