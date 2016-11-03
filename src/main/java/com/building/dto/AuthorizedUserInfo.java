package com.building.dto;

import phuongtn2.service.Role;

import java.io.Serializable;
import java.util.*;

/**
 * ログインユーザのユーザセッション情報.
 *
 * ログイン時に評価し、トークンキャッシュが残っている間は再評価しない。（作成からタイムアウトを１日程度に設定する予定）
 *
 * @author masahiro.takahashi
 *
 */
public class AuthorizedUserInfo implements Serializable {

	public static final int DEPT_NO_LOGIN = -1;
	public static final int ADMIN = 1;
	/** 社員ID(T_USER->USER_ID) */
	private int userId;
	/** 認証ユーザID（基本的にADID/ローカル認証時はみなしID) */
	private String loginName;
	/** 認証者の所属部署(一般社員は基本的に課。上長は課・センター・事業部などもありうる) T_USER->lDivisionID */
	private int divisionId;
	/** 認証者の所属部署名 */
	private String divisionName;
	/** 認証者の姓名 */
	private String fullName;
	/** 認証者のメールアドレス */
	private String mail;
	/** 認証者のロールグループ名 */
	private String roleGroupName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	/** 所持ロール */
	@SuppressWarnings("unchecked")
	private Set<Role> roleSet = (Set<Role>) Collections.EMPTY_SET;

	/** API実行用Token(ログイン時にルールと乱数発生させる) */
	private String token;
	/**トークン発行年月日 */
	private Date createAt;
	/** この処理で新規作成されたか？ (新規ログイン時に設定する) */
	private boolean isNew;

	/** 認証処理時のホスト名(社員使用PC) */
	private String computerName;
	/** 認証処理時のIPアドレス(社員使用PC) */
	private String ipAddress;
	
	/** google access_token */
	private String googleToken;

	public String getGoogleToken() {
		return googleToken;
	}

	public void setGoogleToken(String googleToken) {
		this.googleToken = googleToken;
	}

	

	//////////////
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Collection<Role> roleCol) {
		this.roleSet = Collections.unmodifiableSet(new HashSet<Role>(roleCol));
	}

	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getRoleGroupName() {
		return roleGroupName;
	}
	public void setRoleGroupName(String roleGroupName) {
		this.roleGroupName = roleGroupName;
	}
	@Override
	public String toString() {
		return "AuthorizedUserInfo [userId=" + userId + ", loginName=" + loginName + ", divisionId=" + divisionId + ", fullName=" + fullName
				+ ", mail=" + mail + ", roleGroupName=" + roleGroupName
				+ ", roleSet=" + roleSet + ", token=" + token + ", createAt=" + createAt + ", isNew=" + isNew + ", computerName=" + computerName + ", ipAddress="
				+ ipAddress + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((computerName == null) ? 0 : computerName.hashCode());
		result = prime * result + ((createAt == null) ? 0 : createAt.hashCode());
		result = prime * result + divisionId;
		result = prime * result + userId;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + (isNew ? 1231 : 1237);
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((roleGroupName == null) ? 0 : roleGroupName.hashCode());
		result = prime * result + ((roleSet == null) ? 0 : roleSet.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorizedUserInfo other = (AuthorizedUserInfo) obj;
		if (computerName == null) {
			if (other.computerName != null)
				return false;
		} else if (!computerName.equals(other.computerName))
			return false;
		if (createAt == null) {
			if (other.createAt != null)
				return false;
		} else if (!createAt.equals(other.createAt))
			return false;
		if (divisionId != other.divisionId)
			return false;
		if (userId != other.userId)
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (isNew != other.isNew)
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (roleGroupName == null) {
			if (other.roleGroupName != null)
				return false;
		} else if (!roleGroupName.equals(other.roleGroupName))
			return false;
		if (roleSet == null) {
			if (other.roleSet != null)
				return false;
		} else if (!roleSet.equals(other.roleSet))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}
	public AuthorizedUserInfo deepClone()  {
		final AuthorizedUserInfo c = new AuthorizedUserInfo();
		c.setComputerName(this.getComputerName());
		c.setCreateAt(cloneDate(this.getCreateAt()));
		c.setDivisionId(this.getDivisionId());
		c.setDivisionName(this.getDivisionName());
		c.setUserId(this.getUserId());
		c.setFullName(this.getFullName());
		c.setIpAddress(this.getIpAddress());
		c.setLoginName(this.getLoginName());
		c.setMail(this.getMail());
		c.setNew(this.isNew());
		c.setRoleGroupName(this.getRoleGroupName());
		c.setRoleSet(new HashSet<Role>(this.getRoleSet()));
		c.setToken(this.getToken());
		c.setFullName(this.getFullName());
		c.setGoogleToken(this.getGoogleToken());
		return c;
	}

	private static Date cloneDate(Date d) {
		return d==null ? null : new Date(d.getTime());
	}
}
