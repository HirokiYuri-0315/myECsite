package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException {
	/*
		// 購入情報の書き込み。
		buyItemCompleteDAO1.buyItemInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());

		// 在庫数の変動処理。
		int buy_count = new Integer(session.get("count").toString());
		buyItemCompleteDAO2.buyStockDecriment(session.get("id").toString(), buy_count);

	*/
		String result;
		if(session.get("login_user_id").equals(null)){
			result = "loginError";
		}else{
		System.out.println("==<>--<>==");
		// 購入情報の書き込みと、在庫数の変動処理を合わせて行う。
		int new_stock = Integer.parseInt(session.get("newStock").toString());
		buyItemCompleteDAO.buyItemInfoStock(session.get("id").toString(), session.get("login_user_id").toString(), session.get("total_price").toString(), session.get("count").toString(), session.get("pay").toString(), new_stock);

		System.out.println("==<>--<>==");
		result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
