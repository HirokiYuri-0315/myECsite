package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterUpdateItemInfoConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException{
		String result;
		// 管理者アカウント以外は弾く。
		if(!session.containsKey("mFlg")){
			return "n_master";
		}
		// DAOの updateItemInfo メソッドに対応する変数を準備する。
		int selectId = Integer.parseInt(session.get("selectId").toString());
		String updateItemName = session.get("updateItemName").toString();
		String updateItemNameKana = session.get("updateItemNameKana").toString();
		int updateItemPrice = Integer.parseInt(session.get("updateItemPrice").toString());
		int updateItemStock = Integer.parseInt(session.get("selectItemStock").toString());
		String updateItemReleaseCompany = session.get("updateItemReleaseCompany").toString();
		int updateCategoryId = Integer.parseInt(session.get("updateCategoryId").toString());
		String updateItemDescription = session.get("updateItemDescription").toString();
		String updateImageFilePath = session.get("updateImageFilePath").toString();
		String updateImageFileName = session.get("updateImageFileName").toString();

		// DAOでDBとやりとり。情報の更新を行う。
		buyItemCompleteDAO.updateItemInfo(selectId, updateItemName, updateItemNameKana, updateItemPrice, updateItemStock, updateItemReleaseCompany, updateCategoryId, updateItemDescription, updateImageFilePath, updateImageFileName);
		result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
