package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.ItemDataDAO;
import com.internousdev.orgecsite.dao.LoginDAO;
import com.internousdev.orgecsite.dao.LoginMasterDAO;
import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.internousdev.orgecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction2 extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;

	public ArrayList<ItemDataDTO> itemList;

	private String errorMessage;
	private String buyFlg = "";

	public String execute() throws SQLException {
		String result = ERROR;
		setErrorMessage("");
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		// MASTER画面へのログイン用に追加。
		LoginMasterDAO loginMasterDAO = new LoginMasterDAO();
		LoginDTO loginMDTO = new LoginDTO();
		loginMDTO = loginMasterDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginMUser", loginMDTO);

		if(((LoginDTO)session.get("loginMUser")).getLoginMFlg()) {
			// 管理者アカウントとしてヒットしたら master を返す。
			// 管理者ページへ飛ぶだけなので他には特に必要なし。
			result = "master";
			session.put("login_user_id", loginMDTO.getLoginId());
		}
		else if(((LoginDTO)session.get("loginUser")).getLoginFlg()) {
			// 一般ユーザーとしてログイン成功。
			result = "success";
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("login_user_name", loginDTO.getUserName());
			session.put("login_flg", loginDTO.getLoginFlg());
			/* 通常のログインに成功したら商品購入ページへと進むので、商品データの準備。 */
			/* itemList を selectItem.jsp で表示したい。*/
			ItemDataDAO itemDataDAO = new ItemDataDAO();
			setItemList(itemDataDAO.getItemDataInfo());
			session.put("itemList", itemList);
		} else {
			/* if文にかからない => 入力情報が誤り。未登録情報。 */
			setErrorMessage("＜＜ 入力内容に誤りがあります ＞＞");	/* 追加 */
		}

		if(result.equals("success") && buyFlg.equals("1")){
			// 購入ページ手前でログインを求めた場合のやつ。
			result = "goBuyPage";
		}
		return result;
	}


	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/* 追加 */
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public ArrayList<ItemDataDTO> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemDataDTO> itemList) {
		this.itemList = itemList;
	}


	public String getBuyFlg() {
		return buyFlg;
	}


	public void setBuyFlg(String buyFlg) {
		this.buyFlg = buyFlg;
	}

}
