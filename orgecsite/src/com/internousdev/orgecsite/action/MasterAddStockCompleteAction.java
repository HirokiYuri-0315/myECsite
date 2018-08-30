package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAddStockCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException {
		// 管理者アカウント以外は弾く。
		if(!session.containsKey("mFlg")){
			return "n_master";
		}
		int new_stock = Integer.parseInt(session.get("newStock").toString());
		String searchId = session.get("id").toString();
		buyItemCompleteDAO.updateStock(searchId, new_stock);

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
