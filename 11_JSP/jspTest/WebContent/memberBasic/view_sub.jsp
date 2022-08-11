<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memberBasic.MemberBasicDAO"%>
<%@ page import="memberBasic.MemberBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String no_ = request.getParameter("no");
	
	int failCounter = 0;
	if (no_ == null || no_.trim().equals("")) {
		failCounter++;
	}//if
	
	int no = 0;
	try {
		no = Integer.parseInt(no_);
	} catch (Exception e) {
// 		e.printStackTrace();
		no = 0;
		failCounter++;
	}//try-catch
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
		return;
	}//if
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO arguDto = new MemberBasicDTO();
	arguDto.setNo(no);
	MemberBasicDTO resultDto = dao.getSelectOne(arguDto);
%>

	<h2>회원상세보기</h2>
	<table border="1" width="70%">
		<tr>
			<th>아이디</th>
			<td><%=resultDto.getId() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=resultDto.getName() %></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><%=resultDto.getPhone() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=resultDto.getEmail() %></td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td><%=resultDto.getJumin().substring(0, 7)%>******</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>(<%=resultDto.getJuso1() %>) <%=resultDto.getJuso2() %> <%=resultDto.getJuso3() %> <%=resultDto.getJuso4() %></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><%=resultDto.getRegiDate() %></td>
		</tr>
	</table>
	<div style="border:0px solid blue; width:70%; text-align:right; margin-top:10px; margin-bottom:20px;">
	|
	<a href="#" onClick="move('list')">목록</a>
	|
	<a href="#" onClick="move('chuga')">등록</a>
	|
	<a href="#" onClick="move('sujung','<%=no %>')">수정</a>
	|
	<a href="#" onClick="move('sakje','<%=no %>')">삭제</a>
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