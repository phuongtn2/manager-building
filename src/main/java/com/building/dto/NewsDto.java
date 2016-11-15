package com.building.dto;

import java.util.Date;

/**
 * Created by PhuongTN1 on 11/4/2016.
 */
public class NewsDto extends DefaultObjectDto {
    private long newsCode;
    private byte newsType;
    private String newHeader;
    private String newShorter;

    public long getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(long newsCode) {
        this.newsCode = newsCode;
    }

    public byte getNewsType() {
        return newsType;
    }

    public void setNewsType(byte newsType) {
        this.newsType = newsType;
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
