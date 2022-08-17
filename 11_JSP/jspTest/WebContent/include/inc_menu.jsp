<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI().toString();
	String menuGubun = request.getParameter("menuGubun");
	
	String pgName = "";
	if (menuGubun == null) {
		String[] pgNameArray = url.split("/");
		pgName = pgNameArray[pgNameArray.length - 2];
	} else {
		String[] menuGubunArray = menuGubun.split("_");
		pgName = menuGubunArray[0];
	}//end if
	
%>

|
<a href = "<%=path %>">Home</a>
|
<a href = "../member/list.jsp">
<%	if (pgName.equals("member")) {	%>
	<font style="color: red; font-weight: bold;">회원관리</font>
<%	} else {
		out.println("회원관리");
	}//end if
%>
</a>
|
<a href = "../product/list.jsp">
<%	if (pgName.equals("product")) {	%>
	<font style="color: red; font-weight: bold;">상품관리</font>
<%	} else {
		out.println("상품관리");
	}//end if
%>
</a>
|
<a href = "../useBean/chuga.jsp">
<%	if (pgName.equals("useBean")) {	%>
	<font style="color: red; font-weight: bold;">useBean</font>
<%	} else {
		out.println("useBean");
	}//end if
%>
</a>
|
<a href = "../main/main.jsp?menuGubun=member2_list">
<%	if (pgName.equals("member2")) {	%>
	<font style="color: red; font-weight: bold;">회원관리2</font>
<%	} else {
		out.println("회원관리2");
	}//end if
%>
</a>
|
<a href = "../main/main.jsp?menuGubun=product2_list">
<%	if (pgName.equals("product2")) { %>
	<font style="color: red; font-weight: bold;">상품관리2</font>
<%	} else {
		out.println("상품관리2");
	}//end if
%>
</a>
|
<a href = "../main/main.jsp?menuGubun=memberFile_list">
<%	if (pgName.equals("memberFile")) {	%>
	<font style="color: red; font-weight: bold;">회원관리(File)</font>
<%	} else {
		out.println("회원관리(File)");
	}//end if
%>
</a>
|
<%-- <a href = "../main/main.jsp?menuGubun=memberBasic_list"> --%>
<a href = "../memberBasic/list.jsp">회원관리(Basic)</a>
|
<a href = "../book/list.jsp">도서관리(Book)</a>
|
<a href = "../bookAuthor/list.jsp">저자관리(Book)</a>
|
<a href = "../bookProfile/list.jsp">분류관리(Book)</a>
|
<a href = "../bookInfo/list.jsp">도서정보관리(Book)</a>
|
<br>
|
<a href = "../haksaMember/list.jsp">학사관리(Member)</a>
|
<a href = "../haksaSihum/list.jsp">학사관리(Sihum)</a>
|
<a href = "../haksaSungjuk/list.jsp">학사관리(Sungjuk)</a>
|