package com.building.dto;

/**
 * Created by phuongtn2 on 11/14/2016.
 */
public class AssetDto extends DefaultObjectDto{
    private long assetId;
    private String assetName;
    private byte assetStatus;

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public byte getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(byte assetStatus) {
        this.assetStatus = assetStatus;
    }
}
