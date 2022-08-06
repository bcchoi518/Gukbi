<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menuGubun = request.getParameter("menuGubun");

	if (menuGubun == null || menuGubun.trim().equals("")) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.')");
		out.println("location.href='../main/main.jsp?menuGubun=product2_list';");
		out.println("</script>");
		return;
	}//end if
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
	<script type="text/javascript" src="../product2/_script.js"></script>
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="100px" align="center">
<!-- 		상단 메뉴 시작 -->
				<jsp:include page="../include/inc_menu.jsp" flush="true"></jsp:include>
<!-- 		상단 메뉴 종료 -->
			</td>
		</tr>
		<tr>
			<td height="300px" align="center">
<!-- 		본문 내용 시작 -->
			<% 
				String movePage = "../" + menuGubun.replace("_", "/") + ".jsp";
			%>
				<jsp:include page="<%=movePage %>" flush="true"></jsp:include> <!-- jsp 액션태그 -->
<!-- 		본문 내용 종료 -->
			</td>
		</tr>
		<tr>
			<td height="100px" align="center">
				<jsp:include page="../include/inc_bottom.jsp" flush="true"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>