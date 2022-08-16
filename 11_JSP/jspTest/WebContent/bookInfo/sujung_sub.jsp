<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="bookAuthor.model.dto.BookAuthorDTO"%>
<%@page import="bookAuthor.model.dao.BookAuthorDAO"%>

<%@page import="bookProfile.model.dto.BookProfileDTO"%>
<%@page import="bookProfile.model.dao.BookProfileDAO"%>

<%@page import="bookInfo.model.dto.BookInfoDTO"%>
<%@page import="bookInfo.model.dao.BookInfoDAO"%>

<%@page import="java.util.ArrayList"%>
<%
	String infoNo_ = request.getParameter("infoNo");
	String authorNo_ = request.getParameter("authorNo");
	String profileNo_ = request.getParameter("profileNo");
	int infoNo = Integer.parseInt(infoNo_);
	int authorNo = Integer.parseInt(authorNo_);
	int profileNo = Integer.parseInt(profileNo_);
	
	BookInfoDAO infoDao = new BookInfoDAO();
	BookInfoDTO infoArguDto = new BookInfoDTO();
	infoArguDto.setInfoNo(infoNo);
	BookInfoDTO infoResultDto = infoDao.getSelectOne(infoArguDto);
	
	BookAuthorDAO authorDao = new BookAuthorDAO();
	ArrayList<BookAuthorDTO> authorList = authorDao.getSelectAll();
	
	BookProfileDAO profileDao = new BookProfileDAO();
	ArrayList<BookProfileDTO> profileList = profileDao.getSelectAll();
%>

<h2>도서정보수정</h2>

<form name="DirForm">
	<input type="hidden" name="infoNo" value="<%=infoNo %>" />
	<table border="1" width="80%">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" id="subject" value="<%=infoResultDto.getSubject() %>"/></td>
		</tr>
		<tr>
			<th>발행일</th>
			<td><input type="date" name="created" id="created" value="<%=infoResultDto.getCreated() %>"/></td>
		</tr>
		<tr>
			<th>저자</th>
			<td>
				<select name="authorNo" id="authorNo">
					<option value="0" selected>-- 저자선택 --</option>
					<% for (BookAuthorDTO authorDto : authorList) { 
						String selectedValue = "";
						if (authorDto.getAuthorNo() == infoResultDto.getAuthorNo()) {
							selectedValue = "selected";
						}//if
					%>
						<option value="<%=authorDto.getAuthorNo()%>" <%=selectedValue %>><%=authorDto.getAuthor() %></option>
					<% }//for %>
				</select>
			</td>
		</tr>
		<tr>
			<th>분류</th>
			<td>
				<select name="profileNo" id="profileNo">
					<option value="0" selected>-- 분류선택 --</option>
					<% for (BookProfileDTO profileDto : profileList) { 
						String selectedValue = "";
						if (profileDto.getProfileNo() == infoResultDto.getProfileNo()) {
							selectedValue = "selected";
						}//if
					%>
						<option value="<%=profileDto.getProfileNo()%>" <%=selectedValue %>><%=profileDto.getProfile() %></option>
					<% }//for %>
				</select>
			</td>
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