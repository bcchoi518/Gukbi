<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/inc_top.jsp" %>

<h2>${requestScope.title }</h2>

<table border="1">
	<tr>
		<th>순번</th>
		<th>도서코드</th>
		<th>도서명</th>
		<th>분류</th>
		<th>등록일</th>
	</tr>
	<c:if test="${fn:length(requestScope.list) <= 0 }">
		<tr>
			<td colspan="5" style="text-align:center">등록된 도서가 없습니다.</td>
		</tr>
	</c:if>
	<c:set var="num" value="${fn:length(requestScope.list) }"/>
	<c:forEach var="dto" items="${requestScope.list }">
		<tr>
			<td>${num }</td>
			<td><a href="#" onclick="move('view','${dto.code}')">${dto.code }</a></td>
			<td>${dto.title }</td>
			<td>${dto.category }</td>
			<td>${dto.regiDate }</td>
		</tr>
		<c:set var="num" value="${num - 1 }"/>
	</c:forEach>
	<tr>
		<td colspan="5" style="text-align:right">
			<button type="button" onclick="move('list')">목록</button>
			<button type="button" onclick="move('chuga')">등록</button>
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