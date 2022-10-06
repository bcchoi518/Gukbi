package com.cbc.springPortfolio.memo.model.dto;

import java.sql.Date;

public class MemoDTO {
    private int no;
    private String writer;
    private String content;
    private Date regiDate;
    
    private String procGubun;
    
    private String searchGubun;
    private String searchData;
    
    private int pageNumber;
    
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	public String getProcGubun() {
		return procGubun;
	}
	public void setProcGubun(String procGubun) {
		this.procGubun = procGubun;
	}
	public String getSearchGubun() {
		if (searchGubun == null) {
			return "";
		}//if
		return searchGubun;
	}
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	public String getSearchData() {
		if (searchData == null) {
			return "";
		}//if
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}
	public int getPageNumber() {
		if (pageNumber == 0) {
			return 1;
		}//if
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
}//MemoDTO
