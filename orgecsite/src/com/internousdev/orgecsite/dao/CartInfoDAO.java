package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.orgecsite.dto.CartInfoDTO;
import com.internousdev.orgecsite.util.DBConnector;
import com.internousdev.orgecsite.util.DateUtil;


public class CartInfoDAO {

	private DateUtil dateUtil = new DateUtil();
	// 書き込み。商品ID、ユーザーID、購入個数、合計金額、支払い方法、
	public void addCartInfo(int itemId, String userId, int subtotalCount, int subtotalPrice, String payment) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "INSERT INTO cart_info(item_id, user_id, total_count, total_price, pay, insert_date) value(?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, userId);
			ps.setInt(3, subtotalCount);
			ps.setInt(4, subtotalPrice);
			ps.setString(5, payment);
			ps.setString(6, dateUtil.getDate());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}


	// 取得。テーブル cart_info から、ユーザーIDが一致するものを選択。
	public ArrayList<CartInfoDTO> getCartInfo(String userId) throws SQLException{
		ArrayList<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "Select"
				+ " ci.id, ci.item_id, ci.insert_date, ci.total_count, ci.total_price, ci.user_id, ci.pay,"
				+ " iit.item_name, iit.item_price, iit.image_file_path, iit.image_file_name, iit.item_release_company"
				+ " FROM cart_info as ci"
				+ " LEFT JOIN item_info_transaction as iit"
				+ " ON ci.item_id = iit.id"
				+ " WHERE ci.user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CartInfoDTO ci = new CartInfoDTO();
				ci.setId(rs.getInt("id"));
				ci.setItemId(rs.getInt("item_id"));
				ci.setItemName(rs.getString("item_name"));
				ci.setItemPrice(rs.getInt("item_price"));
				ci.setImageFilePath(rs.getString("image_file_path"));
				ci.setImageFileName(rs.getString("image_file_name"));
				ci.setItemReleaseCompany(rs.getString("item_release_company"));
				ci.setSubtotalCount(rs.getInt("total_count"));
				ci.setSubtotalPrice(rs.getInt("total_price"));
				ci.setUserId(rs.getString("user_id"));
				ci.setPayment(rs.getString("pay"));
				ci.setInsertDate(rs.getString("insert_date"));
				cartInfoDTOList.add(ci);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return cartInfoDTOList;
	}

	// 合計金額の算出
	public int calculateCashPrice(String userId) throws SQLException{
		int totalPrice = 0;
		String payment = "'現金払い'";
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "Select"
				+ " total_price"
				+ " FROM cart_info"
				+ " WHERE user_id = ? AND pay = "
				+ payment;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				totalPrice += rs.getInt("total_price");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return totalPrice;
	}
	public int calculateCreditPrice(String userId) throws SQLException{
		int totalPrice = 0;
		String payment = "'クレジットカード'";
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "Select"
				+ " total_price"
				+ " FROM cart_info"
				+ " WHERE user_id = ? AND pay = "
				+ payment;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				totalPrice += rs.getInt("total_price");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return totalPrice;
	}


	// 決済　CartSettleConfirmAction
	public ArrayList<String> kessai(ArrayList<CartInfoDTO> cartInfoDTOList) throws SQLException{
		ArrayList<String> errorMessageList = new ArrayList<String>();

		// 拡張for文で、カート情報のリスト cartInfoDTOList から1行ずつ処理を実行。
		for(CartInfoDTO cartInfoDTO : cartInfoDTOList){
			// 在庫数を取得するDAOを準備した。
			ItemDataDAO DAO1 = new ItemDataDAO();
			int nowStock = DAO1.getStockFromId(cartInfoDTO.getItemId());
			int newCount = nowStock - cartInfoDTO.getSubtotalCount();

			if(newCount >= 0){
				BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
				String item_transaction_id = String.valueOf(cartInfoDTO.getItemId());
				String user_master_id = cartInfoDTO.getUserId();
				String total_price = String.valueOf(cartInfoDTO.getSubtotalPrice());
				String total_count = String.valueOf(cartInfoDTO.getSubtotalCount());
				String pay = cartInfoDTO.getPayment();
				// 通常の（単品）購入時に使用していたDAOを流用。
				buyItemCompleteDAO.buyItemInfoStock(item_transaction_id, user_master_id, total_price, total_count, pay, newCount);

				// カート情報を1行削除する。
				int id = cartInfoDTO.getId();
				String deleteId = String.valueOf(id);
				selectDelete(deleteId);
			}else{
				String itemName = cartInfoDTO.getItemName();
				String em = "[!] " + itemName + "の在庫が足りないため、この商品の購入処理を保留しました。";
				errorMessageList.add(em);
			}
		}
		return errorMessageList;
	}


	// 選択削除（ひとつ選んで削除する）
	public void selectDelete(String cartId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "DELETE from cart_info WHERE id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cartId);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}

	// 全削除

}


//"Select ci.id, ci.item_id, ci.insert_date, ci.total_count, ci.total_price, ci.user_id, ci.pay, iit.item_name, iit.item_price, iit.image_file_path, iit.image_file_name, iit.item_release_company FROM cart_info as ci LEFT JOIN item_info_transaction as iit ON ci.item_id = iit.id WHERE ci.user_id = "taro" group by item_id;
