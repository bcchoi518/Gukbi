<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "../../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>
	
	<table border="1">
		<tr>
			<td>상품분류</td>
			<td>${requestScope.dto.productBunryu }</td>
		</tr>
		<tr>
			<td>상품이름</td>
			<td>${requestScope.dto.productName }</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${requestScope.dto.productPrice }</td>
		</tr>
		<tr>
			<td>할인률</td>
			<td>${requestScope.dto.salePercent }</td>
		</tr>
		<tr>
			<td>할인된 가격</td>
			<td>${requestScope.dto.productSalePrice }</td>
		</tr>
		<tr>
			<td>제조사</td>
			<td>${requestScope.dto.vendor }</td>
		</tr>
	</table>
	
</body>
</html>