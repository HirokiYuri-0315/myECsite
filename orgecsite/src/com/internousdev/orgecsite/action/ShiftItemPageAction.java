package com.internousdev.orgecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orgecsite.dao.ItemDataDAO;
import com.internousdev.orgecsite.dto.ItemDataDTO;
import com.internousdev.orgecsite.dto.PaginationDTO;
import com.internousdev.orgecsite.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class ShiftItemPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ItemDataDAO itemDataDAO = new ItemDataDAO();
	private ArrayList<ItemDataDTO> newItemList = new ArrayList<ItemDataDTO>();
	private Pagination pagination = new Pagination();
	private String pageNo;
	private String categoryId;
	private String keyword;

	public String execute() throws SQLException{
		String result = ERROR;

		if(session.containsKey("newItemList")){
			newItemList = (ArrayList<ItemDataDTO>)session.get("newItemList");
		}else{
			newItemList = itemDataDAO.getNewItemDataInfo();
			// 全商品の情報を newItemList にセットした。
			session.put("newItemList", newItemList);
			int pageSize = 9;
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = pagination.initialize(newItemList, pageSize);
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("pageNumberList", paginationDTO.getPageNumberList());
			session.put("ItemInfoDtoList", paginationDTO.getCurrentProductInfoPage());	//これを商品一覧画面で使用中
			session.put("hasNextPage", paginationDTO.isHasNextPage());
			session.put("hasPreviousPage", paginationDTO.isHasPreviousPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			return result;
		}

		// ページ情報を取得。上で得た商品情報productInfoListを利用。1ページあたりの表示数9に設定。
		int pageSize = 9;
		int pNo = Integer.parseInt(pageNo);
		PaginationDTO paginationDTO = pagination.getPage(newItemList, pageSize, pNo);
		session.put("totalPageSize", paginationDTO.getTotalPageSize());
		session.put("currentPageNo", paginationDTO.getCurrentPageNo());
		session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
		session.put("startRecordNo", paginationDTO.getStartRecordNo());
		session.put("endRecordNo", paginationDTO.getEndRecordNo());
		session.put("pageNumberList", paginationDTO.getPageNumberList());
		session.put("ItemInfoDtoList", paginationDTO.getCurrentProductInfoPage());
		session.put("hasNextPage", paginationDTO.isHasNextPage());
		session.put("hasPreviousPage", paginationDTO.isHasPreviousPage());
		session.put("nextPageNo", paginationDTO.getNextPageNo());
		session.put("previousPageNo", paginationDTO.getPreviousPageNo());

		result=SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


}
