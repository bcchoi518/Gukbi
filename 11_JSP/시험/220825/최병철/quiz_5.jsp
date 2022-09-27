<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String empNo_ = request.getParameter("empNo");
	String empName = request.getParameter("empName");
	String dptName = request.getParameter("dptName");
	String salary_ = request.getParameter("salary");
	String managerName = request.getParameter("managerName");
	
	int empNo = 0;	
	int salary = 0;	
	String imsi = "";
	
	imsi = empNo_;
	if (empNo_ != null && !empNo_.trim().equals("")) {
		for (int i = 0; i < 10; i++) {
			imsi = imsi.replace(i + "", "");
		}//for
		
		if (imsi.length() == 0) {
			empNo = Integer.parseInt(empNo_);
		}//if
	}//if
	
	imsi = salary_;
	if (salary_ != null && !salary_.trim().equals("")) {
		for (int i = 0; i < 10; i++) {
			imsi = imsi.replace(i + "", "");
		}//for
		
		if (imsi.length() == 0) {
			salary = Integer.parseInt(salary_);
		}//if
	}//if
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz_5</title>
<style>
	* {
		font-size: 1.5rem;
	}
</style>
</head>
<body>
	<form name="form" method="post" action="">
	<table border="0" align="center">
		<tr>
			<td>사원번호 : </td>
			<td><input type="text" name="empNo" /></td>
		</tr>
		<tr>
			<td>사원명 : </td>
			<td><input type="text" name="empName" /></td>
		</tr>
		<tr>
			<td>부서명 : </td>
			<td><input type="text" name="dptName" /></td>
		</tr>
		<tr>
			<td>급여 : </td>
			<td><input type="text" name="salary" /></td>
		</tr>
		<tr>
			<td>부서장명 : </td>
			<td><input type="text" name="managerName" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="출력" /></td>
		</tr>
	</table>
	</form>
	
	<% if (empName != null && !empName.trim().equals("")) { %>
		<hr>
		<table border="1" align="center">
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>부서명</th>
				<th>급여</th>
				<th>부서장명</th>
			</tr>
			<tr>
				<td><%=empNo %></td>
				<td><%=empName %></td>
				<td><%=dptName %></td>
				<td><%=salary %></td>
				<td><%=managerName %></td>
			</tr>
		</table>
	<% }//if %>
</body>
</html>