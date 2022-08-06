<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	
	String menuGubun = request.getParameter("menuGubun");
	
	if (menuGubun == null || menuGubun.trim().equals("")) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.')");
		out.println("location.href='../main/main.jsp?menuGubun=product2_list';");
		out.println("</script>");
		return;
	}//end if
	
	String includePage = "../" + menuGubun.replace("_", "/") + ".jsp";
%>
<jsp:include page="<%=includePage %>" flush="true"></jsp:include>