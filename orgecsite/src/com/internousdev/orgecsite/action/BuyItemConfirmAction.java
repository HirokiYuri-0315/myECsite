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
		String result;

		// 管理者アカウントは弾く。
		if(session.containsKey("mFlg")){
			return "master";
		}

		if(session.get("login_user_id").equals(null)){
			result = "loginError";
		}else{
			// 購入情報の書き込みと、在庫数の変動処理を合わせて行う。
			int new_stock = Integer.parseInt(session.get("newStock").toString());

			buyItemCompleteDAO.buyItemInfoStock(session.get("id").toString(),
					session.get("login_user_id").toString(),
					session.get("total_price").toString(),
					session.get("count").toString(),
					session.get("pay").toString(), new_stock);
			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
