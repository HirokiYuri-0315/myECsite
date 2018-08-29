package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.CartInfoDAO;
import com.internousdev.orgecsite.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();
	private ArrayList<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
	private String checkEmptyC;

	public String execute() throws SQLException {
		String result= ERROR;
		// 管理者アカウントは弾く。
		if(session.containsKey("mFlg")){
			return "master";
		}

		if(!session.containsKey("login_user_id")) {
			return ERROR;
		}	/* sessionのidを持たずに（何らかのおかしな操作で）来てしまった場合、エラーとして弾く。 */

		String userId = session.get("login_user_id").toString();
		setCartInfoDTOList(cartInfoDAO.getCartInfo(userId));
		session.put("cartInfoDTOList", cartInfoDTOList);
		checkEmptyC = String.valueOf(cartInfoDTOList.isEmpty());

		result = SUCCESS;
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

	public String getCheckEmptyC() {
		return checkEmptyC;
	}

	public void setCheckEmptyC(String checkEmptyC) {
		this.checkEmptyC = checkEmptyC;
	}

}
