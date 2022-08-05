<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI().toString();
	
	String[] pgNameArray = url.split("/");
	String pgName = pgNameArray[pgNameArray.length - 2];
%>

|
<a href = "<%=path %>">Home</a>
|
<a href = "../member/list.jsp">
<%
	if (pgName.equals("member")) {
%>
	<font style="color: red; font-weight: bold;">회원관리</font>
<%
	} else {
		out.println("회원관리");
	}//end if
%>
</a>
|
<a href = "../product/list.jsp">
<%
	if (pgName.equals("product")) {
%>
	<font style="color: red; font-weight: bold;">상품관리</font>
<%
	} else {
		out.println("상품관리");
	}//end if
%>
</a>
|
<a href = "../useBean/chuga.jsp">
<%
	if (pgName.equals("useBean")) {
%>
	<font style="color: red; font-weight: bold;">useBean</font>
<%
	} else {
		out.println("useBean");
	}//end if
%>
</a>
|
<a href = "../main/main.jsp?menuGubun=member2_list">회원관리2</a>
|
<a href = "../main/main.jsp?menuGubun=product2_list">상품관리2</a>
|