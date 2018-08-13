package com.internousdev.orgecsite.dto;

public class ItemDataDTO {

	public int id;
	public String itemName;
	public String itemPrice;
	public int itemStock;

	public String itemNameKana;
	public String itemDescription;
	public String imageFilePath;
	public String imageFileName;
	public int categoryId;
	public String itemReleaseCompany;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public String getItemNameKana(){
		return itemNameKana;
	}
	public void setItemNameKana(String itemNameKana){
		this.itemNameKana = itemNameKana;
	}
	public String getItemDescription(){
		return itemDescription;
	}
	public void setItemDescription(String itemDescription){
		this.itemDescription = itemDescription;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName(){
		return imageFileName;
	}
	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public String getItemReleaseCompany(){
		return itemReleaseCompany;
	}
	public void setItemReleaseCompany(String itemReleaseCompany){
		this.itemReleaseCompany = itemReleaseCompany;
	}


}
