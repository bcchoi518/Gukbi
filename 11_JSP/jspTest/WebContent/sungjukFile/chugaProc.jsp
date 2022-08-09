<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_fileInfo.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String kor_ = request.getParameter("kor");
	String eng_ = request.getParameter("eng");
	String mat_ = request.getParameter("mat");
	String sci_ = request.getParameter("sci");
	String his_ = request.getParameter("his");
	
	if (name == null || name.trim().equals("")) {
		out.println("<script>");
		out.println("alert('이름을 입력하지 않았습니다.');");
		out.println("location.href='chuga.jsp';");
		out.println("</script>");
	} else if (kor_ == null || kor_.trim().equals("")) {
		kor_ = "0";
	} else if (eng_ == null || eng_.trim().equals("")) {
		eng_ = "0";
	} else if (mat_ == null || mat_.trim().equals("")) {
		mat_ = "0";
	} else if (sci_ == null || sci_.trim().equals("")) {
		sci_ = "0";
	} else if (his_ == null || his_.trim().equals("")) {
		his_ = "0";
	}//if
	
	String msg = name + "," + kor_ + "," + eng_ + "," + mat_ + "," + sci_ + "," + his_ + "\n";
	
	int result = 0;
	try {
		FileWriter fw = new FileWriter(uploadFile, true);
		fw.write(msg);
		fw.close();
		result++;
	} catch (Exception e) {
		//e.printStackTrace();
		result = 0;
	}//try-catch
	
	String movePage = "chuga";
	String alertMsg = "등록 중 오류가 발생했습니다.";
	if (result > 0) {
		alertMsg = "정상적으로 등록되었습니다.";
		movePage = "list";
	}//if
	
	out.println("<script>");
	out.println("alert('" + alertMsg + "');");
	out.println("location.href='" + movePage + ".jsp';");
	out.println("</script>");
%>