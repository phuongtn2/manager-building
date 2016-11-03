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
	private byte userStatus;
	private byte salesFlg;
	private String fullName;
	private String lastName;
	private String firstName;
	private long divisionId;
	private String mail;
	private String tel;
	private String mobilePhone;
	private Date startDay;
	private Date endDay;
	private byte deleteFlg;
	private int gender;
	private Date birthday;
	private long managerId;
	private long centerManagerId;
	private String memo;
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

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(byte userStatus) {
		this.userStatus = userStatus;
	}

	public byte getSalesFlg() {
		return salesFlg;
	}

	public void setSalesFlg(byte salesFlg) {
		this.salesFlg = salesFlg;
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

	public long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(long divisionId) {
		this.divisionId = divisionId;
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

	public byte getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(byte deleteFlg) {
		this.deleteFlg = deleteFlg;
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

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public long getCenterManagerId() {
		return centerManagerId;
	}

	public void setCenterManagerId(long centerManagerId) {
		this.centerManagerId = centerManagerId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
