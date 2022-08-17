<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<%@page import="haksaSungjuk.model.dao.HaksaSungjukDAO"%>
<%@page import="haksaSungjuk.model.dto.HaksaSungjukDTO"%>

<%
	HaksaSungjukDAO sungjukDao = new HaksaSungjukDAO();
	ArrayList<HaksaSungjukDTO> sungjukList = sungjukDao.getSelectAll();
	
	int totalRecord = sungjukList.size();
%>

<h2>성적목록</h2>

<table border="1" width="80%">
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>시험구분</th>
		<th>총점</th>
		<th>평균</th>
		<th>등급</th>
		<th>등록일</th>
	</tr>
	<% 
		if (totalRecord == 0) { 
	%>
		<tr>
			<td colspan="7" height="200px" align="center">저장된 정보가 없습니다.</td>
		</tr>
	<% }//if %>
	<%
		int num = totalRecord;
		for (HaksaSungjukDTO sungjukResultDto : sungjukList) {
	%>
			<tr>
				<td><%=num-- %></td>	
				<td><a href="#" onClick="move('view.jsp','<%=sungjukResultDto.getSungjukNo() %>')"><%=sungjukResultDto.getName() %></a></td>
				<td><%=sungjukResultDto.getSihumName() %></td>
				<td><%=sungjukResultDto.getTot() %></td>
				<td><%=sungjukResultDto.getAvg() %></td>
				<td><%=sungjukResultDto.getGrade() %></td>
				<td><%=sungjukResultDto.getRegiDate() %></td>
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