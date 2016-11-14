package com.building.services.impl;

import com.building.dto.AssetDto;
import com.building.mapper.AssetMapper;
import com.building.services.AssetService;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetMapper assetMapper;
    @Override
    public long insertAsset(AssetDto assetDto) throws ServerException {
        return assetMapper.insertAsset(assetDto);
    }

    @Override
    public List<AssetDto> findAll() throws ServerException {
        return assetMapper.findAll();
    }

    @Override
    public AssetDto findById(long id) throws ServerException {
        return assetMapper.findById(id);
    }

    @Override
    public void update(AssetDto assetDto) throws ServerException {
        assetMapper.update(assetDto);
    }

    @Override
    public void deleteById(long id) throws ServerException {
        assetMapper.deleteById(id);
    }
}
