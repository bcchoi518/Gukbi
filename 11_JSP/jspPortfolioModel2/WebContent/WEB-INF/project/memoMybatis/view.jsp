<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>

<h2>메모상세보기 (Mybatis)</h2>

<table border="1" width="80%">
	<tr>
		<td>작성자</td>
		<td>${requestScope.dto.writer }</td>
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
<a href="${requestScope.path }/memoMybatis_servlet/memoMybatis_list.do" >전체목록</a>
|
<a href="#" onclick="move('memoMybatis_list.do')">목록</a>
|
<a href="#" onclick="move('memoMybatis_chuga.do')">등록</a>
|
<a href="#" onclick="move('memoMybatis_sujung.do','${requestScope.dto.no }')">수정</a>
|
<a href="#" onclick="move('memoMybatis_sakje.do','${requestScope.dto.no }')">삭제</a>
|
</div>

<script>
	function move(value1, value2) {
		let linkAddr = '${requestScope.path }/memoMybatis_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>