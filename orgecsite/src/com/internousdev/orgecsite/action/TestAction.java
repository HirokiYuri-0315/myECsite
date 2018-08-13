package com.internousdev.orgecsite.action;

import java.util.ArrayList;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private String imageUrl;

	public String execute(){
		System.out.println(imageUrl);
		ArrayList<String> listUrl = new ArrayList<String>(Arrays.asList(imageUrl.split("\\\\")));
		System.out.println(listUrl);
		String image_file_name = listUrl.get(listUrl.size() - 1);
		System.out.println(image_file_name);
		String image_file_pass = listUrl.get(listUrl.size() - 2);
		System.out.println(image_file_pass);

		String result = SUCCESS;
		return result;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
