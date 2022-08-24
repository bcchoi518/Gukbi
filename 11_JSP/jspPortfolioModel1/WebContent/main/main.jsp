<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>main</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	body {
		background-color: #c7f9cc;
	}
	table {
		border-collapse: collapse;
		background-color: #80ed99;
		width: 80%;
	}
	a {
		text-decoration: none;
	}
	td {
		padding: 10px;
		min-width: 30px;
		max-width: 400px;
	}
	#list_content {
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis; 
	}
	.entryName {
		text-align: right;
	}
</style>
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="100px" align="center">
				<jsp:include page="../_include/inc_menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td align="center" style="padding:30px 0px">
<!-- 본문 내용 시작 -->
				<jsp:include page="<%=includePage %>"></jsp:include>
<!-- 본문 내용 끝 -->
			</td>
		<tr>
			<td height="100px" align="center" style="gackground-color:#22577a">
				<jsp:include page="/_include/inc_copyright.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>