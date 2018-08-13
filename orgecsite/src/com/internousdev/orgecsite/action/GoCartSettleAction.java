package com.internousdev.orgecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartSettleAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
//	private int settlePrice;
	private ArrayList<CartInfoDTO> cartInfoDTOList;

	@SuppressWarnings("unchecked")
	public String execute() {
		String result;
		setCartInfoDTOList((ArrayList<CartInfoDTO>)session.get("cartInfoDTOList"));

		result=SUCCESS;
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

}
