package com.building.services.impl;

import com.building.dto.MemberDto;

import com.building.mapper.ManagerMemberMapper;
import com.building.services.ManagerMemberService;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
@Service
public class ManagerMemberServiceImp implements ManagerMemberService {
    @Autowired
    private ManagerMemberMapper managerMemberMapper;
    @Override
    public long insertMember(MemberDto memberDto) throws ServerException {
        return managerMemberMapper.insertMember(memberDto);
    }
    @Override
    public List<MemberDto> findAll() throws ServerException{
        return managerMemberMapper.findAll();
    }

    @Override
    public MemberDto findById(long id) throws ServerException {
        return managerMemberMapper.findById(id);
    }

    @Override
    public void update(MemberDto memberDto) throws ServerException {
        managerMemberMapper.update(memberDto);
    }

    @Override
    public void deleteById(long id) throws ServerException {
        managerMemberMapper.deleteById(id);
    }
}
