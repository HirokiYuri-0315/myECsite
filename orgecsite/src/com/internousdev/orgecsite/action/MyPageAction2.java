package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.MyPageDAO2;
import com.internousdev.orgecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction2 extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private MyPageDAO2 myPageDAO2 = new MyPageDAO2();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private ArrayList<MyPageDTO> myPageList2 = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	public String checkEmpty;

	/* user_master_id のみから動作するもの */
	public String execute2() throws SQLException{

		// 管理者アカウントは弾く。
		if(session.containsKey("mFlg")){
			return "master";
		}
		// sessionのidを持たずに（何らかのおかしな操作で）来てしまった場合、エラーとして弾く。
		if(!session.containsKey("login_user_id")) {
			return ERROR;
		}
		if(deleteFlg == null) {
			String user_master_id = session.get("login_user_id").toString();
			myPageList2 = myPageDAO2.getMyPageUserInfo3(user_master_id);
			checkEmpty = String.valueOf(myPageList2.isEmpty());
			/* myPageList2 を myPage.jsp で表示する。*/
		} else if(deleteFlg.equals("1")) {
			delete2();
		}

		String result = SUCCESS;
		return result;
	}

	// user_master_id のみから動作するもの。
	// 購入情報からユーザーIDが一致するものを検索し、削除する。
	public void delete2() throws SQLException {
		String user_master_id = session.get("login_user_id").toString();
		int res = myPageDAO2.buyItemHistoryDelete2(user_master_id);
		if(res > 0) {
			myPageList2 = null;
			setMessage("商品情報を正しく削除しました。");
		} else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;
	}
	public ArrayList<MyPageDTO> getMyPageList2() {
		return this.myPageList2;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void setMyPageList2(ArrayList<MyPageDTO> myPageList2) {
		this.myPageList2 = myPageList2;
	}

	public String getCheckEmpty() {
		return checkEmpty;
	}

	public void setCheckEmpty(String checkEmpty) {
		this.checkEmpty = checkEmpty;
	}

}
