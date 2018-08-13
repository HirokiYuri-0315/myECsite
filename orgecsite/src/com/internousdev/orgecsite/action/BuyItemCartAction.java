package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.CartInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCartAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();

	public String execute() throws SQLException {
		String result;

		int itemId = Integer.parseInt(session.get("id").toString());
		String userId = session.get("login_user_id").toString();
		int subtotalCount = Integer.parseInt(session.get("count").toString());
		int subtotalPrice = Integer.parseInt(session.get("total_price").toString());
		String payment = session.get("pay").toString();
		cartInfoDAO.addCartInfo(itemId, userId, subtotalCount, subtotalPrice, payment);
		result = SUCCESS;
		return result;
	}


	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
