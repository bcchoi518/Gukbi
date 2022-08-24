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
	
	//예외처리 중요하니까 모든 가능성을 생각하자
	if (memberResultDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 회원입니다.'); location.href='main.jsp?menuGubun=member_list'; </script>");
		return;
	}//if
%>

<h2>회원상세보기</h2>
<table border="0" align="center">
	<tr>
		<td class="entryName">아이디 : </td>
		<td colspan="3"><%=memberResultDto.getId() %></td>
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
				}//for
			}//if
		%>
	</tr>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('member_list')">목록</a>
|
<a href="#" onClick="move('member_chuga')">등록</a>
|
<a href="#" onClick="move('member_sujung','<%=no %>')">수정</a>
|
<a href="#" onClick="move('member_sujungAttach','<%=no %>')">수정(attach)</a>
|
<a href="#" onClick="move('member_sakje','<%=no %>')">삭제</a>
|
</div>
<form name="dataForm">
	<input type="hidden" name="menuGubun" />
	<input type="hidden" name="no" />
</form>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			document.dataForm.no.value = value2;
// 			location.href = 'main.jsp?menuGubun=' + value1 + "&no=" + value2;
		} else {
// 			location.href = 'main.jsp?menuGubun=' + value1;
		}//if
		
		document.dataForm.menuGubun.value = value1;
		
		document.dataForm.action = 'main.jsp';
		document.dataForm.method = 'post';
		document.dataForm.submit();
	}//move
</script>