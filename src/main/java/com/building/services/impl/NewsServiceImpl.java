package com.building.services.impl;

import com.building.dto.BuildingDto;
import com.building.dto.NewsDto;
import com.building.mapper.NewsMapper;
import com.building.services.NewsService;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public long insertNews(NewsDto newsDto) throws ServerException {
        return newsMapper.insertNews(newsDto);
    }

    @Override
    public List<NewsDto> findAll() throws ServerException {
        return newsMapper.findAll();
    }
}
