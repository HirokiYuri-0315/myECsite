package com.internousdev.orgecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MasterAddItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private String addItemName;
	private String addItemPrice;
	private String addItemStock;

	private String errorMessage;
	private String errorMessage2;
	private String errorMessage3;

	/* 数値かどうかを判定する isNumber() を定義。（拾いもの） */
	public boolean isNumber(String num) {
	    try {
	        Integer.parseInt(num);
	        return true;
	        } catch (NumberFormatException e) {
	        return false;
	    }
	}

	/* 実行 */
	public String execute() {

		String result = ERROR;

		if(addItemName.length() > 30){
			setErrorMessage("[!] 商品名は30文字以内で設定してください。");
			return result;
		}
		if((addItemName.equals("") || (addItemPrice.equals("")) || (addItemStock.equals("")))) {
			setErrorMessage("[!] 未入力の項目があります。");
			result = ERROR;
			/* ①未入力の項目がある場合 */
		}else if(isNumber(addItemPrice)==false){
			setErrorMessage2("[!] 価格に正しく数値を入力してください。");
			/* ②価格が数値でない場合 */
		}else if(Integer.parseInt(addItemPrice) < 0){
			setErrorMessage2("[!] 価格がマイナスに設定されています。");
			/* ③価格がマイナスの値である場合 */
		}else if(isNumber(addItemStock)==false){
			setErrorMessage3("[!] 在庫数に正しく数値を入力してください。");
			/* ④在庫数が数値でない場合 */
		}else if(Integer.parseInt(addItemStock) < 0){
			setErrorMessage3("[!] 在庫数がマイナスに設定されています。");
			/* ⑤在庫数がマイナスの値である場合 */
		}else{
			session.put("addItemName", addItemName);
			int addItemPriceN = Integer.parseInt(addItemPrice);	// 文字列→10進数の整数？
			session.put("addItemPrice", addItemPriceN);
			int addItemStockN = Integer.parseInt(addItemStock);	// 文字列→10進数の整数？
			session.put("addItemStock", addItemStockN);
			result = SUCCESS;
		}
		return result;
	}


	public String getAddItemName() {
		return addItemName;
	}
	public void setAddItemName(String addItemName) {
		this.addItemName = addItemName;
	}

	public String getAddItemPrice() {
		return addItemPrice;
	}
	public void setAddItemPrice(String addItemPrice) {
		this.addItemPrice = addItemPrice;
	}

	public String getAddItemStock() {
		return addItemStock;
	}
	public void setAddItemStock(String addItemStock) {
		this.addItemStock = addItemStock;
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

	public String getErrorMessage2() {
		return errorMessage2;
	}
	public void setErrorMessage2(String errorMessage2) {
		this.errorMessage2 = errorMessage2;
	}

	public String getErrorMessage3() {
		return errorMessage3;
	}
	public void setErrorMessage3(String errorMessage3) {
		this.errorMessage3 = errorMessage3;
	}

}
