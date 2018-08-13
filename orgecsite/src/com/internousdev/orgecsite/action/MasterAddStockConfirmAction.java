package com.internousdev.orgecsite.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.SelectItemDAO;
import com.internousdev.orgecsite.dto.SelectItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAddStockConfirmAction extends ActionSupport implements SessionAware {

	private String addId;
	private String addStockCount;
	public Map<String,Object> session;
	private String errorMessage = "";
	private SelectItemDAO selectItemDAO = new SelectItemDAO();
	public int addStockNum;

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
		String result = "error";
//		String check;
		session.put("newStock", 0.1);

		if(addId == null){
			setErrorMessage("[!] 商品を選択してください。");
		}else if(isNumber(addStockCount)==false){
			setErrorMessage("[!] 在庫数に正しく数値を入力してください。");
			/* ④在庫数が数値でない場合 */
		}else{
			session.put("id", addId);
			session.put("addStock", addStockCount);

			SelectItemDTO selectItemDTO = selectItemDAO.getBuyItemInfo(addId);
			session.put("selectItemName", selectItemDTO.getBuyItemName());
			session.put("selectItemPrice", selectItemDTO.getBuyItemPrice());
			session.put("selectItemStock", selectItemDTO.getBuyItemStock());

			int nowStock = Integer.parseInt(session.get("selectItemStock").toString());
			int addStock = Integer.parseInt(addStockCount);
			addStockNum = addStock;
			session.put("addStockInv", 0 - addStock);
			session.put("newStock", nowStock + addStock);
			result = SUCCESS;
		}

		if(result == "error"){

		}else if(Integer.parseInt(session.get("newStock").toString()) < 0){
			result = "error";
			setErrorMessage("[!] 在庫数がマイナスになってしまいます。");
		}

		return result;
	}

	public String getAddId() {
		return addId;
	}
	public void setAddId(String addId) {
		this.addId = addId;
	}
	public String getAddStockCount() {
		return addStockCount;
	}
	public void setAddStockCount(String addStockCount) {
		this.addStockCount = addStockCount;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
