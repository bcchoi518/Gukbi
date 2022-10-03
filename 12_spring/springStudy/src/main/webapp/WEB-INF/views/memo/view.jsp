<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>

	<table border="1" width="80%">
		<tr>
			<td>작성자</td>
			<td>${requestScope.dto.writer }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${fn:replace(requestScope.dto.content, newLineChar, '<br>') }</td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" onclick="save()" >확인</button></td>
		</tr>
	</table>
	
	<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
	|
	<a href="${path }/memo/list" >전체목록</a>
	|
	<a href="#" onclick="move('list')">목록</a>
	|
	<a href="#" onclick="move('chuga')">등록</a>
	|
	<a href="#" onclick="move('sujung','${requestScope.dto.no }')">수정</a>
	|
	<a href="#" onclick="move('sakje','${requestScope.dto.no }')">삭제</a>
	|
	</div>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${path }/memo/' + value1;
			if (value2 != undefined) {
				linkAddr += '?no='+ value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>
	
</body>
</html>