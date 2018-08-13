package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.BuyItemCompleteDAO2;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmActionText extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO2 buyItemCompleteDAO2 = new BuyItemCompleteDAO2();

	public String execute() throws SQLException {
		System.out.println("DAO2を使用します。");
		buyItemCompleteDAO2.buyItemInfo(session.get("id").toString(),session.get("login_user_id").toString(),session.get("total_price").toString(),session.get("count").toString(),session.get("pay").toString());

	//	int buy_count = new Integer(session.get("count").toString());

		String result = SUCCESS;
		return result;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
