<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bookProfile.model.dto.BookProfileDTO"%>
<%@ page import="bookProfile.model.dao.BookProfileDAO"%>

<%@ page import="java.util.ArrayList"%>

<%
	BookProfileDAO dao = new BookProfileDAO();
	ArrayList<BookProfileDTO> list = dao.getSelectAll();
	
	int totalRecord = list.size();
%>
<h2>분류목록</h2>
<form name="listForm">
<table border="1" width="80%" align="center">
	<tr>
		<th>순번</th>
		<th>분류</th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
	<% if (totalRecord == 0) { %>
		<tr>
			<td colspan="3" height="200px" align="center">등록된 내용이 없습니다.</td>
		</tr>
	<% }//if %>
	<% 
		int num = totalRecord;
		for (int i = 0; i < list.size(); i++) {
			BookProfileDTO resultDto = list.get(i);
	%>
		<tr>
			<td><%=num-- %> (<%=resultDto.getProfileNo() %>)</td>
			<td>
				<input type="text" name="profile_<%=i %>" value="<%=resultDto.getProfile() %>">
				<input type="hidden" name="profileNo_<%=i %>" value="<%=resultDto.getProfileNo() %>">
			</td>
			<td><%=resultDto.getRegiDate() %></td>
			<td>
				<a href="#" onClick="move('sujung.jsp','<%=resultDto.getProfileNo() %>')">[수정]</a>
				&nbsp;
				<a href="#" onClick="move('sakje.jsp','<%=resultDto.getProfileNo() %>')">[삭제]</a>
			</td>
		</tr>
	<% }//for %>
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
			location.href = value1 + '?profileNo=' + value2;
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