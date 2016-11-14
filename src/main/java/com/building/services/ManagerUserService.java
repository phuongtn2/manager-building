package com.building.services;

import com.building.dto.UserDto;
import com.dropbox.core.ServerException;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
public interface ManagerUserService {
    long insertUser(UserDto userDto) throws ServerException;
    List<UserDto> findAll() throws ServerException;
    UserDto findById(long id) throws ServerException;
    void update(UserDto userDto) throws ServerException;
    void deleteById(long id) throws ServerException;
}
