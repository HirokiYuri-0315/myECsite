package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.orgecsite.util.DBConnector;
import com.internousdev.orgecsite.util.DateUtil;


public class BuyItemCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
//	private DBConnector dbConnector2 = new DBConnector();
//	private Connection connection2 = dbConnector2.getConnection();
	private DBConnector dbConnector3 = new DBConnector();
	private Connection connection3 = dbConnector3.getConnection();
	private DateUtil dateUtil = new DateUtil();
//	public BuyItemDTO buyItemDTO = new BuyItemDTO();


	// 購入情報をtable user_buy_item_transaction に記述する。
	private String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?,?,?,?,?,?)";

	public void buyItemInfo(String item_transaction_id, String user_master_id, String total_price, String total_count, String pay) throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());

			preparedStatement.execute();
			System.out.println("購入情報を書き込みました。");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

/*
 *
//	private String sqlReadStock = "SELECT item_stock from item_info_transaction where id = ?";
 *
	public void buyStockDecriment(String item_id, int buy_count) throws SQLException {

		String sqlReadStock = "SELECT item_stock from item_info_transaction where id = ?";
		String sqlUpdateStock = "UPDATE item_info_transaction set item_stock = ?, update_date = ? where id = ?";

		try{
			PreparedStatement ps1 = connection.prepareStatement(sqlReadStock);
			ps1.setString(1, item_id);
			ResultSet rs1 = ps1.executeQuery();

			if(rs1.next()){
				System.out.println("rs1は" + rs1);
				int base_stock = new Integer(rs1.getInt("item_stock"));
				int new_stock = new Integer(base_stock - buy_count);
				buyItemDTO.setNewCount(new_stock);

				System.out.println(base_stock + "個から");
				System.out.println(buy_count + "個減って");
				System.out.println(buyItemDTO.getNewCount() + "個になります。");
			}

			PreparedStatement ps2 = connection.prepareStatement(sqlUpdateStock);
			ps2.setInt(1, buyItemDTO.getNewCount());
			ps2.setString(2, dateUtil.getDate());
			ps2.setString(3, item_id);
			ps2.execute();
			System.out.println("～ ps2によるアップデート実行完了");

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
*/
	private String sql2 = "INSERT INTO user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?,?,?,?,?,?)";

	private String sqlUpdateStock = "UPDATE item_info_transaction set item_stock = ?, update_date = ? where id = ?";

	public void buyItemInfoStock(String item_transaction_id, String user_master_id, String total_price, String total_count, String pay, int newCount) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.execute();
			System.out.println("購入情報を書き込みました。");
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			connection.close();
		}

/*		try {
			PreparedStatement ps2 = connection2.prepareStatement(sqlReadStock);
			ps2.setString(1, item_transaction_id);
			ResultSet rs2 = ps2.executeQuery();

			int buy_count = new Integer(total_count);
			if(rs2.next()){
				System.out.println("rs2は" + rs2);
				int base_stock = new Integer(rs2.getInt("item_stock"));
				int new_stock = new Integer(base_stock - buy_count);
				buyItemDTO.setNewCount(new_stock);

				System.out.println(base_stock + "個から");
				System.out.println(buy_count + "個減って");
				System.out.println(buyItemDTO.getNewCount() + "個になります。(5)");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection2.close();
		}
*/

		// 事前に「購入後の在庫数」を表す newCount を準備しておいた。
		try {
			PreparedStatement ps3 = connection3.prepareStatement(sqlUpdateStock);
			ps3.setInt(1, newCount);
			ps3.setString(2, dateUtil.getDate());
			ps3.setString(3, item_transaction_id);
			ps3.execute();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			connection3.close();
		}
	}


	private DBConnector dbConnector4 = new DBConnector();
	private Connection connection4 = dbConnector4.getConnection();
	public int updateStock(String item_transaction_id, int newCount) throws SQLException {
		int count = 0;
		try {
			PreparedStatement ps4 = connection4.prepareStatement(sqlUpdateStock);
			ps4.setInt(1, newCount);
			ps4.setString(2, dateUtil.getDate());
			ps4.setString(3, item_transaction_id);
			count = ps4.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			connection4.close();
		}
		return count;
	}

	// 管理ページの「商品情報の更新･編集」に利用している。MasterUpdateItemInfoConfirmAction
	public void updateItemInfo(int selectId, String updateItemName, String updateItemNameKana, int updateItemPrice, int updateItemStock, String updateItemReleaseCompany, int updateCategoryId, String updateItemDescription, String updateImageFilePath, String updateImageFileName) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		sql = "UPDATE item_info_transaction set item_name = ?, item_name_kana = ?, item_price = ?, item_stock = ?, item_release_company = ?, category_id = ?, item_description = ?, update_date = ?, image_file_path = ?, image_file_name = ? where id = ?";
		try{
			String updateDate = dateUtil.getDate();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, updateItemName);
			ps.setString(2, updateItemNameKana);
			ps.setInt(3, updateItemPrice);
			ps.setInt(4, updateItemStock);
			ps.setString(5, updateItemReleaseCompany);
			ps.setInt(6, updateCategoryId);
			ps.setString(7, updateItemDescription);
			ps.setString(8, updateDate);
			ps.setString(9, updateImageFilePath);
			ps.setString(10, updateImageFileName);
			ps.setInt(11, selectId);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}


}
