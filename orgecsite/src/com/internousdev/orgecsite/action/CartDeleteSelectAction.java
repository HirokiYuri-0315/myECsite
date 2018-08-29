package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.CartInfoDAO;
import com.internousdev.orgecsite.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteSelectAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private String deleteId;
	private ArrayList<CartInfoDTO> cartInfoDTOList;
	private String checkEmptyC;

	public String execute() throws SQLException{
		String result = ERROR;

		// 管理者アカウントは弾く。
		if(session.containsKey("mFlg")){
			return "master";
		}

		CartInfoDAO cartInfoDao = new CartInfoDAO();
		// 削除対象が存在するか確認。
		String check = cartInfoDao.checkCartId(deleteId);
		if(check.equals("false")){
			return result;
		}

		// カート情報をひとつ削除する。
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		String cartId = deleteId;
		cartInfoDAO.selectDelete(cartId);

		// 削除後、改めてカート情報を取得。
		CartInfoDAO cartInfoDAO2 = new CartInfoDAO();
		String userId = session.get("login_user_id").toString();
		setCartInfoDTOList(cartInfoDAO2.getCartInfo(userId));
		session.put("cartInfoDTOList", cartInfoDTOList);

		checkEmptyC = String.valueOf(cartInfoDTOList.isEmpty());

		result=SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public ArrayList<CartInfoDTO> getCartInfoDTOList() {
		return cartInfoDTOList;
	}
	public void setCartInfoDTOList(ArrayList<CartInfoDTO> cartInfoDTOList) {
		this.cartInfoDTOList = cartInfoDTOList;
	}
	public String getCheckEmptyC() {
		return checkEmptyC;
	}
	public void setCheckEmptyC(String checkEmptyC) {
		this.checkEmptyC = checkEmptyC;
	}


}
