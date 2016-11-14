package com.building.dto;

import java.util.Date;

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */
public class MemberDto {
    private long memberId;
    private String fullName;
    private byte hideFlg;
    private long tel;
    private String address;
    private byte sex;
    private Date birthday;
    private String email;
    private long idCard;
    private Date created;
    private int createId;
    private Date lastUpdate;
    private int updateId;

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public byte getHideFlg() {
        return hideFlg;
    }

    public void setHideFlg(byte hideFlg) {
        this.hideFlg = hideFlg;
    }

    public long getTel (){
        return tel;
    }
    public void setTel (long tel){
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public Date getBirthday (){
        return birthday;
    }

    public void setBirthday (Date birthday){
        this.birthday = birthday;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail ( String email){
        this.email = email;
    }

    public long getIdCard (){
        return idCard;
    }

    public void setIdCard (long idCard){
        this.idCard = idCard;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCreateId() {
        return createId;
    }

    public void setCreateId(int createId) {
        this.createId= createId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }
}
