package com.cbc.springPortfolio.member.model.dto;

import java.sql.Date;

public class MemberDTO {
    private int no;
    private String id;
    private String tempId;
    private String passwd;
    private String passwdChk;
    private String name;
    private String jumin1;
    private String jumin2;
    private String phone1;
    private String phone2;
    private String phone3;
    private String email1;
    private String email2;
    private String postcode;
    private String address;
    private String detailAddress;
    private String extraAddress;
    private Date regiDate;
    
    private String searchGubun;
    private String searchData;
    
    private int pageNumber;
    private int startRecord;
    private int lastRecord;
    
    private int preNo;
    private String preName;
    private int nxtNo;
    private String nxtName;
    
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPasswdChk() {
		return passwdChk;
	}
	public void setPasswdChk(String passwdChk) {
		this.passwdChk = passwdChk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin1() {
		return jumin1;
	}
	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}
	public String getJumin2() {
		return jumin2;
	}
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getExtraAddress() {
		return extraAddress;
	}
	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
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
		if (pageNumber <= 0) {
			return 1;
		}//if
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		if (pageNumber <= 0) {
			this.pageNumber = 1;
		} else {
			this.pageNumber = pageNumber;
		}//if
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
	public String getPreName() {
		return preName;
	}
	public void setPreName(String preName) {
		this.preName = preName;
	}
	public int getNxtNo() {
		return nxtNo;
	}
	public void setNxtNo(int nxtNo) {
		this.nxtNo = nxtNo;
	}
	public String getNxtName() {
		return nxtName;
	}
	public void setNxtName(String nxtName) {
		this.nxtName = nxtName;
	}
}//MemberDTO
