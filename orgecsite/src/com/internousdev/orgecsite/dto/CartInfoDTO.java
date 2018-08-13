package com.internousdev.orgecsite.dto;


public class CartInfoDTO {
	private int id;
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String imageFilePath;
	private String imageFileName;
	private String itemReleaseCompany;
	private String insertDate;

	private int subtotalPrice;
	private int subtotalCount;
	private String userId;
	private String payment;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getItemReleaseCompany() {
		return itemReleaseCompany;
	}
	public void setItemReleaseCompany(String itemReleaseCompany) {
		this.itemReleaseCompany = itemReleaseCompany;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getSubtotalPrice() {
		return subtotalPrice;
	}
	public void setSubtotalPrice(int subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}
	public int getSubtotalCount() {
		return subtotalCount;
	}
	public void setSubtotalCount(int subtotalCount) {
		this.subtotalCount = subtotalCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}

}
