package com.building.mapper;

import com.building.dto.NewsDetailDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/20/2016.
 */
public interface NewsDetailMapper {
    long insertNewsDetail(@Param("dto") NewsDetailDto newsDetailDto);
    List<NewsDetailDto> findAll();
    NewsDetailDto findById(@Param("id") long id);
    void update(@Param("dto") NewsDetailDto newsDetailDto);
    void deleteById(@Param("id") long id);
}
