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
			<th>상품번호</th>
			<th>상품이미지</th>
			<th>상품이름</th>
			<th>상품가격</th>
			<th>제조사</th>
			<th>첨부파일</th>
			<th>등록일</th>
		</tr>
		
		<c:if test="${fn:length(requestScope.list) <= 0 }">
			<tr>
				<td colspan="6" style="height:200px; text-align:center;">등록된 상품이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach var="dto" items="${requestScope.list }">
			<tr>
				<td>${dto.productNo }</td>
				<td>
					<c:choose>
						<c:when test="${dto.attachInfo == '-' }">
							&nbsp;
						</c:when>
						<c:otherwise>
							<c:set var="fileName" value="${fn:split(dto.attachInfo, ',')[1] }" />
							<c:set var="fileOriginName" value="${fn:split(dto.attachInfo, ',')[0] }" />
							<img alt="${fileOriginName }" title="${fileOriginName }" src="${path }/attach${path }/product/${fileName }" />
						</c:otherwise>
					</c:choose>
				</td>
				<td><a href="#" onclick="move('view', '${dto.productNo }')">${dto.productName }</a></td>
				<td>${dto.productPrice }</td>
				<td>${dto.vendorName } (${dto.vendorNo })</td>
				<td>
					<c:choose>
						<c:when test="${dto.attachInfo == '-' }">
							X
						</c:when>
						<c:otherwise>
							O
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					${dto.regiDate }<br>
					<fmt:formatDate value="${dto.regiDate }" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
	|
	<a href="${path }/product/list">전체목록</a>
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
			let linkAddr = '${path }/product/' + value1;
			if (value2 != undefined) {
				linkAddr += '?productNo='+ value2;
			}//if
			location.href = linkAddr;
		}//move
	</script>

</body>
</html>