<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="bookInfo.model.dto.BookInfoDTO"%>
<%@page import="bookInfo.model.dao.BookInfoDAO"%>

<%
	String infoNo_ = request.getParameter("infoNo");
	int infoNo = Integer.parseInt(infoNo_);
	
	BookInfoDAO infoDao = new BookInfoDAO();
	BookInfoDTO infoArguDto = new BookInfoDTO();
	infoArguDto.setInfoNo(infoNo);
	BookInfoDTO infoResultDto = infoDao.getSelectOne(infoArguDto);
%>

<h2>도서정보삭제</h2>

<form name="DirForm">
	<input type="hidden" name="infoNo" value="<%=infoNo %>" />
	<table border="1" width="80%">
		<tr>
			<th>제목</th>
			<td><%=infoResultDto.getSubject() %></td>
		</tr>
		<tr>
			<th>발행일</th>
			<td><%=infoResultDto.getCreated() %></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><%=infoResultDto.getAuthor() %> (<%=infoResultDto.getAuthorNo() %>)</td>
		</tr>
		<tr>
			<th>분류</th>
			<td><%=infoResultDto.getProfile() %> (<%=infoResultDto.getProfileNo() %>)</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><%=infoResultDto.getRegiDate() %></td>
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