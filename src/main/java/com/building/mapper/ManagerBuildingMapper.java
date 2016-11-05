package com.building.mapper;

import com.building.dto.BuildingDto;
import org.apache.ibatis.annotations.Param;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface ManagerBuildingMapper {
    long insertBuilding(@Param("dto")BuildingDto buildingDto);
}
