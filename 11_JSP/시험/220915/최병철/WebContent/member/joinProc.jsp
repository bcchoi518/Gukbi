<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="member.model.dto.DTO"%>
<%@page import="member.model.dao.DAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String job = request.getParameter("job");
	
	int errCounter = 0;
	if (id == null || id.trim().equals("")) {
		errCounter++;
	} else if (pwd == null || pwd.trim().equals("")) {
		errCounter++;
	} else if (name == null || name.trim().equals("")) {
		errCounter++;
	} else if (phone == null || phone.trim().equals("")) {
		errCounter++;
	} else if (job == null || job.trim().equals("")) {
		errCounter++;
	}//if
	
	if (errCounter > 0) {
		out.println("<script>");
		out.println("alert('정상적인 값이 입력되지 않았습니다.');");
		out.println("location.href = 'join.jsp';");
		out.println("</script>");
		return;
	}//if
	
	DTO arguDto = new DTO();
	arguDto.setId(id);
	arguDto.setPwd(pwd);
	arguDto.setName(name);
	arguDto.setPhone(phone);
	arguDto.setJob(job);
	
	DAO dao = new DAO();
	int result = dao.setInsert(arguDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("alert('가입이 정상적으로 완료되었습니다.');");
		out.println("location.href = 'join.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('가입 처리 중 오류가 발생했습니다.');");
		out.println("location.href = 'join.jsp';");
		out.println("</script>");
	}//if

%>