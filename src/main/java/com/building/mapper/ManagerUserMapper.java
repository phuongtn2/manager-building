package com.building.mapper;

import com.building.dto.UserDto;
import com.building.dto.UserRoleGroupDto;
import com.building.dto.UserRoomDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
public interface ManagerUserMapper {
    int insertUser(@Param("dto") UserDto userDto);
    List<UserDto> findAll();
    UserDto findById(@Param("id") long id);
    void update(@Param("dto") UserDto userDto);
    void deleteById(@Param("id") long id);
    int insertUserRoleGroup(@Param("dto") UserRoleGroupDto userRoleGroupDto );
    long insertUserRoom(@Param("dto") UserRoomDto userRoomDto);
}
