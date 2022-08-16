<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@ page import="bookAuthor.model.dao.BookAuthorDAO"%>
<%@ page import="bookAuthor.model.dto.BookAuthorDTO"%>

<%@ page import="bookProfile.model.dao.BookProfileDAO"%>
<%@ page import="bookProfile.model.dto.BookProfileDTO"%>

<%
	BookAuthorDAO authorDao = new BookAuthorDAO();
	ArrayList<BookAuthorDTO> authorList = authorDao.getSelectAll();
	
	BookProfileDAO profileDao = new BookProfileDAO();
	ArrayList<BookProfileDTO> profileList = profileDao.getSelectAll();
%>

<h2>도서정보등록</h2>

<form name="DirForm">
	<table border="1" width="80%">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" id="subject"/></td>
		</tr>
		<tr>
			<th>발행일</th>
			<td><input type="date" name="created" id="created"/></td>
		</tr>
		<tr>
			<th>저자</th>
			<td>
				<select name="authorNo" id="authorNo">
					<option value="0" selected>-- 저자선택 --</option>
					<% for (BookAuthorDTO authorResultDto : authorList) { %>
						<option value="<%=authorResultDto.getAuthorNo()%>"><%=authorResultDto.getAuthor() %></option>
					<% }//for %>
				</select>
			</td>
		</tr>
		<tr>
			<th>분류</th>
			<td>
				<select name="profileNo" id="profileNo">
					<option value="0" selected>-- 분류선택 --</option>
					<% for (BookProfileDTO profileResultDto : profileList) { %>
						<option value="<%=profileResultDto.getProfileNo()%>"><%=profileResultDto.getProfile() %></option>
					<% }//for %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" onClick="formSubmit()">저장하기</button>&nbsp;
				<button type="button" onClick="location.href='list.jsp';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
 function formSubmit() {
	 if (confirm('저장할까요?')) {
		 document.DirForm.action = 'chugaProc.jsp';
		 document.DirForm.method = 'post';
		 document.DirForm.submit();
	 }//if
 }//formSubmit
</script>