<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String passwd = request.getParameter("pw");
	String name = request.getParameter("name");
	String nickname = request.getParameter("nickname");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String jumin = request.getParameter("jumin");
	String address = request.getParameter("address");
	
	out.println(id + "<br>");
	out.println(passwd + "<br>");
	out.println(name + "<br>");
	out.println(nickname + "<br>");
	out.println(phone + "<br>");
	out.println(email + "<br>");
	out.println(jumin + "<br>");
	out.println(address + "<br>");
%>

<script>
	function move() {
		location.href='exam04Result.jsp?id=<%=id%>&name=<%=name%>';
	}
	move();
</script>