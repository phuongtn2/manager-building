package com.building.services.impl;

import com.building.dto.UserDto;
import com.building.mapper.ManagerUserMapper;
import com.building.services.ManagerUserService;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
@Service
public class ManagerUserServiceImp implements ManagerUserService {

    @Autowired
    private ManagerUserMapper managerUserMapper;

    @Override
    public long insertUser(UserDto userDto) throws ServerException {
        return managerUserMapper.insertUser(userDto);
    }

    @Override
    public List<UserDto> findAll() throws ServerException {
        return managerUserMapper.findAll();
    }

    @Override
    public UserDto findById(long id) throws ServerException {
        return managerUserMapper.findById(id);
    }

    @Override
    public void update(UserDto userDto) throws ServerException {
        managerUserMapper.update(userDto);
    }

    @Override
    public void deleteById(long id) throws ServerException {
        managerUserMapper.deleteById(id);
    }
}
