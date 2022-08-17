<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<%@page import="bookInfo.model.dao.BookInfoDAO"%>
<%@page import="bookInfo.model.dto.BookInfoDTO"%>

<%
	BookInfoDAO infoDao = new BookInfoDAO();
	ArrayList<BookInfoDTO> infoList = infoDao.getSelectAll();
	int totalRecode = infoList.size();
%>

<h2>도서정보목록</h2>

<table border="1" width="80%">
	<tr>
		<th>순번</th>
		<th>제목</th>
		<th>발행일</th>
		<th>저자</th>
		<th>분류</th>
		<th>등록일</th>
	</tr>
	<% if (totalRecode == 0) { %>
			<tr>
				<td colspan="6" height="200px" align="center">등록된 내용이 없습니다.</td>
			</tr>
	<% }//if %>
	<% for (BookInfoDTO infoResultDto : infoList) {	%>
		<tr>
			<td><%=totalRecode-- %></td>
			<td><a href="#" onClick="move('view.jsp','<%=infoResultDto.getInfoNo() %>')"><%=infoResultDto.getSubject() %></a></td>
			<td><%=infoResultDto.getCreated() %></td>
			<td><%=infoResultDto.getAuthor() %> (<%=infoResultDto.getAuthorNo() %>)</td>
			<td><%=infoResultDto.getProfile() %> (<%=infoResultDto.getProfileNo() %>)</td>
			<td><%=infoResultDto.getRegiDate() %></td>
		</tr>
	<% }//for %>
</table>
<div style="width:80%; text-align:right; margin-top:10px; margin-botton:20px;">
|
<a href="#" onClick="move('list.jsp')">목록</a>
|
<a href="#" onClick="move('chuga.jsp')">등록</a>
|
</div>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = value1 + '?infoNo=' + value2;
		} else {
			location.href = value1;
		}//if
	}//move
</script>