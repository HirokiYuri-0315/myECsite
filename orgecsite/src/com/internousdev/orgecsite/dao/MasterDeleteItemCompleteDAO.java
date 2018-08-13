package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.orgecsite.util.DBConnector;


public class MasterDeleteItemCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection con = dbConnector.getConnection();

	// id が deleteId と一致する商品を削除したい。
	private String sql = "DELETE from item_info_transaction where id = ?";

	// sql文を実行する deleteItemInfo(String) を定義しておく。
	public void deleteItemInfo(String deleteId) throws SQLException {
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, deleteId);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
