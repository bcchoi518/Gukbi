<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.nio.file.Paths"%>
<%@ page import="java.nio.file.Files"%>
<%@ page import="java.util.List"%>

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
	
	String attachPath = "D:/Developement/attach";
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

	<h2>회원상세보기</h2>
		<table border="1" align="center" width="50%">
			<tr>
				<td>아이디</td>
				<td><%=id %></td>
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
				<td>주소</td>
				<td><%=regiDate %></td>
			</tr>
		</table>
	<div style="border: 0px solid blue; width: 50%; margin-top: 10px;" align="right">
	|
	<a href="#" onClick="move('memberFile_list');">목록</a>
	|
	<a href="#" onClick="move('memberFile_chuga');">등록</a>
	|
	<a href="#" onClick="move('memberFile_sujung', '<%=id %>');">수정</a>
	|
	<a href="#" onClick="move('memberFile_sakje', '<%=id %>');">삭제</a>
	|
	</div>
	<script>
		function move(value1, value2) {
			if (value2 != undefined) {
				location.href = 'main.jsp?menuGubun=' + value1 + '&arg1=' + value2;
			} else {
				location.href = 'main.jsp?menuGubun=' + value1;
			}//end if
		}//end move
	</script>