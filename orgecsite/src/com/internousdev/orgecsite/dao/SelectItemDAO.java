package com.internousdev.orgecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.orgecsite.dto.SelectItemDTO;
import com.internousdev.orgecsite.util.DBConnector;


public class SelectItemDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private SelectItemDTO selectItemDTO = new SelectItemDTO();

	public SelectItemDTO getBuyItemInfo(String buyId) throws SQLException {

		String sql = "SELECT id, item_name, item_price, item_stock from item_info_transaction where id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, buyId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				selectItemDTO.setBuyItemName(resultSet.getString("item_name"));
				selectItemDTO.setBuyItemPrice(resultSet.getString("item_price"));
				selectItemDTO.setBuyItemStock(resultSet.getString("item_stock"));
				selectItemDTO.setBuyId(resultSet.getString("id"));

				System.out.println("====" + selectItemDTO.getBuyItemName());
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return selectItemDTO;

	}

	public SelectItemDTO getDeleteItemInfo(String deleteId) {

		String sql = "SELECT id, item_name, item_price from item_info_transaction where id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, deleteId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				selectItemDTO.setDeleteItemName(resultSet.getString("item_name"));
				selectItemDTO.setDeleteItemPrice(resultSet.getString("item_price"));
				selectItemDTO.setDeleteId(resultSet.getString("id"));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return selectItemDTO;

	}

	public SelectItemDTO getSelectItemDTO() {
		return selectItemDTO;
	}



}
