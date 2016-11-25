package com.building.services;

import com.building.dto.BuildingDto;
import com.building.dto.FloorDto;
import com.dropbox.core.ServerException;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface ManagerBuildingService {
    long insertBuilding(BuildingDto buildingDto) throws ServerException;
    List<BuildingDto> findAll() throws ServerException;
    BuildingDto findById(long id) throws ServerException;
    void update(BuildingDto buildingDto) throws ServerException;
    void deleteById(long id) throws ServerException;
    List<FloorDto> findAllFloorByBuildingId(long buildingId) throws ServerException;
    long insertFloor(FloorDto floorDto) throws  ServerException;
}
