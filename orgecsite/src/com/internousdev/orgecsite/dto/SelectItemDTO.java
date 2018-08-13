package com.internousdev.orgecsite.dto;

public class SelectItemDTO {

	String buyId;
	String buyItemName;
	String buyItemPrice;
	String buyItemStock;

	String deleteId;
	String deleteItemName;
	String deleteItemPrice;

	public String getBuyItemName() {
		return buyItemName;
	}
	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
	}

	public String getBuyItemPrice() {
		return buyItemPrice;
	}
	public void setBuyItemPrice(String buyItemPrice) {
		this.buyItemPrice = buyItemPrice;
	}

	public String getBuyItemStock() {
		return buyItemStock;
	}
	public void setBuyItemStock(String buyItemStock) {
		this.buyItemStock = buyItemStock;
	}

	public String getBuyId() {
		return buyId;
	}
	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}


	public String getDeleteItemName() {
		return deleteItemName;
	}
	public void setDeleteItemName(String deleteItemName) {
		this.deleteItemName = deleteItemName;
	}

	public String getDeleteItemPrice() {
		return deleteItemPrice;
	}
	public void setDeleteItemPrice(String deleteItemPrice) {
		this.deleteItemPrice = deleteItemPrice;
	}

	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}

}
