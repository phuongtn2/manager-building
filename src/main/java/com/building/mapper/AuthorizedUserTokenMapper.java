package com.building.mapper;

import phuongtn2.dto.AuthorizedUserInfo;
import phuongtn2.dto.LoginLogDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorizedUserTokenMapper {

	AuthorizedUserInfo findAuthorizedUserInfoByAdId(@Param("loginName") String loginName);
	AuthorizedUserInfo findAuthorizedUserInfoByEmail(@Param("email") String email);
	AuthorizedUserInfo findAuthorizedUserInfoByEmployeeId(@Param("employeeId") int employeeId);
	List<String> findUserRoleList(@Param("employeeId") int employeeId);
	void registLogingLog(@Param("dto") LoginLogDto loginLog);
}
