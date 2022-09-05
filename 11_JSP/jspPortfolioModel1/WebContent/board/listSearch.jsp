<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<script>
	function linkMove(value1, value2) {
		location.href = 'main.jsp?menuGubun=board_list&searchGubun='+ value1 +'&searchData='+ value2;
	}//linkMove
	linkMove('<%=searchGubun %>','<%=searchData %>');
</script>