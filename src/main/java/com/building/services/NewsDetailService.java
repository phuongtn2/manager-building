package com.building.services;

import com.building.dto.NewsDetailDto;
import com.dropbox.core.ServerException;

import java.util.List;

/**
 * Created by Giang.DaoTu on 11/20/2016.
 */
public interface NewsDetailService {
    long insertNewsDetail(NewsDetailDto newsDetailDto) throws ServerException;
    List<NewsDetailDto> findAll() throws ServerException;
    NewsDetailDto findById(long id) throws ServerException;
    void update(NewsDetailDto newsDetailDto) throws ServerException;
    void deleteById(long id) throws ServerException;
}
