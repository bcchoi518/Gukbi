<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="config.Util"%>

<%
	request.setCharacterEncoding("UTF-8");

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
		location.href = 'main.jsp?menuGubun=memo_list&searchGubun=<%=searchGubun %>&searchData=<%=searchData %>';
	}//move
	move();
</script>