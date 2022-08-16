<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="bookAuthor.model.dto.BookAuthorDTO"%>
<%@page import="bookAuthor.model.dao.BookAuthorDAO"%>

<%@page import="java.util.ArrayList"%>

<%
	BookAuthorDAO dao = new BookAuthorDAO();
	ArrayList<BookAuthorDTO> list = dao.getSelectAll();
	
	int totalRecord = list.size();
%>
<h2>저자목록</h2>
<form name="listForm">
<table border="1" width="80%" align="center">
	<tr>
		<th>순번</th>
		<th>저자</th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
	<% if (totalRecord == 0) { %>
		<tr>
			<td colspan="3" height="200px" align="center">등록된 내용이 없습니다.</td>
		</tr>
	<% } %>
	<% 
		int num = totalRecord;
		for (int i = 0; i < list.size(); i++) {
			BookAuthorDTO resultDto = list.get(i);
	%>
		<tr>
			<td><%=num-- %> (<%=resultDto.getAuthorNo() %>)</td>
			<td>
				<input type="text" name="author_<%=i %>" value="<%=resultDto.getAuthor() %>">
				<input type="hidden" name="authorNo_<%=i %>" value="<%=resultDto.getAuthorNo() %>">
			</td>
			<td><%=resultDto.getRegiDate() %></td>
			<td>
				<a href="#" onClick="move('sujung.jsp','<%=resultDto.getAuthorNo() %>')">[수정]</a>
				&nbsp;
				<a href="#" onClick="move('sakje.jsp','<%=resultDto.getAuthorNo() %>')">[삭제]</a>
			</td>
		</tr>
	<% } %>
</table>
<input type="hidden" name="totalCounter" value="<%=totalRecord %>" />
</form>
<div style="width:80%; text-align:right; margin-top:10px; margin-botton:20px;">
|
<a href="#" onClick="sujung()">수정하기</a>
|
<a href="#" onClick="move('list.jsp')">목록</a>
|
<a href="#" onClick="move('chuga.jsp')">등록</a>
|
</div>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = value1 + '?authorNo=' + value2;
		} else {
			location.href = value1;
		}//if
	}//move
	function sujung() {
		if (confirm('수정할까요?')) {
			document.listForm.action = "listSujungProc.jsp";
			document.listForm.method = "post";
			document.listForm.submit();
		}//if
	}//sujung
</script>