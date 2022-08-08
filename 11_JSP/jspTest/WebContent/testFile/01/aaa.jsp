<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String fileName = request.getParameter("fileName");
	out.println(fileName);
	
	// attach 폴더까지의 경로
	String attachPath = "D:/Developement/attach";// -Unix D:\\Developement\\attach - windows
	// 파일이 저장되는 폴더의 경로
	String uploadPath = attachPath + "/testFile";
	String uploadFile = uploadPath + "/" + fileName;
	
	java.io.File f = new java.io.File(uploadFile);
	if (f.delete()) {
		response.sendRedirect("_08_directoryList.jsp");
	} else {
		response.sendRedirect("_08_directoryList.jsp");
	}//end if
%>