package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.ItemDataDAO;
import com.internousdev.orgecsite.dao.SelectItemDAO;
import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.internousdev.orgecsite.dto.SelectItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterDeleteItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private String deleteId;
	private String errorMessage;

	public String execute() throws SQLException {
		String result;
		if(deleteId == null){
			setErrorMessage("[!] 商品を選択してください。");
			result = "nullError";
		}else{
		session.put("deleteId", deleteId);

		// DTOでこれ用の箱も用意し、SelectItemDAO で getDeleteItemInfo(String deleteId) を定義しておいた。
		// selectItemDTO に必要な情報を収納。
		SelectItemDAO selectItemDAO = new SelectItemDAO();
		SelectItemDTO selectItemDTO = selectItemDAO.getDeleteItemInfo(deleteId);

		// selectItemDTO からセッションへ情報を移す。
		session.put("deleteItemName", selectItemDTO.getDeleteItemName());
		session.put("deleteItemPrice", selectItemDTO.getDeleteItemPrice());

		ItemDataDAO itemDataDAO = new ItemDataDAO();
		ItemDataDTO anItemAllDataDTO = itemDataDAO.getAnItemData(deleteId);
		session.put("selectId", anItemAllDataDTO.getId());
		session.put("selectItemName", anItemAllDataDTO.getItemName());
		session.put("selectItemPrice", anItemAllDataDTO.getItemPrice());
		session.put("selectItemStock", anItemAllDataDTO.getItemStock());
		session.put("selectItemNameKana", anItemAllDataDTO.getItemNameKana());
		session.put("selectItemDescription", anItemAllDataDTO.getItemDescription());
		session.put("selectImageFilePath", anItemAllDataDTO.getImageFilePath());
		session.put("selectImageFileName", anItemAllDataDTO.getImageFileName());
		session.put("selectCategoryId", anItemAllDataDTO.getCategoryId());
		session.put("selectItemReleaseCompany", anItemAllDataDTO.getItemReleaseCompany());
		result = SUCCESS;
		}
		return result;
	}


	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
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
