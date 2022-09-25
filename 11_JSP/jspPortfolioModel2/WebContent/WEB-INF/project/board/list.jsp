<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_header.jsp" %>

<h2>게시글목록</h2>

<table border="1" width="80%" align="center">
	<tr>
		<th>순번</th>
		<th>작성자</th>
		<th>제목</th>
		<th>조회수</th>
		<th>등록일</th>
	</tr>
	<c:if test="${fn:length(requestScope.list) <= 0 }">
		<tr>
			<td colspan="5" height="200px" style="text-align:center;">등록된 글이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="boardDto" items="${requestScope.list }">
		<tr>
			<td>${boardDto.no }</td>
			<td><a href="#" onclick="move('board_view.do','${boardDto.no }')">${boardDto.writer }</a></td>
			<td>${boardDto.subject }</td>
			<td>${boardDto.hit }</td>
			<td>${boardDto.regiDate }</td>
		</tr>
	</c:forEach>
</table>

<div style="border: 0px solid red; width: 80%; margin-top:10px;" align="right">
|
<a href="${requestScope.path }/board_servlet/board_list.do" >전체목록</a>
|
<a href="#" onclick="move('board_list.do')">목록</a>
|
<a href="#" onclick="move('board_chuga.do')">등록</a>
|
</div>

<script>
	function move(value1, value2) {
		let linkAddr = '${requestScope.path }/board_servlet/' + value1 + '?${requestScope.searchQuery }';
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>