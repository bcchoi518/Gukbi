<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="memberBasic.MemberBasicDTO"%>
<%@ page import="memberBasic.MemberBasicDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	String no_ = request.getParameter("no");

	int failCounter = 0;
	if (no_ == null || no_.trim().equals("")) {
		failCounter++;
	}//if
	
	int no = 0;
	try {
		no = Integer.parseInt(no_);
	} catch (Exception e) {
// 		e.printStackTrace();
		no = 0;
		failCounter++;
	}//try-catch
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
		return;
	}//if
	
	String passwd = request.getParameter("passwd");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String juso1 = request.getParameter("post1");
	String juso2 = request.getParameter("post2");
	String juso3 = request.getParameter("post3");
	String juso4 = request.getParameter("post4");
	
	if (passwd == null || passwd.trim().equals("")) {
		failCounter++;
	} else if (phone == null || phone.trim().equals("")) {
		failCounter++;
	} else if (email == null || email.trim().equals("")) {
		failCounter++;
	} else if (juso1 == null || juso1.trim().equals("")) {
		failCounter++;
	} else if (juso2 == null || juso2.trim().equals("")) {
		failCounter++;
	} else if (juso3 == null || juso3.trim().equals("")) {
		failCounter++;
	} else if (juso4 == null || juso4.trim().equals("")) {
		juso4 = "-";
	}//if
	
	if (failCounter > 0) {
		out.println("<script>");
		out.println("alert('입력한 값이 정확하지 않습니다.');");
		out.println("location.href='sujung.jsp?no=" + no + "';");
		out.println("</script>");
		return;
	}//if
	
	MemberBasicDAO dao = new MemberBasicDAO();
	MemberBasicDTO arguDto = new MemberBasicDTO();
	
	arguDto.setNo(no);
	arguDto.setPasswd(passwd);
	arguDto.setPhone(phone);
	arguDto.setEmail(email);
	arguDto.setJuso1(juso1);
	arguDto.setJuso2(juso2);
	arguDto.setJuso3(juso3);
	arguDto.setJuso4(juso4);
	
	int result = dao.setUpdate(arguDto);
	
	String ment = "수정 처리중 오류가 발생했습니다.";
	String moveUrl = "sujung.jsp?no=" + no;
	if (result > 0) {
		ment = "정상적으로 수정되었습니다.";
		moveUrl = "view.jsp?no=" + no;
	}//if
	
	out.println("<script>");
	out.println("alert('"+ ment +"');");
	out.println("location.href='"+ moveUrl +"';");
	out.println("</script>");
%>