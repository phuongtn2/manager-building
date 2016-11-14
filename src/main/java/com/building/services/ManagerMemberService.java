package com.building.services;

import com.building.dto.MemberDto;
import com.dropbox.core.ServerException;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
public interface ManagerMemberService {
    long insertMember(MemberDto memberDto) throws ServerException;
    List<MemberDto> findAll() throws ServerException;
    MemberDto findById(long id) throws ServerException;
    void update(MemberDto memberDto) throws ServerException;
    void deleteById(long id) throws ServerException;
}
