package com.building.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by phuongtn2 on 7/11/2016.
 */
public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;
	private String empCode;
	private String adId;
	private String pass;
	private byte userStatus;
	private String fullName;
	private String lastName;
	private String firstName;
	private String mail;
	private String tel;
	private String mobilePhone;
	private Date startDay;
	private Date endDay;
	private byte hideFlg;
	private int gender;
	private Date birthday;
	private String memo;
	private String address;
	private Date created;
	private int createId;
	private Date lastUpdate;
	private int updateId;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getAdId() {
		return adId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(byte userStatus) {
		this.userStatus = userStatus;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public byte getHideFlg() {
		return hideFlg;
	}

	public void setHideFlg(byte hideFlg) {
		this.hideFlg = hideFlg;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return this.address;
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
		this.createId = createId;
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
