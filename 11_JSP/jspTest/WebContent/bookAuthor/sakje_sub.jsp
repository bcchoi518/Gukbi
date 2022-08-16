<%@page import="bookAuthor.model.dao.BookAuthorDAO"%>
<%@page import="bookAuthor.model.dto.BookAuthorDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String authorNo_ = request.getParameter("authorNo");
	int authorNo = Integer.parseInt(authorNo_);
	
	BookAuthorDTO arguDto = new BookAuthorDTO();
	arguDto.setAuthorNo(authorNo);
	
	BookAuthorDAO dao = new BookAuthorDAO();
	BookAuthorDTO resultDto = dao.getSelectOne(arguDto);
%>

<h2>저자삭제</h2>

<form name="DirForm">
	<input type="hidden" name="authorNo" value="<%=authorNo %>" />
	<table border="1" width="80%" align="center">
		<tr>
			<th>저자명</th>
			<td><%=resultDto.getAuthor() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="formSubmit()">삭제하기</button>
				<button type="button" onClick="location.href='list.jsp'">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function formSubmit() {
		if (confirm('삭제할까요?')) {
			document.DirForm.action = "sakjeProc.jsp";
			document.DirForm.method = "post";
			document.DirForm.submit();
		}//if
	}//formSubmit
</script>