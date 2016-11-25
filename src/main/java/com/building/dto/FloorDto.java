package com.building.dto;

/**
 * Created by Giang.DaoTu on 11/15/2016.
 */
public class FloorDto extends DefaultObjectDto{
    private long floorCode;
    private int floorSeq;
    private String floorAlias;
    private byte floorType;
    private long buildingCode;
    private int totalRoom;

    public long getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(long floorCode) {
        this.floorCode = floorCode;
    }

    public int getFloorSeq() {
        return floorSeq;
    }

    public void setFloorSeq(int floorSeq) {
        this.floorSeq = floorSeq;
    }

    public String getFloorAlias() {
        return floorAlias;
    }

    public void setFloorAlias(String floorAlias) {
        this.floorAlias = floorAlias;
    }

    public byte getFloorType() {
        return floorType;
    }

    public void setFloorType(byte floorType) {
        this.floorType = floorType;
    }

    public long getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(long buildingCode) {
        this.buildingCode = buildingCode;
    }

    public int getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }
}
