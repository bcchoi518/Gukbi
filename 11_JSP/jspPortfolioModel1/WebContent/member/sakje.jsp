<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>
    
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
			<td class="entryName">아이디 : </td>
			<td colspan="3"><%=memberResultDto.getId() %></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호 : </td>
			<td colspan="3"><input type="password" name="passwd" /></td>
		</tr>
		<tr>
			<td class="entryName">이름 : </td>
			<td colspan="3"><%=memberResultDto.getName() %></td>
		</tr>
		<tr>
			<td class="entryName">연락처 : </td>
			<td colspan="3"><%=memberResultDto.getPhone() %></td>
		</tr>
		<tr>
			<td class="entryName">이메일 : </td>
			<td colspan="3"><%=memberResultDto.getEmail() %></td>
		</tr>
		<tr>
			<td class="entryName">주민번호 : </td>
			<td colspan="3"><%=memberResultDto.getJumin().substring(0, 8) %>******</td>
		</tr>
		<tr>
			<td class="entryName">주소 : </td>
			<td colspan="3">(<%=memberResultDto.getJuso1() %>) <%=memberResultDto.getJuso2() %> <%=memberResultDto.getJuso3() %> <%=memberResultDto.getJuso4() %></td>
		</tr>
		<tr>
			<td class="entryName">회원등급 : </td>
			<td colspan="3"><%=memberResultDto.getGrade() %></td>
		</tr>

		<tr>
			<td class="entryName">첨부파일 : </td>
			<input type="hidden" name="attachInfo" value="<%=memberResultDto.getAttachInfo() %>" />
			<%
				if (memberResultDto.getAttachInfo() == null || memberResultDto.getAttachInfo().equals("") || memberResultDto.getAttachInfo().equals("-")) {
					out.println("&nbsp;");
				} else {
					String[] imsiArray = memberResultDto.getAttachInfo().split(",");
					for (int j = 0; j < imsiArray.length; j++) {
						String[] imsiArray2 = imsiArray[j].split("[|]");
						
						String imsiImgPath = "";
						imsiImgPath += request.getContextPath();
						imsiImgPath += "/attach";
						imsiImgPath += request.getContextPath();
						imsiImgPath += "/member/";
						imsiImgPath += imsiArray2[1];
						out.println("<td>");
						out.println("<img src=\""+ imsiImgPath + "\" width=\"50\" height=\"50\"><br>"+ imsiArray2[0] + "("+ imsiArray2[3] +")");
						out.println("</td>");
	// 					out.println("<input type=\"text\" name=\"attachInfo_" + j + "\" value=\""+ imsiArray2[1] +"\">");
					}//for
				}//if
			%>
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