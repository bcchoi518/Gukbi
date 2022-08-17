<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="haksaMember.model.dao.HaksaMemberDAO"%>
<%@page import="haksaMember.model.dto.HaksaMemberDTO"%>

<%
	String arg1_ = request.getParameter("arg1");
	int arg1 = Integer.parseInt(arg1_);
	
	HaksaMemberDTO memberArguDto = new HaksaMemberDTO();
	memberArguDto.setHakbun(arg1);
	
	HaksaMemberDAO memberDao = new HaksaMemberDAO();
	HaksaMemberDTO memberResultDto = memberDao.getSelectOne(memberArguDto);
%>

<h2>학생상세보기</h2>

<form name="DirForm">
	<table border="1" width="80%">
		<tr>
			<th>학번</th>
			<td><%=memberResultDto.getHakbun() %></td>	
		</tr>
		<tr>
			<th>이름</th>
			<td><%=memberResultDto.getName() %></td>	
		</tr>
		<tr>
			<th>연락처</th>
			<td><%=memberResultDto.getPhone() %></td>	
		</tr>
		<tr>
			<th>부모님연락처</th>
			<td><%=memberResultDto.getParentPhone() %></td>	
		</tr>
		<tr>
		<th>주소</th>
			<td>
				(<%=memberResultDto.getAddr1() %>) <%=memberResultDto.getAddr2() %> <%=memberResultDto.getAddr3() %> <%=memberResultDto.getAddr4() %>
			</td>
		</tr>
	</table>
</form>
<div style="width:80%; margin-top:10px; text-align:right;">
|
<a href="#" onClick="move('list.jsp')">목록</a>
|
<a href="#" onClick="move('chuga.jsp')">등록</a>
|
<a href="#" onClick="move('sujung.jsp','<%=arg1 %>')">수정</a>
|
<a href="#" onClick="move('sakje.jsp','<%=arg1 %>')">삭제</a>
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