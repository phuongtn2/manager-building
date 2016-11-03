package com.building.cache;


import com.building.services.error.ServiceException;

//エンティティデータを期限付きキャッシュし、１回有効なアクセストークンを発行する。
public interface ParameterRegisterTokenCache {

	public String pushEntity(Object obj) throws ServiceException;

	public Object popEntity(String token) throws ServiceException;
}
