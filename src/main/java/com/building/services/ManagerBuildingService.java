package com.building.services;

import com.building.dto.BuildingDto;
import com.dropbox.core.ServerException;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public interface ManagerBuildingService {
    long insertBuilding(BuildingDto buildingDto) throws ServerException;
}
