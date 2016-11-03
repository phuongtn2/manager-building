package com.building.mapper;

import com.building.dto.AuthorizedUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorizedUserTokenMapper {

	AuthorizedUserInfo findAuthorizedUserInfoByAdId(@Param("loginName") String loginName);
	AuthorizedUserInfo findAuthorizedUserInfoByEmail(@Param("email") String email);
	AuthorizedUserInfo findAuthorizedUserInfoByEmployeeId(@Param("employeeId") int employeeId);
	List<String> findUserRoleList(@Param("employeeId") int employeeId);
}
