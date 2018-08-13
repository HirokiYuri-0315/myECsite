package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.MasterAddItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAddItemCompleteAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private MasterAddItemCompleteDAO addItemCompleteDAO = new MasterAddItemCompleteDAO();

	// 実行
	public String execute() throws SQLException {

		// データ型をObject -> Stringに変更。
		String name = session.get("addItemName").toString();

		// データ型をintに変更するためのひと手間。
		String priceStr = session.get("addItemPrice").toString();
		int price = new Integer(priceStr);
		String stockStr = session.get("addItemStock").toString();
		int stock = new Integer(stockStr);

		// DAOで定義した addItemInfo(String,int,int) を利用する。
		// データ型を addItemInfo に合わせて整えておいたので、スッキリ挿入。
		addItemCompleteDAO.addItemInfo(name, price, stock);

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
