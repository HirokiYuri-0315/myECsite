package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAddStockCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
	private int new_stock;

	/* 数値かどうかを判定する isNumber() を定義。（拾いもの） */
	public boolean isNumber(String num) {
	    try {
	        Integer.parseInt(num);
	        return true;
	        } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public String execute() throws SQLException {
		// 管理者アカウント以外は弾く。
		if(!session.containsKey("mFlg")){
			return ERROR;
		}

		if(session.containsKey("newStock")&&session.containsKey("id")){
			if(isNumber(session.get("newStock").toString())){
				new_stock = Integer.parseInt(session.get("newStock").toString());
			}
		}else{
			return ERROR;
		}

		String searchId = session.get("id").toString();
		int count = buyItemCompleteDAO.updateStock(searchId, new_stock);
		if(count < 1){
			return ERROR;
		}

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
