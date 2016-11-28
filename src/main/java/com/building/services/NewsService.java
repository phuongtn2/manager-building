package com.building.services;

import com.building.dto.NewsDto;
import com.building.dto.NewsDetailDto;
import com.dropbox.core.ServerException;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface NewsService {
    long insertNews(NewsDto newsDto) throws ServerException;
    List<NewsDto> findAll() throws ServerException;
    NewsDto findById(long id) throws ServerException;
    void update(NewsDto newsDto) throws ServerException;
    void deleteById(long id) throws ServerException;
    //NewsDetail
    long insertNewsDetail(NewsDetailDto newsDetailDto) throws ServerException;
    List<NewsDetailDto> findAllNewsDetailByNewsCode(long newsId) throws ServerException;
    NewsDetailDto findNewsDetailById(long id) throws ServerException;
    void updateNewsDetail(NewsDetailDto newsDetailDto) throws ServerException;
    void deleteNewsDetailById(long id) throws ServerException;
}
