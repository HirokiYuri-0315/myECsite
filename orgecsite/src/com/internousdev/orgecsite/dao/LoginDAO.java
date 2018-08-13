package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.orgecsite.dto.LoginDTO;
import com.internousdev.orgecsite.util.DBConnector;


public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		// ログインIDとログインPASSを用いてDBにアクセスし、ユーザー情報を取り出す。
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			// ログインID、ログインPASS、ユーザー名をloginDTO(loginId, loginPassword, userName)にセット。
			if(resultSet.next()) {
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				// DTOの loginId に値がセットされたら、ログインフラグを true とする。
				if(!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}

	// ユーザー登録時にIDが被らないようするための確認メソッド。
	public LoginDTO checkLoginIdInfo(String loginUserId) {
		String sql = "SELECT * FROM login_user_transaction where login_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				loginDTO.setDoubleId(rs.getString("login_id"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

}
