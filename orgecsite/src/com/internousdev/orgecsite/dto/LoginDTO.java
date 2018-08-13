package com.internousdev.orgecsite.dto;

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
	private boolean loginMFlg = false;
	private String doubleId;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

	public boolean getLoginMFlg() {
		return loginMFlg;
	}
	public void setLoginMFlg(boolean loginMFlg) {
		this.loginMFlg = loginMFlg;
	}

	public String getDoubleId() {
		return doubleId;
	}
	public void setDoubleId(String doubleId) {
		this.doubleId = doubleId;
	}

}
