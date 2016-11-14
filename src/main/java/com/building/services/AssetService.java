package com.building.services;

import com.building.dto.AssetDto;
import com.dropbox.core.ServerException;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface AssetService {
    long insertAsset(AssetDto newsDto) throws ServerException;
    List<AssetDto> findAll() throws ServerException;
    AssetDto findById(long id) throws ServerException;
    void update(AssetDto assetDto) throws ServerException;
    void deleteById(long id) throws ServerException;
}
