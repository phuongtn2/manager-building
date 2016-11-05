package com.building.services.impl;

import com.building.dto.BuildingDto;
import com.building.mapper.ManagerBuildingMapper;
import com.building.services.ManagerBuildingService;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
