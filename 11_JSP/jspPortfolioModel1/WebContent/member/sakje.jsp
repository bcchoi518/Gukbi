<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.model.dao.MemberDAO"%>
<%@ page import="member.model.dto.MemberDTO"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	
	MemberDTO memberArguDto = new MemberDTO();
	memberArguDto.setNo(no);
	
	MemberDAO memberDao = new MemberDAO();
	MemberDTO memberResultDto = memberDao.getSelectOne(memberArguDto);
	
	if (memberResultDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 회원입니다.'); location.href='main.jsp?menuGubun=member_list'; </script>");
		return;
	}//if
%>

<h2>회원삭제</h2>
<form name="sakjeForm">
	<input type="hidden" name="no" value="<%=memberResultDto.getNo() %>" />
	<table border="0" align="center"> 
		<tr>
			<td>아이디 : </td>
			<td><%=memberResultDto.getId() %></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type="password" name="passwd" /></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><%=memberResultDto.getName() %></td>
		</tr>
		<tr>
			<td>연락처 : </td>
			<td><%=memberResultDto.getPhone() %></td>
		</tr>
		<tr>
			<td>이메일 : </td>
			<td><%=memberResultDto.getEmail() %></td>
		</tr>
		<tr>
			<td>주민번호 : </td>
			<td><%=memberResultDto.getJumin() %></td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td>(<%=memberResultDto.getJuso1() %>) <%=memberResultDto.getJuso2() %> <%=memberResultDto.getJuso3() %> <%=memberResultDto.getJuso4() %></td>
		</tr>
		<tr>
			<td>회원등급 : </td>
			<td><%=memberResultDto.getGrade() %></td>
		</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="sakje()">삭제하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=member_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function sakje() {
		if (confirm('삭제할까요?')) {
			document.sakjeForm.action = "mainProc.jsp?menuGubun=member_sakjeProc";
			document.sakjeForm.method = "post";
			document.sakjeForm.submit();
		}//if
	}//sakje
</script>