<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="sqlTest0819.EmployeesDAO"%>
<%@page import="sqlTest0819.EmployeesDTO"%>

<%
	EmployeesDTO Dto = new EmployeesDTO();
	Dto.setFirst_name("Steven");
	Dto.setLast_name("King");
	EmployeesDAO employeesDao = new EmployeesDAO();
	EmployeesDTO resultDto = employeesDao.getSelectOne(Dto);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table boder="1">
		<tr>
			<td>employee_id : </td>
			<td><%=resultDto.getEmployee_id() %></td>
		</tr>
		<tr>
			<td>first_name : </td>
			<td><%=resultDto.getFirst_name() %></td>
		</tr>
		<tr>
			<td>last_name : </td>
			<td><%=resultDto.getLast_name() %></td>
		</tr>
		<tr>
			<td>email : </td>
			<td><%=resultDto.getEmail() %></td>
		</tr>
		<tr>
			<td>phone_number : </td>
			<td><%=resultDto.getPhone_number() %></td>
		</tr>
		<tr>
			<td>hire_date : </td>
			<td><%=resultDto.getHire_date() %></td>
		</tr>
		<tr>
			<td>job_id : </td>
			<td><%=resultDto.getJob_id() %></td>
		</tr>
		<tr>
			<td>salary : </td>
			<td><%=resultDto.getSalary() %></td>
		</tr>
		<tr>
			<td>commission_pct : </td>
			<td><%=resultDto.getCommission_pct() %></td>
		</tr>
		<tr>
			<td>manager_id : </td>
			<td><%=resultDto.getManager_id() %></td>
		</tr>
		<tr>
			<td>department_id : </td>
			<td><%=resultDto.getDepartment_id() %></td>
		</tr>
	</table>
</body>
</html>