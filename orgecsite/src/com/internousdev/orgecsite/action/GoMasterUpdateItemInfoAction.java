package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.ItemDataDAO;
import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoMasterUpdateItemInfoAction extends ActionSupport implements SessionAware {

	private ItemDataDAO itemDataDAO = new ItemDataDAO();
	public ArrayList<ItemDataDTO> itemList;
	public Map<String, Object> session;

	// 次の画面で商品選択をするので、itemList を準備する。
	public String execute() throws SQLException {
		// 管理者アカウント以外は弾く。
		if(!session.containsKey("mFlg")){
			return "n_master";
		}
		setItemList(itemDataDAO.getNewItemDataInfo());
		session.put("itemList", itemList);
		return SUCCESS;
	}



	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemDataDTO> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemDataDTO> itemList) {
		this.itemList = itemList;
	}

}
