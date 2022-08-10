<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.nio.file.Paths"%>
<%@ page import="java.nio.file.Files"%>
<%@ page import="java.util.List"%>

<%@ page import="config.Constants"%>

<%
	String arg1 = request.getParameter("arg1");
	if (arg1 == null || arg1.trim().equals("")) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='main.jsp?menuGubun=memberFile_list';");
		out.println("</script>");
		return;
	}//end if
	
	String id = "";
	String passwd = "";
	String name = "";
	String phone = "";
	String email = "";
	String address = "";
	String regiDate = "";
	
	String attachPath = Constants.ATTACH_PATH;
	String uploadPath = attachPath + request.getContextPath();
	String uploadFile = uploadPath + "/member.txt";
	List<String> list = Files.readAllLines(Paths.get(uploadFile));
	
	for (String line : list) {
		String[] imsiArray = line.split(",");
		if (imsiArray[0].equals(arg1)) {
			id = imsiArray[0];
			passwd = imsiArray[1];
			name = imsiArray[2];
			phone = imsiArray[3];
			email = imsiArray[4];
			address = imsiArray[5];
			regiDate = imsiArray[6];
			break;
		}//end if
	}//end for
%>
	<h2>회원정보수정</h2>
	<form name="sakjeForm">
	<input type="hidden" name="arg1" value="<%=id %>" />
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><%=id %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password"	name="passwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=name %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%=phone %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=email %></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%=address %></td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="button" onClick="sakje();">삭제하기</button>
				</td>
			</tr>
		</table>
	</form>
	<script>
		function sakje() {
			document.sakjeForm.action = "mainProc.jsp?menuGubun=memberFile_sakjeProc";
			document.sakjeForm.method = "post";
			document.sakjeForm.submit();
		}//end join
	</script>