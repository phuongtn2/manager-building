package com.building.dto;

/**
 * Created by Giang.DaoTu on 11/15/2016.
 */
public class RoomDto extends DefaultObjectDto{
    private long roomCode;
    private String roomAlias;
    private long floorCode;
    private int count;
    private byte status;

    public long getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(long roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomAlias() {
        return roomAlias;
    }

    public void setRoomAlias(String roomAlias) {
        this.roomAlias = roomAlias;
    }

    public long getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(long floorCode) {
        this.floorCode = floorCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
