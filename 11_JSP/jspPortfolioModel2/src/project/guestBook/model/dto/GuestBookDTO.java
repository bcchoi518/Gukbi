package project.guestBook.model.dto;

import java.sql.Date;

public class GuestBookDTO {
	private int no;
	private String name;
	private String email;
	private String passwd;
	private String content;
	private Date regiDate;
	private String searchGubun;
	private String searchData;
	private int startRecord;
	private int lastRecord;
	private int preNo;
	private String preContent;
	private int nxtNo;
	private String nxtContent;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	public String getSearchGubun() {
		return searchGubun;
	}
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	public String getSearchData() {
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}
	public int getStartRecord() {
		return startRecord;
	}
	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}
	public int getLastRecord() {
		return lastRecord;
	}
	public void setLastRecord(int lastRecord) {
		this.lastRecord = lastRecord;
	}
	public int getPreNo() {
		return preNo;
	}
	public void setPreNo(int preNo) {
		this.preNo = preNo;
	}
	public String getPreContent() {
		return preContent;
	}
	public void setPreContent(String preContent) {
		this.preContent = preContent;
	}
	public int getNxtNo() {
		return nxtNo;
	}
	public void setNxtNo(int nxtNo) {
		this.nxtNo = nxtNo;
	}
	public String getNxtContent() {
		return nxtContent;
	}
	public void setNxtContent(String nxtContent) {
		this.nxtContent = nxtContent;
	}
}//GuestBookDTO
