package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.MasterDeleteItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterDeleteItemCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	// 実行
	public String execute() throws SQLException {

		// deleteItemInfo(String) に合わせ、データ型を調整しておく。
		String deleteId = session.get("deleteId").toString();
		MasterDeleteItemCompleteDAO deleteDAO = new MasterDeleteItemCompleteDAO();
		deleteDAO.deleteItemInfo(deleteId);

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
