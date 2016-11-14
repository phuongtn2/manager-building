package com.building.mapper;

import com.building.dto.AssetDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface AssetMapper {
    long insertAsset(@Param("dto") AssetDto assetDto);
    List<AssetDto> findAll();
    AssetDto findById(@Param("id") long id);
    void update(@Param("dto") AssetDto assetDto);
    void deleteById(@Param("id") long id);
}
