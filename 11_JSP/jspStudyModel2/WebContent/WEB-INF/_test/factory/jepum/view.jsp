<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../../_include/inc_menu.jsp" %>

	<h2>제품상세정보</h2>

	<table border="1" width="80%">
			<tr>
				<td>code</td>
				<td>${requestScope.dto.code }</td>
			</tr>
			<tr>
				<td>name</td>
				<td>${requestScope.dto.name }</td>
			</tr>
			<tr>
				<td>standard</td>
				<td>${requestScope.dto.standard }</td>
			</tr>
			<tr>
				<td>unit</td>
				<td>${requestScope.dto.unit }</td>
			</tr>
			<tr>
				<td>barcode</td>
				<td>${requestScope.dto.barcode }</td>
			</tr>
			<tr>
				<td>wdate</td>
				<td>${requestScope.dto.wdate }</td>
			</tr>
	</table>
	
	<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
	|
	<a href="#" onclick="move('list.do')">목록</a>
	|
	<a href="#" onclick="move('chuga.do')">등록</a>
	|
	<a href="#" onclick="move('sujung.do','${requestScope.dto.code }')">수정</a>
	|
	<a href="#" onclick="move('sakje.do','${requestScope.dto.code }')">삭제</a>
	|
	</div>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${path }/jepum_servlet/' + value1;
			if (value2 != undefined) {
				linkAddr += '?code=' + value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>
</body>
</html>