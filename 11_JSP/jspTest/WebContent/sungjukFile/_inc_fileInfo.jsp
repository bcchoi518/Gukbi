<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*"%>
<%@ page import="java.util.Scanner"%>
<%@page import="java.util.ArrayList"%>

<%@ page import="config.Constants"%>

<%
	String attachPath = Constants.ATTACH_PATH;
	String uploadPath = attachPath + request.getContextPath();
	String uploadFile = uploadPath + "/sungjuk.txt";
	
	// 보안에 취약해서 이런식으로 사용하는 것은 좋지 않다고 생각됨
	java.io.File isDir = new java.io.File(uploadPath);
	if (!isDir.exists()) {
		try {
			isDir.mkdirs();
		} catch (Exception e) {
			//e.printStackTrace();			
		}//try-catch
	}//if
	java.io.File f = new java.io.File(uploadFile);
	if (!f.exists()) {
		f.createNewFile();
	}//if
%>