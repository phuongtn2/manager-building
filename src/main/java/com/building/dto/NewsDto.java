package com.building.dto;

import java.util.Date;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public class NewsDto extends DefaultObjectDto {
    private long newCode;
    private byte newType;
    private String newHeader;
    private String newShorter;

    public long getNewCode() {
        return newCode;
    }

    public void setNewCode(long newCode) {
        this.newCode = newCode;
    }

    public byte getNewType() {
        return newType;
    }

    public void setNewType(byte newType) {
        this.newType = newType;
    }

    public String getNewHeader() {
        return newHeader;
    }

    public void setNewHeader(String newHeader) {
        this.newHeader = newHeader;
    }

    public String getNewShorter() {
        return newShorter;
    }

    public void setNewShorter(String newShorter) {
        this.newShorter = newShorter;
    }
}
