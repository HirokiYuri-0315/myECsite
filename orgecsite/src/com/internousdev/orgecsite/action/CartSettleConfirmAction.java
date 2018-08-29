package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.CartInfoDAO;
import com.internousdev.orgecsite.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartSettleConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	CartInfoDAO cartInfoDAO = new CartInfoDAO();
	private ArrayList<CartInfoDTO> cartInfoDTOList;
	private ArrayList<String> errorMessageList;

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {
		String result = ERROR;

		// 管理者アカウントは弾く。
		if(session.containsKey("mFlg")){
			return "master";
		}

		if(!session.containsKey("cartInfoDTOList")){
			return result;
		}
		cartInfoDTOList = (ArrayList<CartInfoDTO>)session.get("cartInfoDTOList");
		// 決済する。
		setErrorMessageList(cartInfoDAO.kessai(cartInfoDTOList));
		session.remove("cartInfoDTOList");

		result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public ArrayList<CartInfoDTO> getCartInfoDTOList() {
		return cartInfoDTOList;
	}

	public void setCartInfoDTOList(ArrayList<CartInfoDTO> cartInfoDTOList) {
		this.cartInfoDTOList = cartInfoDTOList;
	}

	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}


}
