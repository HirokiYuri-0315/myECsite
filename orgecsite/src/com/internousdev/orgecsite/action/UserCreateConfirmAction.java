package com.internousdev.orgecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.LoginDAO;
import com.internousdev.orgecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;

	public String execute() {

		String result = ERROR;
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		// ログインIDが他と被るとおかしくなるのでそれは避けたい。（ログインIDは固有のものにしたい）
		loginDTO = loginDAO.checkLoginIdInfo(loginUserId);
		String anotherId = loginDTO.getDoubleId();
		if(loginUserId.equals(anotherId)){
			setErrorMessage("[!] そのログインIDは登録済みです。");
			result = ERROR;
		}
		else if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))) {
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
			result = SUCCESS;
		} else {
			setErrorMessage("[!] 未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
