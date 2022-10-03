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
	
	<table border="0" width="80%">
		<c:if test="${fn:length(requestScope.list) <= 0 }">
			<tr>
				<td>
					<table border="1" width="100%" align="center">
						<tr>
							<td height="200px" style="text-align:center;">등록된 방명록이 없습니다.</td>
						</tr>
					</table>
				</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${requestScope.list }">
			<tr>
				<td>
					<table border="1" width="100%" align="center">
						<tr>
							<td width="100px">이름</td>
							<td>${dto.name }</td>
							<td width="100px">날짜</td>
							<td>${dto.regiDate }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td colspan="3">${dto.email }</td>
						</tr>
						<tr>
							<td colspan="4" style="height: 200px; padding:15px; vertical-align: top; position: relative;">
								${fn:replace(dto.content, newLineChar, '<br>') }
								<div style="float:right; bottom:15px; right:15px; position: absolute;" >
									<a href="#" onclick="move('sujung','${dto.no }')">수정</a>
									/
									<a href="#" onclick="move('sakje','${dto.no }')">삭제</a>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
	|
	<a href="${path }/guestBook/list" >전체목록</a>
	|
	<a href="#" onclick="move('list')">목록</a>
	|
	<a href="#" onclick="move('chuga')">등록</a>
	|
	</div>

	<script>
	function move(value1, value2) {
		let linkAddr = '${path }/guestBook/' + value1;
		if (value2 != undefined) {
			linkAddr += '?no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>

</body>
</html>