package com.building.services.impl;

import com.building.dto.BuildingDto;

import com.building.dto.FloorDto;
import com.building.mapper.ManagerBuildingMapper;
import com.building.services.ManagerBuildingService;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
@Service
public class ManagerBuildingServiceImpl implements ManagerBuildingService {
    @Autowired
    private ManagerBuildingMapper managerBuildingMapper;
    @Override
    public long insertBuilding(BuildingDto buildingDto) throws ServerException {
        return managerBuildingMapper.insertBuilding(buildingDto);
    }
    @Override
    public List<BuildingDto> findAll() throws ServerException {
        return managerBuildingMapper.findAll();
    }

    @Override
    public BuildingDto findById(long id) throws ServerException {
        return managerBuildingMapper.findById(id);
    }

    @Override
    public void update(BuildingDto buildingDto) throws ServerException {
        managerBuildingMapper.update(buildingDto);
    }

    @Override
    public void deleteById(long id) throws ServerException {
        managerBuildingMapper.deleteById(id);
    }

    @Override
    public List<FloorDto> findAllFloorByBuildingId(long buildingId) throws ServerException {
        return managerBuildingMapper.findAllFloorByBuildingId(buildingId);
    }

    @Override
    public long insertFloor(FloorDto floorDto) throws ServerException {
        return managerBuildingMapper.insertFloor(floorDto);
    }
}
