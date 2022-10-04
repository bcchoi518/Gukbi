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
	
	<h2>${requestScope.title }</h2><body>
	<form name="DirForm">
		<table border="1" width="80%">
			<tr>
				<th>순번</th>
				<th>상품이름</th>
				<th>상품단가</th>
				<th>수량</th>
				<th>금액</th>
				<th>회원번호</th>
				<th>등록일</th>
				<th>비고</th>
			</tr>
			
			<c:if test="${fn:length(requestScope.list) <= 0 }">
				<tr>
					<td colspan="8" style="height:200px; text-align:center;">장바구니가 비어있습니다.</td>
				</tr>
			</c:if>
			
			<c:set var="totalPay" value="0"/>
			<c:set var="k" value="0"/>
			<c:forEach var="dto" items="${requestScope.list }">
				<tr>
					<td>${dto.cartNo }</td>
					<td>${dto.productName } (${dto.productNo })</td>
					<td>${dto.productPrice }</td>
					<td>
						<input type="hidden" name="cartNo_${k }" value="${dto.cartNo }" style="width: 60px;"/>
						<input type="text" name="amount_${k }" value="${dto.amount }" style="width: 60px;"/>
					</td>
					<td>${dto.pay }</td>
					<td>${dto.memberName } (${dto.memberNo })</td>
					<td>${dto.regiDate }</td>
					<td><a href="#" onclick="sakje(${dto.cartNo })">[삭제]</a></td>
				</tr>
				<c:set var="k" value="${k + 1 }"/>
				<c:set var="totalPay" value="${totalPay + dto.pay }"/>
			</c:forEach>
			<tr>
				<td colspan="8" style="text-align:right;">
				<c:set var="baesongMoney" value="5000" />
					장바구니 금액 합계 : <fmt:formatNumber value="${totalPay }" pattern="###,###" />원<br>
					배송료 : <fmt:formatNumber value="${baesongMoney }" pattern="###,###" />원<br>
					총합계 : <fmt:formatNumber value="${totalPay + baesongMoney }" pattern="###,###" />원
				</td>
			</tr>
		</table>
		<input type="hidden" name="totalCounter" value="${k }" />
	</form>
	
	<div style="border:0px solid red; width:80%; margin-top:10px; text-align:right;">
		<button type="button" onclick="sujung()">수정</button>
		&nbsp;
		<button type="button" onclick="cartClear()">장바구니 비우기</button>
	</div>
	
	<form name="sakjeForm">
		<input type="hidden" name="cartNo" /> 
	</form>
	
	<form name="clearForm">
		<input type="hidden" name="memberNo" value="${imsiMemberNo }"/> 
	</form>
	
	<script>
		function sujung() {
			if (confirm('수정할까요?')) {
				document.DirForm.action = '${path }/cart/sujungProc';
				document.DirForm.method = 'post';
				document.DirForm.submit();
			}//if
		}//sujung
		
		function sakje(value1) {
			if (confirm('삭제할까요?')) {
				document.sakjeForm.cartNo.value = value1;
				
				document.sakjeForm.action = '${path }/cart/sakjeProc';
				document.sakjeForm.method = 'post';
				document.sakjeForm.submit();
			}//if
		}//if
		
		function cartClear() {
			if (confirm('정말비울까요?')) {
				document.clearForm.action = '${path }/cart/cartClearProc';
				document.clearForm.method = 'post';
				document.clearForm.submit();
			}//if
		}//if
		
	</script>
	
</body>
</html>