<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "_inc_top.jsp" %>

<h2>방명록 상세보기</h2>

<table border="1" width="80%">
	<tr>
		<td>이름</td>
		<td>${requestScope.dto.name }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${requestScope.dto.email }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${fn:replace(requestScope.dto.content, requestScope.newLine, '<br>') }</td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${requestScope.dto.regiDate }</td>
	</tr>
</table>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${path }/guestBook/list" >전체목록</a>
|
<a href="#" onclick="move('list')">목록</a>
|
<a href="#" onclick="move('chuga')">등록</a>
|
<a href="#" onclick="move('sujung','${requestScope.dto.no }')">수정</a>
|
<a href="#" onclick="move('sakje','${requestScope.dto.no }')">삭제</a>
|
</div>

<script>
	function move(value1, value2) {
		let linkAddr = '${path }/guestBook/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>