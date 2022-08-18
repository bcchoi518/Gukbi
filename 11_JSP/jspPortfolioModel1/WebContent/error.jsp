<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorCode = request.getParameter("errorCode");
	
	String message = "";
	String linkAddr = "";
	
	if (errorCode.equals("001")) {
		message = "정상적인 접속이 아닙니다.(구분자없음)";
		linkAddr = "/jspPortfolioModel1";
		return;
	}//if
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=linkAddr %>">이동</a>
</body>
</html>