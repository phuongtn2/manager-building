package com.building.cache;


import com.building.dto.AuthorizedUserInfo;

public interface AuthorizedUserTokenCache {
	// トークンから権限情報を発見する
	public AuthorizedUserInfo findToken(String token);
	//トークンと権限情報を登録する
	public void registerUserInfoToken(AuthorizedUserInfo userInfo);
	/** 登録済みTokenを抹消する. */
	public AuthorizedUserInfo removeToken(String token);

}
