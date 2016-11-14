package com.building.mapper;

import com.building.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
public interface ManagerUserMapper {
    long insertUser(@Param("dto") UserDto userDto);
    List<UserDto> findAll();
    UserDto findById(@Param("id") long id);
    void update(@Param("dto") UserDto userDto);
    void deleteById(@Param("id") long id);

}
