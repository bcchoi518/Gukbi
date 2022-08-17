<%@page import="haksaMember.model.dao.HaksaMemberDAO"%>
<%@page import="haksaMember.model.dto.HaksaMemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String parentPhone = request.getParameter("parentPhone");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String addr3 = request.getParameter("addr3");
	String addr4 = request.getParameter("addr4");
	
	if (addr4 == null || addr4.trim().equals("")) {
		addr4 = "-";
	}//if
	
	HaksaMemberDTO memberDto = new HaksaMemberDTO();
	memberDto.setName(name);
	memberDto.setPhone(phone);
	memberDto.setParentPhone(parentPhone);
	memberDto.setAddr1(addr1);
	memberDto.setAddr2(addr2);
	memberDto.setAddr3(addr3);
	memberDto.setAddr4(addr4);
	
	HaksaMemberDAO memberDao = new HaksaMemberDAO();
	int result = memberDao.setInsert(memberDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='list.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
		out.println("location.href='chuga.jsp';");
		out.println("</script>");
	}//if
%>