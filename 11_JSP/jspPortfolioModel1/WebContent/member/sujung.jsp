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

<h2>회원수정</h2>
<form name="sujungForm">
	<input type="hidden" name="no" value="<%=memberResultDto.getNo() %>" />
	<table border="0" align="center"> 
		<tr>
			<td class="entryName">아이디 : </td>
			<td><%=memberResultDto.getId() %></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호 : </td>
			<td><input type="password" name="passwd" /></td>
		</tr>
		<tr>
			<td class="entryName">이름 : </td>
			<td><%=memberResultDto.getName() %></td>
		</tr>
		<tr>
			<td class="entryName">연락처 : </td>
			<td><input type="text" name="phone" value="<%=memberResultDto.getPhone() %>"/></td>
		</tr>
		<tr>
			<td class="entryName">이메일 : </td>
			<td><input type="text" name="email" value="<%=memberResultDto.getEmail() %>"/></td>
		</tr>
		<tr>
			<td class="entryName">주민번호 : </td>
			<td><%=memberResultDto.getJumin().substring(0, 8) %>******</td>
		</tr>
		<tr>
			<td class="entryName">주소 : </td>
				<td>
					<input type="text" name="juso1" id="sample6_postcode" value="<%=memberResultDto.getJuso1() %>" placeholder="우편번호" readonly>
					<button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button><br>
					<input type="text" name="juso2" id="sample6_address" value="<%=memberResultDto.getJuso2() %>" placeholder="주소" readonly><br>
					<input type="text" name="juso3" id="sample6_detailAddress" value="<%=memberResultDto.getJuso3() %>" placeholder="상세주소">
					<input type="text" name="juso4" id="sample6_extraAddress" value="<%=memberResultDto.getJuso4() %>" placeholder="참고항목" readonly>
				</td>
		</tr>
		<tr>
			<td class="entryName">회원등급 : </td>
			<td>
				<input type="radio" name="grade" value="최우수회원" <% if (memberResultDto.getGrade().equals("최우수회원")) {out.println("checked");} %>/> 최우수회원 &nbsp;
				<input type="radio" name="grade" value="우수회원" <% if (memberResultDto.getGrade().equals("우수회원")) {out.println("checked");} %>/> 우수회원 &nbsp;
				<input type="radio" name="grade" value="일반회원" <% if (memberResultDto.getGrade().equals("일반회원")) {out.println("checked");} %> /> 일반회원 &nbsp;
			</td>
		</tr>
		<tr>
			<td class="entryName">사진첨부 : </td>
			<td>
				<%
					if (memberResultDto.getAttachInfo() == null || memberResultDto.getAttachInfo().equals("-")) {
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
							
							out.println("<img src=\""+ imsiImgPath + "\" width=\"50\" height=\"50\"><br>"+ imsiArray2[0] + "("+ imsiArray2[3] +") <br>");
						}//for
					}//if
				%>
			</td>
		</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="sujung()">수정하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=member_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function sujung() {
		if (confirm('수정할까요?')) {
			document.sujungForm.action = "mainProc.jsp?menuGubun=member_sujungProc";
			document.sujungForm.method = "post";
			document.sujungForm.submit();
		}//if
	}//sujung
</script>
<jsp:include page="_inc_daumApi.jsp" flush="true"></jsp:include>