package com.building.services.impl;

import com.building.dto.NewsDetailDto;
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

    @Override
    public NewsDto findById(long id) throws ServerException {
        return newsMapper.findById(id);
    }

    @Override
    public void update(NewsDto newsDto) throws ServerException {
        newsMapper.update(newsDto);
    }

    @Override
    public void deleteById(long id) throws ServerException {
        newsMapper.deleteById(id);
    }

    //NewsDetail

    @Override
    public long insertNewsDetail(NewsDetailDto newsDetailDto) throws ServerException {
        return newsMapper.insertNewsDetail(newsDetailDto);
    }

    @Override
    public List<NewsDetailDto> findAllNewsDetailByNewsCode(long newsId) throws ServerException {
        return newsMapper.findAllNewsDetailByNewsCode(newsId);
    }

    @Override
    public NewsDetailDto findNewsDetailById(long id) throws ServerException {
        return newsMapper.findNewsDetailById(id);
    }

    @Override
    public void updateNewsDetail(NewsDetailDto newsDetailDto) throws ServerException {
        newsMapper.updateNewsDetail(newsDetailDto);
    }

    @Override
    public void deleteNewsDetailById(long id) throws ServerException {
        newsMapper.deleteNewsDetailById(id);
    }
}
