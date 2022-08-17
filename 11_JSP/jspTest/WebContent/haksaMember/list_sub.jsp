<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<%@page import="haksaMember.model.dao.HaksaMemberDAO"%>
<%@page import="haksaMember.model.dto.HaksaMemberDTO"%>

<%
	HaksaMemberDAO memberDao = new HaksaMemberDAO();
	ArrayList<HaksaMemberDTO> memberList = memberDao.getSelectAll();
	
	int totalRecord = memberList.size();
%>

<h2>학생목록</h2>

<table border="1" width="80%">
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>연락처</th>
		<th>주소</th>
		<th>등록일</th>
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
		for (HaksaMemberDTO memberResultDto : memberList) {
	%>
			<tr>
				<td><%=num-- %></td>	
				<td><a href="#" onClick="move('view.jsp','<%=memberResultDto.getHakbun() %>')"><%=memberResultDto.getName() %></a></td>	
				<td><%=memberResultDto.getPhone() %></td>
				<td>
					(<%=memberResultDto.getAddr1() %>) <%=memberResultDto.getAddr2() %> <%=memberResultDto.getAddr3() %> <%=memberResultDto.getAddr4() %>
				</td>	
				<td><%=memberResultDto.getRegiDate() %></td>	
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