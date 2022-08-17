<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menuGubun = request.getParameter("menuGubun");

	if (menuGubun == null || menuGubun.trim().equals("")) {
		menuGubun = "member_list";
	}//if
	
	String url = menuGubun.replace("_", "/") + ".jsp";
%>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	main.jsp <br>
	<%=menuGubun %><br>
	<%=url %><br>
</body>
</html>