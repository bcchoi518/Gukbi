<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@page import="guestBook.model.dto.GuestBookDTO"%>
<%@page import="guestBook.model.dao.GuestBookDAO"%>

<%
	GuestBookDAO guestBookDao = new GuestBookDAO();
	ArrayList<GuestBookDTO> guestBookList = guestBookDao.getSelectAll();
%>

<h2>방명록목록</h2>

<table border="1" width="80%" style="text-align: center;">
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>이메일</th>
		<th>방명록내용</th>
		<th>등록일</th>
	</tr>
	<%
		for (GuestBookDTO guestBookResultDto : guestBookList) {
	%>
		<tr>
			<td><%=guestBookResultDto.getNo() %></td>
			<td><a href="#" onClick="move('guestBook_view','<%=guestBookResultDto.getNo() %>')"><%=guestBookResultDto.getName() %></a></td>
			<td><%=guestBookResultDto.getEmail() %></td>
			<td style="text-align:left"><%=guestBookResultDto.getContent() %></td>
			<td><%=guestBookResultDto.getRegiDate() %></td>
		</tr>
	<% }//for %>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('guestBook_list')">목록</a>
|
<a href="#" onClick="move('guestBook_chuga')">등록</a>
|
</div>
<form name="dataForm">
	<input type="hidden" name="menuGubun" />
	<input type="hidden" name="no" />
</form>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			document.dataForm.no.value = value2;
		}//if
		
		document.dataForm.menuGubun.value = value1;
		
		document.dataForm.action = 'main.jsp';
		document.dataForm.method = 'post';
		document.dataForm.submit();
	}//move
</script>