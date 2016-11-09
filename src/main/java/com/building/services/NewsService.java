package com.building.services;

import com.building.dto.NewsDto;
import com.dropbox.core.ServerException;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface NewsService {
    long insertNews(NewsDto newsDto) throws ServerException;
    List<NewsDto> findAll() throws ServerException;
}
