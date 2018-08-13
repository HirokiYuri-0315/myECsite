package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.orgecsite.dto.LoginDTO;
import com.internousdev.orgecsite.util.DBConnector;


public class LoginMasterDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginMDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		// ログインIDとログインPASSを用いてDBにアクセスし、resultSetにてヒットするユーザー情報を取り出してみる。
		String sql = "SELECT * FROM login_master_user_transaction where login_id = ? AND login_pass = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			// 返されたログインID、ログインPASS、ユーザー名をloginMDTO(loginId, loginPassword, userName)にセット。
			if(resultSet.next()) {
				loginMDTO.setLoginId(resultSet.getString("login_id"));
				loginMDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginMDTO.setUserName(resultSet.getString("user_name"));

				// DTOの loginId に値がセットされたら、ログインフラグを true とする。
				if(!(resultSet.getString("login_id").equals(null))) {
					loginMDTO.setLoginMFlg(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginMDTO;
	}
	public LoginDTO getLoginMDTO() {
		return loginMDTO;
	}

}
