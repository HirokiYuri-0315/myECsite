package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.orgecsite.dto.MyPageDTO;
import com.internousdev.orgecsite.util.DBConnector;


public class MyPageDAO2 {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();



	/* user_master_id のみから動作するもの */
	// 画像の情報も何とか取得したい。
	public ArrayList<MyPageDTO> getMyPageUserInfo3(String user_master_id) throws SQLException {

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		String sql =
//				"SELECT ubit.id, iit.id, iit.item_name, iit.image_file_path, iit.image_file_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.user_master_id = ? ORDER BY insert_date DESC";
				"SELECT iit.id, iit.item_name, iit.image_file_path, iit.image_file_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.user_master_id = ? ORDER BY insert_date DESC";
			/* user_buy_item_transaction を ubit と書くよう宣言している。 */


		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				MyPageDTO dto2 = new MyPageDTO();
//				dto2.setId(resultSet.getString("id"));
				dto2.setItemId(resultSet.getString("id"));
				dto2.setItemName(resultSet.getString("item_name"));
				dto2.setTotalPrice(resultSet.getString("total_price"));
				dto2.setTotalCount(resultSet.getString("total_count"));
				dto2.setPayment(resultSet.getString("pay"));
				dto2.setInsert_date(resultSet.getString("insert_date"));

				dto2.setImageFilePath(resultSet.getString("image_file_path"));
				dto2.setImageFileName(resultSet.getString("image_file_name"));
				// ヒットした情報を1行ずつ myPageDTO に記述。
				myPageDTO.add(dto2);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return myPageDTO;
	}


	/* user_master_id のみから動作するもの */
	public ArrayList<MyPageDTO> getMyPageUserInfo2(String user_master_id) throws SQLException {

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		String sql =
				"SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.user_master_id = ? ORDER BY insert_date DESC";
			/* user_buy_item_transaction を ubit と書くよう宣言している。 */

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				MyPageDTO dto2 = new MyPageDTO();
				dto2.setId(resultSet.getString("id"));
				dto2.setItemName(resultSet.getString("item_name"));
				dto2.setTotalPrice(resultSet.getString("total_price"));
				dto2.setTotalCount(resultSet.getString("total_count"));
				dto2.setPayment(resultSet.getString("pay"));
				dto2.setInsert_date(resultSet.getString("insert_date"));
				// ヒットした情報を1行ずつ myPageDTO に記述。
				myPageDTO.add(dto2);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return myPageDTO;
	}

	/* user_master_id のみから動作するもの */
	public int buyItemHistoryDelete2(String user_master_id) throws SQLException {
		String sql = "DELETE FROM user_buy_item_transaction WHERE user_master_id = ?";
		// ユーザーIDを用いて検索し、ヒットしたものを削除する。
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}
}
