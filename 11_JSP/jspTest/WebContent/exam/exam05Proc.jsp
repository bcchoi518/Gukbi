<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	
	out.println("name: " + name);
	out.println("age: " + age);
	out.println("gender: " + gender);
%>

<form name="procForm">
	<input type="hidden" name="name" value="<%=name %>" />
	<input type="hidden" name="age" value="<%=age %>" /> 
	<input type="hidden" name="gender" value="<%=gender %>" /> 
</form>

<script>
	function submitForm() {
		document.procForm.action="exam05Result.jsp";
		document.procForm.method="post";
		document.procForm.submit();
	}//end submitForm
	submitForm();
</script>