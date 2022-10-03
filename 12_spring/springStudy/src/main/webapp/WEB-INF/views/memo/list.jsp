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
			<th>순번</th>
			<th>작성자</th>
			<th>내용</th>
			<th>등록일</th>
		</tr>
		
		<c:if test="${fn:length(requestScope.list) <= 0 }">
			<tr>
				<td style="height:150px; text-align:center;">등록된 내용이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach var="dto" items="${requestScope.list }">
			<tr>
				<td>${dto.no }</td>
				<td><a href="#" onclick="move('view','${dto.no }')">${dto.writer }</a></td>
				<td>${dto.content }</td>
				<td>${dto.regiDate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
	|
	<a href="${path }/memo/list">전체목록</a>
	|
	<a href="#" onclick="move('list')">목록</a>
	|
	<a href="#" onclick="move('chuga')">등록</a>
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