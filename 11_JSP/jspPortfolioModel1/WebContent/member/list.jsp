<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>

<%@page import="member.model.dto.MemberDTO"%>
<%@page import="member.model.dao.MemberDAO"%>

<%
	MemberDAO memberDao = new MemberDAO();
	ArrayList<MemberDTO> memberList = memberDao.getSelectAll();
%>

<h2>회원목록</h2>

<table border="1" width="80%" style="text-align: center;">
	<tr>
		<th>순번</th>
		<th>사진</th>
		<th>아이디</th>
		<th>이름</th>
		<th>연락처</th>
		<th>주민번호</th>
		<th>등급</th>
		<th>등록일</th>
	</tr>
	<%
		for (MemberDTO memberResultDto : memberList) {
	%>
		<tr>
			<td><%=memberResultDto.getNo() %></td>
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
			<td><a href="#" onClick="move('member_view','<%=memberResultDto.getNo() %>')"><%=memberResultDto.getId() %></a></td>
			<td><%=memberResultDto.getName() %></td>
			<td><%=memberResultDto.getPhone() %></td>
			<td><%=memberResultDto.getJumin().substring(0, 8) %>******</td>
			<td><%=memberResultDto.getGrade() %></td>
			<td><%=memberResultDto.getRegiDate() %></td>
		</tr>
	<% }//for %>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('member_list')">목록</a>
|
<a href="#" onClick="move('member_chuga')">등록</a>
|
<a href="#" onClick="move('member_attachChuga')">등록(attach)</a>
|
</div>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = 'main.jsp?menuGubun=' + value1 + "&no=" + value2;
		} else {
			location.href = 'main.jsp?menuGubun=' + value1;
		}//if
	}//move
</script>