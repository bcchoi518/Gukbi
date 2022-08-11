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

<h2>도서수정</h2>

<form name="DirForm">
	<input type="hidden" name="no" value="<%=no %>" />
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" id="subject" value="<%=resultDto.getSubject() %>"/></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><input type="text" name="author" id="author" value="<%=resultDto.getAuthor() %>"/></td>
		</tr>
		<tr>
			<th>발행일</th>
			<td><input type="date" name="created" id="created" value="<%=resultDto.getCreated() %>"/></td>
		</tr>
		<tr>
			<th>분류</th>
			<td><input type="text" name="profile" id="profile" value="<%=resultDto.getProfile() %>"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" onClick="formSubmit()">수정하기</button>&nbsp;
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
 function formSubmit() {
	 if (confirm('수정할까요?')) {
		 document.DirForm.action = 'sujungProc.jsp';
		 document.DirForm.method = 'post';
		 document.DirForm.submit();
	 }//if
 }//formSubmit
</script>