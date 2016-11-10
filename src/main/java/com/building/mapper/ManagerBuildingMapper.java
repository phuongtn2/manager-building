package com.building.mapper;

import com.building.dto.BuildingDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface ManagerBuildingMapper {
    long insertBuilding(@Param("dto")BuildingDto buildingDto);
    List<BuildingDto> findAll();
    BuildingDto findById(@Param("id") long id);
    void update(@Param("dto") BuildingDto buildingDto);
    void deleteById(@Param("id") long id);
}
