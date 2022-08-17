<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<%@page import="haksaSihum.model.dao.HaksaSihumDAO"%>
<%@page import="haksaSihum.model.dto.HaksaSihumDTO"%>

<%
	HaksaSihumDAO sihumDao = new HaksaSihumDAO();
	ArrayList<HaksaSihumDTO> sihumList = sihumDao.getSelectAll();
	
	int totalRecord = sihumList.size();
%>

<h2>시험목록</h2>

<table border="1" width="80%">
	<tr>
		<th>순번</th>
		<th>시험이름</th>
		<th>시험날짜</th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
	<% 
		if (totalRecord == 0) { 
	%>
		<tr>
			<td colspan="5" height="200px" align="center">저장된 정보가 없습니다.</td>
		</tr>
	<% }//if %>
	<%
		int num = totalRecord;
		for (HaksaSihumDTO sihumResultDto : sihumList) {
	%>
			<tr>
				<td><%=num-- %></td>	
				<td><%=sihumResultDto.getSihumName() %></td>	
				<td><%=sihumResultDto.getSihumDate() %></td>
				<td><%=sihumResultDto.getRegiDate() %></td>
				<td>
					<a href="#" onClick="move('sujung.jsp','<%=sihumResultDto.getSihumNo() %>')">[수정]</a>
					&nbsp;
					<a href="#" onClick="move('sakje.jsp','<%=sihumResultDto.getSihumNo() %>')">[삭제]</a>
				</td>
			</tr>
	<% }//for %>
</table>
<div style="width:80%; margin-top:10px; text-align:right;">
|
<a href="#" onClick="move('list.jsp')">목록</a>
|
<a href="#" onClick="move('chuga.jsp')">등록</a>
|
</div>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = value1 + '?arg1=' + value2;
		} else {
			location.href = value1;
		}//if
	}//move
</script>