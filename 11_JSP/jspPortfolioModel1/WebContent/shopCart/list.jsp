<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	CartDAO cartDao = new CartDAO();
	ArrayList<CartDTO> cartList = cartDao.getSelectAll();
%>

<h2>장바구니 목록</h2>
<form name="DirForm">
	<table border="1">
		<tr>
			<th>
				<input type="checkbox" name="checkAll" id="checkAll" />
			</th>
			<th>이미지</th>
			<th>제조사</th>
			<th>상품이름</th>
			<th>상품가격</th>
			<th>수량</th>
			<th>금액</th>
			<th>등록일</th>
			<th>비고</th>
		</tr>
	<%
			if (cartList.size() == 0) {
				out.println("<tr>");
				out.println("<td colspan=\"9\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
				out.println("</tr>");
			}//if
	%>
	<%
		int totalMoney = 0;
		for (int i = 0; i < cartList.size(); i++) {
			CartDTO resultCartDto = cartList.get(i);
			String[] productInfoArray = resultCartDto.getProductInfo().split("/");
			String[] attachInfoArray = productInfoArray[3].split("[|]");
			String img = attachInfoArray[1];
			
			if (img.equals("-")) {
				img = "&nbsp;";
			} else {
				img = "<img src=\""+ imgDisplayPath + "/shopProduct/" + img +"\" width=\"50px\" height=\"50px\" />";
			}//if
			int hab = Integer.parseInt(productInfoArray[1]) * resultCartDto.getAmount();
	%>
		<tr>
			<td>
				<input type="checkbox" name="chk" value="<%=resultCartDto.getCartNo() %>" />
			</td>
			<td><%=img %></td>
			<td><%=productInfoArray[2] %></td>
			<td><%=productInfoArray[0] %></td>
			<td><%=productInfoArray[1] %></td>
			<td><%=resultCartDto.getAmount() %></td>
			<td><%=hab %></td>
			<td><%=resultCartDto.getRegiDate() %></td>
			<td>
				<a href="#" onclick="cartClearOne(<%=resultCartDto.getCartNo() %>, 'G')">[삭제(G)]</a>
				<a href="#" onclick="cartClearOne(<%=resultCartDto.getCartNo() %>, 'P')">[삭제(P)]</a>
			</td>
		</tr>
	<%
			totalMoney += hab;
		}//for 
	%>
		<tr>
			<td colspan="9" align="right">
				Total : <%=totalMoney %>
			</td>
		</tr>
	</table>
</form>

<div style="border:0px solid red; width:80%; text-align:right; margin-top: 20px;">
	|
	<a href="#" onclick="move('shopCart_list')">목록</a>
	|
	<a href="#" onclick="cartClearForm()">삭제(Form)</a>
	|
	<a href="#" onclick="cartClearScript()">삭제(Script)</a>
	|
</div>

<form name="imsiForm">
	<input type="hidden" name="cartNo" />
</form>

<form name="sunteakForm">
	<input type="hidden" name="sunteakNo" />
</form>

<script>
	$(document).ready(function () {
		$('#checkAll').click(function () {
			if ($('#checkAll').prop('checked')) {
				$('input[name="chk"]').prop('checked', true);
			} else {
				$('input[name="chk"]').prop('checked', false);
			}//if
		});
	});

	function move(value1, value2) {
		let linkAddr = 'main.jsp?menuGubun=' + value1;
		if (vendorCode != undefined) {
			linkAddr += '&cartNo=' + value2;
		}//if
		location.href = linkAddr;
	}//if
	
	function cartClearOne(cartNo, procGubun) {
		if (confirm('삭제할까요?')) {
			if (procGubun == 'G') {
				location.href = 'mainProc.jsp?menuGubun=shopCart_sakjeProcOne&cartNo=' + cartNo;
			} else {
				document.imsiForm.cartNo.value = cartNo;
				
				document.imsiForm.action = 'mainProc.jsp?menuGubun=shopCart_sakjeProcOne';
				document.imsiForm.method = 'post';
				document.imsiForm.submit();
			}//if
		}//if
	}//cartClearOne
	
	function cartClearForm() {
		if (confirm('삭제할까요?')) {
			document.DirForm.action = 'mainProc.jsp?menuGubun=shopCart_sakjeProcForm';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//if
	
	function cartClearScript() {
		if (confirm('장바구니를 비우시겠습니까?')) {
			let chk_no = '';
			$('input[name="chk"]:checked').each(function (index) {
				if (index != 0) {
					chk_no += ',';
				}//if
				chk_no += $(this).val();
			});
			
			document.sunteakForm.sunteakNo.value = chk_no;
			
			document.sunteakForm.action = 'mainProc.jsp?menuGubun=shopCart_sakjeProcScript';
			document.sunteakForm.method = 'post';
			document.sunteakForm.submit();
		}//if
	}//if
</script>