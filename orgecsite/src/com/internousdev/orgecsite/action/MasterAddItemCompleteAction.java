package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.MasterAddItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAddItemCompleteAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private MasterAddItemCompleteDAO addItemCompleteDAO = new MasterAddItemCompleteDAO();
	private String errorMessage;

	public String execute() throws SQLException {
		String result = ERROR;

		// 必要な情報があるかどうか確認する。
		if(!session.containsKey("addItemName")||!session.containsKey("addItemPrice")||!session.containsKey("addItemStock")){
			return result;
		}

		// データ型をObject -> Stringに変更。
		String name = session.get("addItemName").toString();
		if(name.length() > 30){
			setErrorMessage("[!] 商品名は30文字以内で設定してください。");
			return result;
		}
		// データ型をintに変更するためのひと手間。
		String priceStr = session.get("addItemPrice").toString();
		int price = new Integer(priceStr);
		String stockStr = session.get("addItemStock").toString();
		int stock = new Integer(stockStr);

		// DAOで定義した addItemInfo(String,int,int) を利用する。
		// データ型を addItemInfo に合わせて整えておいたので、スッキリ挿入。
		addItemCompleteDAO.addItemInfo(name, price, stock);

		session.remove("addItemPrice");
		session.remove("addItemStock");
		result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
