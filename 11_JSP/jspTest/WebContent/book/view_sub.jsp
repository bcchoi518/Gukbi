<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="book.model.dto.BookDTO"%>
<%@ page import="book.model.dao.BookDAO"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	
	BookDAO dao = new BookDAO();
	BookDTO arguDto = new BookDTO();
	arguDto.setNo(no);
	BookDTO resultDto = dao.getSelectOne(arguDto);
%>

<h2>도서상세보기</h2>

<table border="1" width="80%">
	<tr>
		<th>제목</th>
		<td><%=resultDto.getSubject() %></td>
	</tr>
	<tr>
		<th>저자</th>
		<td><%=resultDto.getAuthor() %></td>
	</tr>
	<tr>
		<th>발행일</th>
		<td><%=resultDto.getCreated() %></td>
	</tr>
	<tr>
		<th>분류</th>
		<td><%=resultDto.getProfile() %></td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><%=resultDto.getRegiDate() %></td>
	</tr>
</table>
<div style="width:80%; text-align:right; margin-top:10px; margin-botton:20px;">
|
<a href="#" onClick="move('list.jsp')">목록</a>
|
<a href="#" onClick="move('chuga.jsp')">등록</a>
|
<a href="#" onClick="move('sujung.jsp','<%=no %>')">수정</a>
|
<a href="#" onClick="move('sakje.jsp','<%=no %>')">삭제</a>
|
</div>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = value1 + '?no=' + value2;
		} else {
			location.href = value1;
		}//if
	}//move
</script>