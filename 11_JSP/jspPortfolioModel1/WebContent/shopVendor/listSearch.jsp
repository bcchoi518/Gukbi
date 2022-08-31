<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchGubun = "";
		searchData = "";
	}//if
%>
<script>
	function linkMove(value1, value2) {
		location.href = 'main.jsp?menuGubun=shopVendor_list&searchGubun='+ value1 +'&searchData='+ value2;
	}//linkMove
	linkMove('<%=searchGubun %>','<%=searchData %>');
</script>