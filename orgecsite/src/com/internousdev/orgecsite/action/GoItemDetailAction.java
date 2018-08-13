package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.ItemDataDAO;
import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemDetailAction extends ActionSupport implements SessionAware {

	private ItemDataDAO itemDataDAO = new ItemDataDAO();
	private String selectId;
	public Map<String,Object> session;

	public String execute() throws SQLException {
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
		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}


}
