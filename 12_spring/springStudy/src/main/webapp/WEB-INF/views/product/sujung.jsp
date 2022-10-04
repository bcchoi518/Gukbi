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
				<td><input type="text" name="productName" value="${requestScope.dto.productName }"/></td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td><input type="text" name="productPrice" value="${requestScope.dto.productPrice }"/></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><textarea name="productDescription" style="width:150px; height:80px;">${requestScope.dto.productDescription }</textarea></td>
			</tr>
			<tr>
				<td>제조사</td>
				<td>
					vendorNo: <input type="text" name="vendorNo" value="${requestScope.dto.vendorNo }"/><br>
					vendorName: <input type="text" name="vendorName" value="${requestScope.dto.vendorName }"/>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="file" />
					<hr>
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
			</tr>
			<tr align="center" height="50px">
				<td colspan="2">
					<button type="button" onclick="save()">수정</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('수정하시겠습니까?')) {
				document.DirForm.action = '${path }/product/sujungProc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//save
	</script>

</body>
</html>