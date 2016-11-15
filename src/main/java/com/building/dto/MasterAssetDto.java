package com.building.dto;

import java.util.Date;

/**
 * Created by phuongtn2 on 11/14/2016.
 */
public class MasterAssetDto extends DefaultObjectDto{
    private long buildingCode;
    private long assetCode;
    private byte assetType;
    private String assetName;
    private Date dateFrom;
    private Date dateTo;

    public long getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(long buildingCode) {
        this.buildingCode = buildingCode;
    }

    public long getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(long assetCode) {
        this.assetCode = assetCode;
    }

    public byte getAssetType() {
        return assetType;
    }

    public void setAssetType(byte assetType) {
        this.assetType = assetType;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
