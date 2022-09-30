<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" width="80%">
		<tr>
			<td colspan="5" height="80px"><h2>회원목록</h2></td>
		</tr>
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>등록일</th>
		</tr>
		<c:if test="${fn:length(requestScope.list) <= 0 }">
			<tr>
				<td colspan="5" height="200px" style="text-align:center">등록된 회원이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${requestScope.list }">
			<tr>
				<td>${dto.no }</td>
				<td><a href="#" onclick="move('view','${dto.no}')">${dto.id }</a></td>
				<td>${dto.name }</td>
				<td>
					<c:choose>
						<c:when test="${dto.gender == 'M' }">
							남자
						</c:when>
						<c:otherwise>
							여자
						</c:otherwise>
					</c:choose>
				</td>
				<td>${dto.regiDate }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" height="80px" align="right">
			|
			<a href="#" onclick="move('list')">LIST</a>
			|
			<a href="#" onclick="move('join')">JOIN</a>
			|
			&nbsp;
			</td>
		</tr>
	</table>
	
	<script>
		function move(value1, value2) {
			let linkAddr = '${requestScope.path }/'+ value1;
			if (value2 != undefined) {
				linkAddr += '?no='+ value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>
</body>
</html>