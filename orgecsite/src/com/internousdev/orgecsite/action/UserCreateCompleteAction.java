package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private String errorMessage;

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("loginUserId") && session.containsKey("loginPassword") && session.containsKey("userName")){

			String userId = session.get("loginUserId").toString();
			String password = session.get("loginPassword").toString();
			String userName = session.get("userName").toString();
			if(userId.length() > 16){
				setErrorMessage("ログインIDは16文字以内で設定してください。");
				return result;
			}
			if(password.length() > 16){
				setErrorMessage("パスワードは16文字以内で設定してください。");
				return result;
			}
			if(userName.length() > 50){
				setErrorMessage("ログインIDは50文字以内で設定してください。");
				return result;
			}

			UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
			userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
					session.get("loginPassword").toString(),
					session.get("userName").toString());
			result = SUCCESS;
		}

		session.remove("loginUserId");
		session.remove("loginPassword");
		session.remove("userName");

		return result;
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
