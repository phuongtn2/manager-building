package com.building.dto;

import java.util.Date;

/**
 * Created by Giang.DaoTu on 11/15/2016.
 */
public class BookService {
    private long serviceCode;
    private int userId;
    private long assetCode;
    private Date bookFrom;
    private Date bookTo;
    private byte status;
    private byte followStatus;

    public long getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(long serviceCode) {
        this.serviceCode = serviceCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(long assetCode) {
        this.assetCode = assetCode;
    }

    public Date getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(Date bookFrom) {
        this.bookFrom = bookFrom;
    }

    public Date getBookTo() {
        return bookTo;
    }

    public void setBookTo(Date bookTo) {
        this.bookTo = bookTo;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(byte followStatus) {
        this.followStatus = followStatus;
    }
}
