<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>    

<%@page import="config.Util"%>

<%
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	Util util = new Util();
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchGubun = "";
		searchData = "";
	}//if
%>

<script>
	function move() {
		location.href = 'main.jsp?menuGubun=boardBasic_list&searchGubun=<%=searchGubun%>&searchData=<%=searchData%>'
	}//move
	move();
</script>