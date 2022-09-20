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
	
	<h2>학사관리_시험목록</h2>
	
	list 길이 : ${fn:length(list) }
	<hr>
	
	<table border="1" width="80%">
		<tr>
			<th>시험번호</th>
			<th>시험명</th>
			<th>시험일</th>
			<th>등록일</th>
		</tr>
		
		<c:if test="${fn:length(list) == 0 }">
			<tr>
				<td colspan="4" style="width:300px; height:100px; text-align:center;">등록된 내용이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach var="dto" items="${requestScope.list }">
			<tr>
				<td>${dto.sihumNo }</td>
				<td><a href="#" onclick="move('view.do','${dto.sihumNo }')">${dto.sihumName }</a></td>
				<td>${dto.sihumDate }</td>
				<td>${dto.regiDate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
	|
	<a href="#" onclick="move('list.do')">목록</a>
	|
	<a href="#" onclick="move('chuga.do')">등록</a>
	|
	</div>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${path }/haksaSihum_servlet/' + value1;
			if (value2 != undefined) {
				linkAddr += '?sihumNo=' + value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>
</body>
</html>