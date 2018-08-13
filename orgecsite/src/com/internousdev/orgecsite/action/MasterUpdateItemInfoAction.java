package com.internousdev.orgecsite.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MasterUpdateItemInfoAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private String updateItemName;
	private String updateItemNameKana;
	private String updateItemPrice;
	private String updateItemReleaseCompany;
	private String checkCategoryId;
	private String updateItemDescription;

	private String updateCategoryId;
	private String errorMessage = "";
	private String imageUrl = "";

	// num が数値かどうかを判定する isNumber() を定義。（拾いもの）
	public boolean isNumber(String num) {
	    try {
	        Integer.parseInt(num);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public String execute() {
		String result;
		// カテゴリIDの「変更なし」が選択された場合を考慮した処理を行う。
		if(checkCategoryId.equals("0")){
			session.put("updateCategoryId", session.get("selectCategoryId").toString());
		}else{
			session.put("updateCategoryId", checkCategoryId);
		}
		// 画像ファイルが選択されたかどうかで、処理を分岐。
		String image_file_name = null;
		String image_file_pass = null;
		System.out.println(imageUrl);
		if(imageUrl.equals("")){
			session.put("updateImageFileName", session.get("selectImageFileName"));
			session.put("updateImageFilePath", session.get("selectImageFilePath"));
			session.put("updateImageInfo", session.get("selectImageInfo").toString());
		}else{
			ArrayList<String> listUrl = new ArrayList<String>(Arrays.asList(imageUrl.split("\\\\")));
			image_file_name = listUrl.get(listUrl.size() - 1);
			image_file_pass = listUrl.get(listUrl.size() - 2);
			session.put("updateImageFileName", image_file_name);
			session.put("updateImageFilePath", image_file_pass);
			session.put("updateImageInfo", image_file_pass + "/" + image_file_name);
		}

		result = ERROR;
		if(isNumber(updateItemPrice)==false){
			// 価格が数値でない場合
			setErrorMessage("[!] 価格に正しく数値を入力してください。");
		}else if(Integer.parseInt(updateItemPrice) < 0){
			// 価格がマイナスに設定されている場合
			setErrorMessage("[!] 価格がマイナスになってしまいます。");
		}else if(!(imageUrl.equals("")) && !(image_file_pass.equals("image"))){
			// 画像ファイルパスがimage以外の何かが指定されている場合（変なとこから持ってきている場合）
			setErrorMessage("[!] うまく動かないので、今は画像をWebContentフォルダ内のimageフォルダから選択してください。");
		}else{
			session.put("updateItemName", updateItemName);
			session.put("updateItemNameKana", updateItemNameKana);
			session.put("updateItemPrice", updateItemPrice);
			session.put("updateItemReleaseCompany", updateItemReleaseCompany);
			session.put("updateItemDescription", updateItemDescription);
			result = SUCCESS;
		}

		return result;
	}

	public String getUpdateItemName() {
		return updateItemName;
	}

	public void setUpdateItemName(String updateItemName) {
		this.updateItemName = updateItemName;
	}

	public String getUpdateItemNameKana() {
		return updateItemNameKana;
	}

	public void setUpdateItemNameKana(String updateItemNameKana) {
		this.updateItemNameKana = updateItemNameKana;
	}

	public String getUpdateItemPrice() {
		return updateItemPrice;
	}

	public void setUpdateItemPrice(String updateItemPrice) {
		this.updateItemPrice = updateItemPrice;
	}

	public String getUpdateItemReleaseCompany() {
		return updateItemReleaseCompany;
	}

	public void setUpdateItemReleaseCompany(String updateItemReleaseCompany) {
		this.updateItemReleaseCompany = updateItemReleaseCompany;
	}

	public String getUpdateItemDescription() {
		return updateItemDescription;
	}

	public void setUpdateItemDescription(String updateItemDescription) {
		this.updateItemDescription = updateItemDescription;
	}

	public String getUpdateCategoryId() {
		return updateCategoryId;
	}

	public void setUpdateCategoryId(String updateCategoryId) {
		this.updateCategoryId = updateCategoryId;
	}

	public String getCheckCategoryId() {
		return checkCategoryId;
	}

	public void setCheckCategoryId(String checkCategoryId) {
		this.checkCategoryId = checkCategoryId;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



}
