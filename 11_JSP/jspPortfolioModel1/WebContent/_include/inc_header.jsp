<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.net.Inet4Address"%>

<%	
	request.setCharacterEncoding("UTF-8");
	
	String referer = request.getHeader("REFERER"); //현재 페이지에 접속하기 바로 전 페이지 주소 
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI().toString();
	String path = request.getContextPath(); //프로젝트
	String ip = Inet4Address.getLocalHost().getHostAddress(); // import java.net.Inet4Address;
	
// 	out.println(referer + "<br>");
// 	out.println(url + "<br>");
// 	out.println(uri + "<br>");
// 	out.println(ip + "<br>");
	
	String menuGubun = request.getParameter("menuGubun");
	
	if (menuGubun == null || menuGubun.trim().equals("")) {
		menuGubun = "member_list";
	//		out.println("<script>");
	//		out.println("location.href='error.jsp?errorCode=001';");
	//		out.println("</script>");
	}//if
	
	String[] imsiArray = menuGubun.split("_");
	String folderName = imsiArray[0];
	String fileName = imsiArray[1];
	
	String includePage = "../" + folderName + "/" + fileName + ".jsp";
%>