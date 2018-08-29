package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.CartInfoDAO;
import com.internousdev.orgecsite.dao.SelectItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCartAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();

	private String buyId;

	public String execute() throws SQLException {
		String result = ERROR;

		SelectItemDAO selectItemDao = new SelectItemDAO();
		String check = selectItemDao.checkSelectId(buyId);
		if(check.equals("false")){
			return result;
		}

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

	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}
}
