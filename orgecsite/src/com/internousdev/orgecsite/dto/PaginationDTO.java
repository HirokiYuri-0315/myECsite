package com.internousdev.orgecsite.dto;

import java.util.List;

// sample-webに合わせて作成。
public class PaginationDTO {
	private int totalPageSize;				// 全ページ数
	private int currentPageNo;				// 現在のページ数
	private int totalRecordSize;			// 総レコード数
	private int startRecordNo;				// 開始のレコード番号
	private int endRecordNo;				// 終了のレコード番号
	private List<Integer> pageNumberList;	// ページ番号のリスト
	private List<ItemDataDTO> currentProductInfoPage;	// 1ページ分の商品情報
	private boolean hasNextPage;			// 次ページが存在するかどうか
	private boolean hasPreviousPage;		// 前ページが存在するかどうか
	private int nextPageNo;					// 次ページの番号
	private int previousPageNo;				// 前ページの番号

	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalRecordSize() {
		return totalRecordSize;
	}
	public void setTotalRecordSize(int totalRecordSize) {
		this.totalRecordSize = totalRecordSize;
	}
	public int getStartRecordNo() {
		return startRecordNo;
	}
	public void setStartRecordNo(int startRecordNo) {
		this.startRecordNo = startRecordNo;
	}
	public int getEndRecordNo() {
		return endRecordNo;
	}
	public void setEndRecordNo(int endRecordNo) {
		this.endRecordNo = endRecordNo;
	}
	public List<Integer> getPageNumberList() {
		return pageNumberList;
	}
	public void setPageNumberList(List<Integer> pageNumberList) {
		this.pageNumberList = pageNumberList;
	}
	public List<ItemDataDTO> getCurrentProductInfoPage() {
		return currentProductInfoPage;
	}
	public void setCurrentProductInfoPage(List<ItemDataDTO> currentProductInfoPage) {
		this.currentProductInfoPage = currentProductInfoPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public int getNextPageNo() {
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	public int getPreviousPageNo() {
		return previousPageNo;
	}
	public void setPreviousPageNo(int previousPageNo) {
		this.previousPageNo = previousPageNo;
	}

}
