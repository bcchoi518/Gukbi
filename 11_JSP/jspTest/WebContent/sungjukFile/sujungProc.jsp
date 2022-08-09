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
		out.println("location.href='sujung.jsp?name=" + name + "';");
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
	
	String msg = name + "," + kor_ + "," + eng_ + "," + mat_ + "," + sci_ + "," + his_;
	
	String newValue = "";
	try {
	//		File f = new File(uploadFile); // include 파일에 선언되어있음
		Scanner sReader = new Scanner(f);
		while (sReader.hasNextLine()) {
			String imsi = sReader.nextLine();
			String[] imsiArray = imsi.split(",");
			if (name.equals(imsiArray[0])) {
				newValue += msg;
			} else {
				newValue += imsi;
			}//if
			newValue += "\n";
		}//while
		sReader.close();
	} catch (Exception e ) {
		e.printStackTrace();
	}//try-catch
	
	int result = 0;
	try {
		FileWriter fw = new FileWriter(uploadFile);
		fw.write(newValue);
		fw.close();
		result++;
	} catch (Exception e) {
		//e.printStackTrace();
		result = 0;
	}//try-catch
	
	if (result > 0) {
		out.println("<script>");
		out.println("alert('정상적으로 수정되었습니다.');");
		out.println("location.href='view.jsp?name=" + name + "';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 중 오류가 발생했습니다.');");
		out.println("location.href='sujung.jsp?name=" + name + "';");
		out.println("</script>");
	}//if
%>