<%@page import="book.model.dto.BookDTO"%>
<%@page import="book.model.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	
	BookDAO dao = new BookDAO();
	BookDTO arguDto = new BookDTO();
	arguDto.setNo(no);
	BookDTO resultDto = dao.getSelectOne(arguDto);
%>

<h2>도서삭제</h2>

<form name="DirForm">
	<input type="hidden" name="no" value="<%=no %>" />
	<table border="1">
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
		<tr>
			<td colspan="2" align="center">
				<button type="button" onClick="formSubmit()">삭제하기</button>&nbsp;
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
 function formSubmit() {
	 if (confirm('삭제할까요?')) {
		 document.DirForm.action = 'sakjeProc.jsp';
		 document.DirForm.method = 'post';
		 document.DirForm.submit();
	 }//if
 }//formSubmit
</script>