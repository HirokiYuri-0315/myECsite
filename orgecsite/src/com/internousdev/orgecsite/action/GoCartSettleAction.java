package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.CartInfoDAO;
import com.internousdev.orgecsite.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartSettleAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
//	private int settlePrice;
	private ArrayList<CartInfoDTO> cartInfoDTOList;

	private int cashTotalPrice;
	private int creditTotalPrice;

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {
		String result = ERROR;

		// 管理者アカウントは弾く。
		if(session.containsKey("mFlg")){
			return "master";
		}

		setCartInfoDTOList((ArrayList<CartInfoDTO>)session.get("cartInfoDTOList"));

		if(!session.containsKey("login_user_id")){
			return result;
		}else{
			String userId = session.get("login_user_id").toString();
			CartInfoDAO cartInfoDAO1 = new CartInfoDAO();
			cashTotalPrice = cartInfoDAO1.calculateCashPrice(userId);

			CartInfoDAO cartInfoDAO2 = new CartInfoDAO();
			creditTotalPrice = cartInfoDAO2.calculateCreditPrice(userId);

			result=SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartInfoDTO> getCartInfoDTOList() {
		return cartInfoDTOList;
	}

	public void setCartInfoDTOList(ArrayList<CartInfoDTO> cartInfoDTOList) {
		this.cartInfoDTOList = cartInfoDTOList;
	}

	public int getCashTotalPrice() {
		return cashTotalPrice;
	}

	public void setCashTotalPrice(int cashTotalPrice) {
		this.cashTotalPrice = cashTotalPrice;
	}

	public int getCreditTotalPrice() {
		return creditTotalPrice;
	}

	public void setCreditTotalPrice(int creditTotalPrice) {
		this.creditTotalPrice = creditTotalPrice;
	}

}
