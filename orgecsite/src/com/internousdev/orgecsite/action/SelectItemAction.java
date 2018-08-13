package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.ItemDataDAO;
import com.internousdev.orgecsite.dao.SelectItemDAO;
import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.internousdev.orgecsite.dto.SelectItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SelectItemAction extends ActionSupport implements SessionAware {


	public Map<String,Object> session;
	private SelectItemDAO selectItemDAO = new SelectItemDAO();
	private String buyId;
	private String buyOrInfo = null;
	private String errorMessage = "";

	private ItemDataDAO itemDataDAO = new ItemDataDAO();

	public String execute() throws SQLException {
		String result;
		// 受け取る値は buyId（商品ID）と buyOrInfo（詳細を見る or 購入へ進む）で、それらを元に分岐。
		if(buyOrInfo.equals("3")){
			// 購入画面へと進む準備。商品詳細ページからくるとき。
			buyId = session.get("selectId").toString();
			session.put("id", buyId);
			SelectItemDTO selectItemDTO = selectItemDAO.getBuyItemInfo(buyId);

			session.put("buyItemName", selectItemDTO.getBuyItemName());
			session.put("buyItemPrice", selectItemDTO.getBuyItemPrice());
			session.put("buyItemStock", selectItemDTO.getBuyItemStock());

			session.put("buyImageFilePath", session.get("selectImageFilePath"));
			session.put("buyImageFileName", session.get("selectImageFileName"));

			session.put("selectItemData", selectItemDTO);	/* いらなさそう */

			result = SUCCESS;
		}else if(buyId == null ){
			// 商品が選択されていない場合。
			result="nullError";
			setErrorMessage("[!] 商品を選択してください。");
		}else if(buyOrInfo.equals("1")){
			// 商品の詳細情報を準備。DBから読み出した情報をDTOに格納した後、セッションに移す。後付。
			ItemDataDTO anItemAllDataDTO = itemDataDAO.getAnItemData(buyId);
			session.put("selectId", anItemAllDataDTO.getId());
			session.put("selectItemName", anItemAllDataDTO.getItemName());
			session.put("selectItemPrice", anItemAllDataDTO.getItemPrice());
			session.put("selectItemStock", anItemAllDataDTO.getItemStock());
			session.put("selectItemNameKana", anItemAllDataDTO.getItemNameKana());
			session.put("selectItemDescription", anItemAllDataDTO.getItemDescription());
			session.put("selectImageFilePath", anItemAllDataDTO.getImageFilePath());
			session.put("selectImageFileName", anItemAllDataDTO.getImageFileName());
			session.put("selectCategoryId", anItemAllDataDTO.getCategoryId());
			session.put("selectItemReleaseCompany", anItemAllDataDTO.getItemReleaseCompany());

			String imageInfo = anItemAllDataDTO.getImageFilePath().toString() + "/" + anItemAllDataDTO.getImageFileName().toString();
			session.put("selectImageInfo", imageInfo);
			result = "goDetail";
		}else if(buyOrInfo.equals("2")){
			// 購入画面へと進む準備。最小限の情報のみ取得。初期はこっち。
			session.put("id", buyId);
			SelectItemDTO selectItemDTO = selectItemDAO.getBuyItemInfo(buyId);

			session.put("buyItemName", selectItemDTO.getBuyItemName());
			session.put("buyItemPrice", selectItemDTO.getBuyItemPrice());
			session.put("buyItemStock", selectItemDTO.getBuyItemStock());

			session.put("selectItemData", selectItemDTO);	/* いらなさそう */

			result = SUCCESS;
		}else{
			result = "return";
		}
		return result;
	}


	public String getBuyId() {
		return buyId;
	}
	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}
	public String getBuyOrInfo() {
		return buyOrInfo;
	}
	public void setBuyOrInfo(String buyOrInfo) {
		this.buyOrInfo = buyOrInfo;
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


}
