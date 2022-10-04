<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

	<%@ include file = "../_include/inc_menu.jsp" %>
	
	<h2>${requestScope.title }</h2>
	
	<table border="1" width="80%">
		<tr>
			<td>상품번호</td>
			<td>${requestScope.dto.productNo }</td>
		</tr>
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
			<td id="content">${requestScope.dto.productDescription }</td>
		</tr>
		<tr>
			<td>제조사</td>
			<td>${requestScope.dto.vendorName } (${requestScope.dto.vendorNo })</td>
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
		<tr>
			<td>등록일</td>
			<td>${requestScope.dto.regiDate }</td>
		</tr>
		<tr>
			<td colspan="2">
				<form name="cartForm">
					<input type="hidden" name="productNo" value="${dto.productNo }"/>
					<input type="hidden" name="memberNo" value="${imsiMemberNo }"/>
					<select name="amount">
						<c:forEach begin="1" end="10" var="i">
							<option value="${i }">${i }</option>
						</c:forEach>
					</select>개&nbsp;
					<button type="button" onclick="cartAdd()">장바구니담기</button>
				</form>
			</td>
		</tr>
	</table>
	
	<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
	|
	<a href="${path }/product/list" >전체목록</a>
	|
	<a href="#" onclick="move('list')">목록</a>
	|
	<a href="#" onclick="move('chuga')">등록</a>
	|
	<a href="#" onclick="move('sujung','${requestScope.dto.productNo }')">수정</a>
	|
	<a href="#" onclick="move('sakje','${requestScope.dto.productNo }')">삭제</a>
	|
	</div>
	
	<script>
		$(document).ready(function() {
			const content = $("#content").text().replace(/(?:\r\n|\r|\n)/g, '<br/>');
			$("#content").html(content);
		});
		
		function move(value1, value2) {
			let linkAddr = '${path }/product/' + value1;
			if (value2 != undefined) {
				linkAddr += '?productNo='+ value2;
			}//if
			location.href = linkAddr;
		}//move
		
		function cartAdd() {
			if (confirm('장바구니에 담을까요?')) {
				document.cartForm.action = '${path }/cart/chugaProc';
				document.cartForm.method = 'post';
				document.cartForm.submit();
			}//if
		}//cartAdd
	</script>
	
</body>
</html>