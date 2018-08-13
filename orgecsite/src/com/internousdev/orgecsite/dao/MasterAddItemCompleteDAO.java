package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.orgecsite.util.DBConnector;
import com.internousdev.orgecsite.util.DateUtil;


public class MasterAddItemCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO item_info_transaction(item_name, item_price, item_stock, insert_date) VALUES(?,?,?,?)";

	/* addItemInfo を定義。これで入力した値を item_info_transaction に書き込む。 */
	public void addItemInfo(String addItemName, int addItemPrice, int addItemStock) throws SQLException{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, addItemName);
			preparedStatement.setInt(2, addItemPrice);
			preparedStatement.setInt(3, addItemStock);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
}
