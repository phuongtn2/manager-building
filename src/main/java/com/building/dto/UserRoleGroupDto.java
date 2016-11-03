package com.building.dto;

import java.io.Serializable;
import java.util.Date;

public class UserRoleGroupDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userRoleGroupId;
	private int userId;
	private int roleGroupId;
	private Date startDay;
	private Date endDay;
	private int divisionId;
	private int managerId;
	private int centerManagerId;
	private String memo;
	private Date created;
	private int createId;
	private Date lastUpdate;
	private int updateId;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getRoleGroupId() {
		return roleGroupId;
	}

	public void setRoleGroupId(int roleGroupId) {
		this.roleGroupId = roleGroupId;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getCenterManagerId() {
		return centerManagerId;
	}

	public void setCenterManagerId(int centerManagerId) {
		this.centerManagerId = centerManagerId;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public int getUserRoleGroupId() {
		return userRoleGroupId;
	}

	public void setUserRoleGroupId(int userRoleGroupId) {
		this.userRoleGroupId = userRoleGroupId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
}