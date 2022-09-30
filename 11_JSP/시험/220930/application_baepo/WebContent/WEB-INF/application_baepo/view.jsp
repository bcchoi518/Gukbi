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
			<td colspan="5" height="80px"><h2>회원상세보기</h2></td>
		</tr>
		<tr>
			<td>No</td>
			<td>${requestScope.dto.no }</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${requestScope.dto.id }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${requestScope.dto.name }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<c:choose>
					<c:when test="${requestScope.dto.gender == 'M' }">
						남자
					</c:when>
					<c:otherwise>
						여자
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>태어난년도</td>
			<td>${requestScope.dto.birthYear }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				${requestScope.dto.addr1 }
				${requestScope.dto.addr2 }
				${requestScope.dto.addr3 }
				<c:if test="${requestScope.dto.addr4 != '-' }">${requestScope.dto.addr4 }</c:if>
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${requestScope.dto.regiDate }</td>
		</tr>
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