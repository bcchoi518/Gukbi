<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.nio.file.Paths"%>
<%@ page import="java.nio.file.Files"%>
<%@ page import="java.util.List"%>

<%@ page import="config.Constants"%>

<%@ include file = "../include/inc_dbInfo.jsp" %>

<%
	String attachPath = Constants.ATTACH_PATH;
	String uploadPath = attachPath + request.getContextPath();
	String uploadFile = uploadPath + "/member.txt";
	List<String> list = Files.readAllLines(Paths.get(uploadFile));
%>
	<h2>회원목록</h2>
	
	<table border="1" align="center" width="70%">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>등록일</th>
		</tr>
<%
		int totalCounter = list.size();
		try {
			for (int i = list.size(); i >= 1; i--) {
				String[] imsiArray = list.get(i - 1).split(",");
%>
			<tr>
				<td><%=totalCounter-- %></td>
				<td><a href="#" onClick="move('memberFile_view', '<%=imsiArray[0] %>');"><%=imsiArray[0] %></a></td>
				<td><%=imsiArray[2] %></td>
				<td><%=imsiArray[3] %></td>
				<td><%=imsiArray[5] %></td>
				<td><%=imsiArray[6] %></td>
			</tr>
<%
			}//end for
			System.out.println("파일 읽기 성공..");
		} catch (Exception e) {
// 			e.printStackTrace();
			System.out.println("파일 읽기 실패..");
		}//end try-catch
%>
	</table>
	
	<div style="border: 0px solid blue; width: 70%; margin-top: 10px;" align="right">
	|
	<a href="#" onClick="move('memberFile_list');">목록</a>
	|
	<a href="#" onClick="move('memberFile_chuga');">등록</a>
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
