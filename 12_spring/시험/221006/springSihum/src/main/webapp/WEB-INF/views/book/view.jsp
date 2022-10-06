<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_top.jsp" %>

<h2>${requestScope.title }</h2>

<table border="1">
	<tr>
		<td>도서코드</td>
		<td>${requestScope.dto.code }</td>
	</tr>
	<tr>
		<td>도서명</td>
		<td>${requestScope.dto.title }</td>
	</tr>
	<tr>
		<td>분류</td>
		<td>${requestScope.dto.category }</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${requestScope.dto.author }</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${requestScope.dto.publisher }</td>
	</tr>
	<tr>
		<td>발행일</td>
		<td>${requestScope.dto.publicationDate }</td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${requestScope.dto.regiDate }</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:right">
			<button type="button" onclick="move('list')">목록</button>
			<button type="button" onclick="move('chuga')">등록</button>
			<button type="button" onclick="move('sujung','${requestScope.dto.code }')">수정</button>
			<button type="button" onclick="move('sakje','${requestScope.dto.code }')">삭제</button>
		</td>
	</tr>
</table>

<script>
	function move(value1, value2) {
		let linkAddr = '${path }/book/'+ value1;
		if (value2 != undefined) {
			linkAddr += '?code='+ value2;
		}//if
		location.href = linkAddr;
	}//move
</script>