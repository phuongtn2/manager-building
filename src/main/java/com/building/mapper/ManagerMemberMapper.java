package com.building.mapper;

import com.building.dto.MemberDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
public interface ManagerMemberMapper {
    long insertMember(@Param("dto")MemberDto memberDto);
    List<MemberDto> findAll();
    MemberDto findById(@Param("id")long id);
    void update(@Param("dto")MemberDto memberDto);
    void deleteById(@Param("id")long id);

}
