package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.ItemDataDAO;
import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterUpdateItemInfoSelectAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private String selectId;
	private String errorMessage = "";
	private ItemDataDAO itemDataDAO = new ItemDataDAO();
	public String execute() throws SQLException {
		String result;
		// 受け取る値は selectId（商品ID）で、それを元に情報取得へ。
		if(selectId == null){
			// 商品が選択されていない場合。
			result="nullError";
			setErrorMessage("[!] 商品を選択してください。");
		}else{
			// 商品の詳細情報を準備。DBから読み出した情報をDTOに格納した後、セッションに移す。後付。
			ItemDataDTO anItemAllDataDTO = itemDataDAO.getAnItemData(selectId);
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

			String imageInfo = anItemAllDataDTO.getImageFilePath().toString() + "/" + anItemAllDataDTO.getImageFileName().toString();
			session.put("selectImageInfo", imageInfo);
			result = SUCCESS;
		}
		return result;
	}


	public String getSelectId() {
		return selectId;
	}
	public void setSelectId(String selectId) {
		this.selectId = selectId;
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
