package com.internousdev.orgecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int count;
	private String pay;
	private String errorMessage = "";

	private String buyId;

	public String execute() {
		String result;

		session.put("count", count);
		int nowStock = Integer.parseInt(session.get("buyItemStock").toString());
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItemPrice").toString());

		session.put("total_price", intCount * intPrice);
		session.put("newStock", nowStock - intCount);

		String payment;
		/* 支払い方法 payが value=1 の場合とそうでない場合（２択） */
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay", payment);
		} else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}

		// 購入確認画面へ進むかどうかの判定。
		if(nowStock-intCount < 0){
			result = "error";
			setErrorMessage("[!]在庫数が不足しています。");
		}else if(session.containsKey("login_flg")){
			result = SUCCESS;
		}else{
			// ログイン状態に無い場合は、購入前にログインさせたい。
			result = "goLogin";
		}
		return result;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPay(String pay) {
		this.pay = pay;
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

	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

}
