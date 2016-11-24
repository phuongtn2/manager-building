package com.building.dto;

/**
 * Created by Giang.DaoTu on 11/15/2016.
 */
public class NewsDetailDto {
    private Long newCode;
    private Long refNewCode;
    private String newContent;

    public Long getNewCode() {
        return newCode;
    }

    public void setNewCode(Long newCode) {
        this.newCode = newCode;
    }

    public Long getRefNewCode() {
        return refNewCode;
    }

    public void setRefNewCode(Long refNewCode) {
        this.refNewCode = refNewCode;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }


}
