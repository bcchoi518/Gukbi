<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="bookInfo.model.dto.BookInfoDTO"%>
<%@page import="bookInfo.model.dao.BookInfoDAO"%>

<%
	String infoNo_ = request.getParameter("infoNo");
	int infoNo = Integer.parseInt(infoNo_);
	
	BookInfoDAO infoDao = new BookInfoDAO();
	BookInfoDTO arguDto = new BookInfoDTO();
	arguDto.setInfoNo(infoNo);
	BookInfoDTO resultDto = infoDao.getSelectOne(arguDto);
%>

<h2>도서정보상세보기</h2>
<form name="viewForm">
	<input type="hidden" name="infoNo" value="<%=resultDto.getInfoNo() %>" />
	<input type="hidden" name="authorNo" value="<%=resultDto.getAuthorNo() %>" />
	<input type="hidden" name="profileNo" value="<%=resultDto.getProfileNo() %>" />
	<table border="1" width="80%">
		<tr>
			<th>제목</th>
			<td><%=resultDto.getSubject() %></td>
		</tr>
		<tr>
			<th>발행일</th>
			<td><%=resultDto.getCreated() %></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><%=resultDto.getAuthor() %> (<%=resultDto.getAuthorNo() %>)</td>
		</tr>
		<tr>
			<th>분류</th>
			<td><%=resultDto.getProfile() %> (<%=resultDto.getProfileNo() %>)</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><%=resultDto.getRegiDate() %></td>
		</tr>
	</table>
</form>
<div style="width:80%; text-align:right; margin-top:10px; margin-botton:20px;">
|
<a href="#" onClick="move('list.jsp')">목록</a>
|
<a href="#" onClick="move('chuga.jsp')">등록</a>
|
<a href="#" onClick="sujung()">수정</a>
|
<a href="#" onClick="move('sakje.jsp','<%=infoNo %>')">삭제</a>
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
	function sujung() {
		document.viewForm.action = 'sujung.jsp';
		document.viewForm.method = 'post';
		document.viewForm.submit();
	}//sujung
</script>