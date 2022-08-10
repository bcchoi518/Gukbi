<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="memberBasic.MemberBasicDAO"%>
<%@ page import="memberBasic.MemberBasicDTO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String arg1 = request.getParameter("arg1");
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO dto = new MemberBasicDTO();
	dto.setId(arg1);
	dto = dao.getSelectOne(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="100px" align="center">
				<jsp:include page="../include/inc_menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="300px" align="center">
<!-- 본문 내용 시작 -->
				<h2>회원상세보기</h2>
				<table border="1" width="70%">
					<tr>
						<th>아이디</th>
						<td><%=dto.getId() %></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><%=dto.getName() %></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><%=dto.getPhone() %></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%=dto.getEmail() %></td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><%=dto.getJumin() %></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><%="(" + dto.getJuso1() + ") " + dto.getJuso2() + " " + dto.getJuso3() + " " + dto.getJuso4()  %></td>
					</tr>
				</table>
				<div style="width:70%; text-align:right; margin-top:10px;">
				|
				<a href="#" onClick="move('list')">목록</a>
				|
				<a href="#" onClick="move('chuga')">등록</a>
				|
				<a href="#" onClick="move('sujung','<%=arg1 %>')">수정</a>
				|
				<a href="#" onClick="move('sakje','<%=arg1 %>')">삭제</a>
				|
				</div>
<!-- 본문 내용 끝 -->
			</td>
		<tr>
			<td height="100px" align="center">
				<jsp:include page="../include/inc_bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
	<script>
		function move(value1, value2) {
			if (value2 == undefined) {
				location.href = value1 + '.jsp';
			} else {
				location.href = value1 + '.jsp?arg1=' + value2;
			}//if
		}//move
	</script>
</body>
</html>