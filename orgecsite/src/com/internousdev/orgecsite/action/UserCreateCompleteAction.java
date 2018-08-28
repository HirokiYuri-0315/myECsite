package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("loginUserId") && session.containsKey("loginPassword") && session.containsKey("userName")){
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

}
