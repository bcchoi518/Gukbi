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
	
	<table border="1" width="80%" style="text-align: center;">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>연락처</th>
			<th>주민번호</th>
			<th>등급</th>
			<th>등록일</th>
		</tr>
		
		<c:if test="${fn:length(requestScope.list) <= 0 }">
			<tr>
				<td colspan="6" style="height:200px; text-align:center;">등록된 회원이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach var="dto" items="${requestScope.list }">
			<tr>
				<td>${dto.no }</td>
				<td><a href="#" onclick="move('view', '${dto.no }')">${dto.id }</a></td>
				<td>${dto.name }</td>
				<td>${dto.phone }</td>
				<td>${fn:substring(dto.jumin, 0, 7) }-${fn:substring(dto.jumin, 7, 8) }******</td>
				<td>${dto.grade }</td>
				<td>
					${dto.regiDate }<br>
					<fmt:formatDate value="${dto.regiDate }" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
	|
	<a href="${path }/member/list">전체목록</a>
	|
	<a href="#" onclick="move('list')">목록</a>
	|
	<a href="#" onclick="move('chuga')">등록</a>
	|
	<a href="#" onclick="move('chugaAttach')">등록(attach)</a>
	|
	</div>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${path }/member/' + value1;
			if (value2 != undefined) {
				linkAddr += '?no='+ value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>

</body>
</html>