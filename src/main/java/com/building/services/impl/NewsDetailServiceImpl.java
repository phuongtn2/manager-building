package com.building.services.impl;

import com.building.dto.NewsDetailDto;
import com.building.mapper.NewsDetailMapper;
import com.building.services.NewsDetailService;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Giang.DaoTu on 11/20/2016.
 */
@Service
public class NewsDetailServiceImpl implements NewsDetailService {
    @Autowired
    private NewsDetailMapper newsDetailMapper;
    @Override
    public long insertNewsDetail(NewsDetailDto newsDetailDto) throws ServerException {
        return newsDetailMapper.insertNewsDetail(newsDetailDto);
    }

    @Override
    public List<NewsDetailDto> findAll() throws ServerException {
        return newsDetailMapper.findAll();
    }

    @Override
    public NewsDetailDto findById(long id) throws ServerException {
        return newsDetailMapper.findById(id);
    }

    @Override
    public void update(NewsDetailDto newsDetailDto) throws ServerException {
        newsDetailMapper.update(newsDetailDto);
    }

    @Override
    public void deleteById(long id) throws ServerException {
        newsDetailMapper.deleteById(id);
    }
}
