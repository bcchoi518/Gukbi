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
	
	<form name="DirForm">
		<input type="hidden" name="productNo" value="${requestScope.dto.productNo }"/>
		<table border="1"> 
			<tr>
				<td>상품이름</td>
				<td>${requestScope.dto.productName }</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td>${requestScope.dto.productPrice }</td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td>${fn:replace(requestScope.dto.productDescription, newLineChar, '<br>') }</td>
			</tr>
			<tr>
				<td>제조사</td>
				<td>
					vendorNo: ${requestScope.dto.vendorNo }<br>
					vendorName: ${requestScope.dto.vendorName }
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:choose>
						<c:when test="${dto.attachInfo == '-' }">
							&nbsp;
						</c:when>
						<c:otherwise>
							<c:set var="fileName" value="${fn:split(requestScope.dto.attachInfo, ',')[1] }" />
							<c:set var="fileOriginName" value="${fn:split(requestScope.dto.attachInfo, ',')[0] }" />
							<img alt="${fileOriginName }" title="${fileOriginName }" src="${path }/attach${path }/product/${fileName }" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr align="center" height="50px">
				<td colspan="2">
					<button type="button" onclick="save()">삭제</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
	function save() {
		if (confirm('삭제하시겠습니까?')) {
			document.DirForm.action = '${path }/product/sakjeProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
	</script>
	
</body>
</html>