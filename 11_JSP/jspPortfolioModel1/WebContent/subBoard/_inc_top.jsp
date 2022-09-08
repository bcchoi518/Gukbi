<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>

<%@ page import="subBoard.model.dao.SubBoardDAO" %>
<%@ page import="subBoard.model.dto.SubBoardDTO" %>

<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<%
	String pageNumber_ = request.getParameter("pageNumber");
	if (pageNumber_ == null || pageNumber_.trim().equals("")) {
		pageNumber_ = "1";
	}
	int pageNumber = Integer.parseInt(pageNumber_);


	String no_ = request.getParameter("no");
	if (no_ == null || no_.trim().equals("")) {
		no_ = "0";
	}
	int no = Integer.parseInt(no_);


	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	int imsiSearchCounter = 0;
	
	if (searchGubun == null || searchGubun.trim().equals("")) {
		searchGubun = "";
		imsiSearchCounter++;
	}
	
	if (searchData == null || searchData.trim().equals("")) {
		searchData = "";
		imsiSearchCounter++;
	}
	
	if (imsiSearchCounter > 0) { // 0보다 크면 검색 안하다는 의미..
		searchGubun = "";
		searchData = "";
	}
	String imsiQueryString = "searchGubun=" + searchGubun + "&searchData=" + searchData;
%>

검색 : <%=pageNumber %> / <%=searchGubun%> / <%=searchData%> / <%=imsiQueryString %>
<hr>