<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList"%>
    
<%@ page import="memberBasic.MemberBasicDAO"%>
<%@ page import="memberBasic.MemberBasicDTO"%>
    
<%
	MemberBasicDAO dao = new MemberBasicDAO();
	ArrayList<MemberBasicDTO> list = dao.getSelectAll();
%>
	<h2>회원목록</h2>
	<table border="1" width="70%">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>연락처</th>
			<th>주소</th>
			<th>등록일</th>
		</tr>
		<% 
			int totalCount = list.size();
			if (totalCount == 0) { 
		%>
				<tr>
					<td align="center" colspan="6" height="200px">
						등록된 내용이 없습니다.
					</td>
				</tr>
		<% 
			}//if
		%>
		<%
			for (MemberBasicDTO dto : list) {
		%>
				<tr>
					<td><%=totalCount-- %></td>
					<td><a href="#" onClick="move('view', '<%=dto.getNo() %>')"><%=dto.getId() %></a></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getPhone() %></td>
					<td>(<%=dto.getJuso1() %>) <%=dto.getJuso2() %> <%=dto.getJuso3() %> <%=dto.getJuso4() %></td>
					<td><%=dto.getRegiDate() %></td>
				</tr>
		<%		
			}//for
		%>
	</table>
	<div style="border:0px solid blue; width:70%; text-align:right; margin-top:10px; margin-botton:20px;">
	|
	<a href="#" onClick="move('list')">목록</a>
	|
	<a href="#" onClick="move('chuga')">등록</a>
	|
	</div>
	<script>
		function move(value1, value2) {
			if (value2 == undefined) {
				location.href = value1 + '.jsp';
			} else {
				location.href = value1 + '.jsp?no=' + value2;
			}//if
		}//move
	</script>