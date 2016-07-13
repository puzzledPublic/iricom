package com.company.model;

public class PagingVo {

	private int requestPage; //요청 페이지
	private int totalPageCount; //총 페이지 갯수
	private int firstRow; //요청페이지에 해당하는 게시글의 첫 Row
	private int endRow; //요청페이지에 해당하는 게시글의 마지막 Row
	private int beginPage; //화면에 출력 할 시작 page 번호
	private int endPage; //화면에 출력 할 마지막 page 번호
	
	public PagingVo(int requestPage, int totalPageCount, int firstRow, int endRow, int beginPage, int endPage) {
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.firstRow = firstRow;
		this.endRow = endRow;
		this.beginPage = beginPage;
		this.endPage = endPage;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
	
}
