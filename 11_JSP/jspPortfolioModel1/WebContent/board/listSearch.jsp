<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>
<%@ include file = "_inc_script.jsp" %>

<script>
	function goPage(value1, value2, value3) {
		let linkAddr = 'main.jsp?menuGubun=' + value1;
		if (value2 != undefined) {
			linkAddr += '&pageNumber=' + value2;
		}//if
		if (value3 != undefined) {
			linkAddr += '&no=' + value3;
		}//if
		location.href = linkAddr + '&' + <%=imsiQueryString %>;
	}//goPage
	
	goPage('board_list');
</script>