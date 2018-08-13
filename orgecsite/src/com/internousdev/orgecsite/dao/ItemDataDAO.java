package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.internousdev.orgecsite.util.DBConnector;


public class ItemDataDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	// itemList用。最初にやったやつ。
	public ArrayList<ItemDataDTO> getItemDataInfo() throws SQLException {
		ArrayList<ItemDataDTO> itemDataDTO = new ArrayList<ItemDataDTO>();
		String sql="SELECT id, item_name, item_price, item_stock FROM item_info_transaction";
		/* 商品のリストからID、名前、値段、在庫数の情報を全て引き出すsql文。 */
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			/* sql文を実行。 */
			while(resultSet.next()) {
				ItemDataDTO idto = new ItemDataDTO();
				idto.setId(resultSet.getInt("id"));
				idto.setItemName(resultSet.getString("item_name"));
				idto.setItemPrice(resultSet.getString("item_price"));
				idto.setItemStock(resultSet.getInt("item_stock"));
				/* 1行分の商品情報（ID、名前、値段、在庫数）を idto にセット。 */

				itemDataDTO.add(idto);
				/* itemDataDTO に idto を addしていく。これを実行結果が続く限り繰り返し。 */
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return itemDataDTO;
	}

	// newItemList.jspのために頑張る。GoNewItemListAction
	public ArrayList<ItemDataDTO> getNewItemDataInfo() throws SQLException {
		ArrayList<ItemDataDTO> itemDataDTO = new ArrayList<ItemDataDTO>();
		String sql="SELECT id, item_name, item_release_company, item_price, image_file_path, image_file_name FROM item_info_transaction";
		// 商品のリストから商品ID、商品名、発売元、価格、画像ファイルパス、画像ファイル名の情報を全て引き出すsql文
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDataDTO idto = new ItemDataDTO();
				idto.setId(rs.getInt("id"));
				idto.setItemName(rs.getString("item_name"));
				idto.setItemReleaseCompany(rs.getString("item_release_company"));
				idto.setItemPrice(rs.getString("item_price"));
				idto.setImageFilePath(rs.getString("image_file_path"));
				idto.setImageFileName(rs.getString("image_file_name"));
				// 1行ずつ情報を書き込んでいく。
				itemDataDTO.add(idto);
			}
			// 取得された情報が itemDataDTO にセットされる。
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemDataDTO;
	}

	// 商品検索用。SearchCategoryKeywordAction
	public ArrayList<ItemDataDTO> searchNewItemDataInfo(String searchCategoryId, String searchKeyword) throws SQLException {
		ArrayList<ItemDataDTO> itemDataDTO = new ArrayList<ItemDataDTO>();
		String sql;
		if(searchCategoryId.equals("0")){
			sql="SELECT id, item_name, item_release_company, item_price, image_file_path, image_file_name FROM item_info_transaction WHERE item_name LIKE ?";
		}else{
			sql="SELECT id, item_name, item_release_company, item_price, image_file_path, image_file_name FROM item_info_transaction WHERE item_name LIKE ? AND category_id = ?";
		}
		// 商品のリストから商品ID、商品名、発売元、価格、画像ファイルパス、画像ファイル名の情報を全て引き出すsql文
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, searchKeyword);
			if(!(searchCategoryId.equals("0"))){
				ps.setString(2, searchCategoryId);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDataDTO idto = new ItemDataDTO();
				idto.setId(rs.getInt("id"));
				idto.setItemName(rs.getString("item_name"));
				idto.setItemReleaseCompany(rs.getString("item_release_company"));
				idto.setItemPrice(rs.getString("item_price"));
				idto.setImageFilePath(rs.getString("image_file_path"));
				idto.setImageFileName(rs.getString("image_file_name"));
				// 1行ずつ情報を書き込んでいく。
				itemDataDTO.add(idto);
			}
			// 取得された情報が itemDataDTO にセットされる。
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemDataDTO;
	}

	// 1つの商品について、その商品情報を全て取り出すメソッド。GoItemDetailAction
	public ItemDataDTO getAnItemData(String selectId) throws SQLException {
		ItemDataDTO anItemAllDataDTO = new ItemDataDTO();

		String sql = "SELECT * FROM item_info_transaction WHERE id = ? ";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, selectId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				anItemAllDataDTO.setId(rs.getInt("id"));
				anItemAllDataDTO.setItemName(rs.getString("item_name"));
				anItemAllDataDTO.setItemPrice(rs.getString("item_price"));
				anItemAllDataDTO.setItemStock(rs.getInt("item_stock"));

				anItemAllDataDTO.setItemNameKana(rs.getString("item_name_kana"));
				anItemAllDataDTO.setItemDescription(rs.getString("item_description"));
				anItemAllDataDTO.setImageFilePath(rs.getString("image_file_path"));
				anItemAllDataDTO.setImageFileName(rs.getString("image_file_name"));
				anItemAllDataDTO.setCategoryId(rs.getInt("category_id"));
				anItemAllDataDTO.setItemReleaseCompany(rs.getString("item_release_company"));
			}
		}catch(Exception e){

		}finally{
			connection.close();
		}
		return anItemAllDataDTO;
	}

	public String getIdFromName(String name) throws SQLException{
		String selectId = null;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT id FROM item_info_transaction WHERE item_name = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				selectId = rs.getString("id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return selectId;
	}

	public int getStockFromId(int itemId) throws SQLException{
		int nowStock = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT item_stock FROM item_info_transaction WHERE id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				nowStock = rs.getInt("item_stock");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return nowStock;
	}

}
