package com.internousdev.orgecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.SelectItemDAO;
import com.internousdev.orgecsite.dto.SelectItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterDeleteItemConfirmAction extends ActionSupport implements SessionAware {


	public Map<String,Object> session;
	private SelectItemDAO selectItemDAO = new SelectItemDAO();
	private String deleteId;
	private String errorMessage;

	public String execute() {
		String result;
		if(deleteId == null){
			result = "nullError";
			setErrorMessage("[!] 商品を選択してください。");
		}else{
		session.put("deleteId", deleteId);

		// DTOでこれ用の箱も用意し、SelectItemDAO で getDeleteItemInfo(String deleteId) を定義しておいた。
		// selectItemDTO に必要な情報を収納。
		SelectItemDTO selectItemDTO = selectItemDAO.getDeleteItemInfo(deleteId);

		// selectItemDTO からセッションへ情報を移す。
		session.put("deleteItemName", selectItemDTO.getDeleteItemName());
		session.put("deleteItemPrice", selectItemDTO.getDeleteItemPrice());
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
