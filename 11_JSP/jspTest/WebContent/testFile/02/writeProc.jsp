<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String data = name + "," + email + "," + subject + "," + content + "\n";

	String attachPath = "D:/Developement/attach";
	String uploadPath = attachPath + "/testFile" + request.getContextPath();
	String uploadFile = uploadPath + "/sample.txt";
	
	java.io.File isDir = new java.io.File(uploadPath);
	if (isDir.exists()) {
		System.out.println("디렉토리 존재..");
	} else {
		try {
			// mkdirs: s가 있으면 경로상에 존재하지 않는 폴더도 같이 만들라는 의미
			isDir.mkdirs();
			System.out.println("디렉토리 생성 성공..");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("디렉토리 생성 실패..");
		}//end try-catch
	}//end if
	
	java.io.File f = new java.io.File(uploadFile);
	f.createNewFile();
	String result = "";
	try {
		java.io.FileWriter fw = new java.io.FileWriter(uploadFile, true);
		fw.write(data);
		fw.close();
		result = "성공";
	} catch (Exception e) {
// 		e.printStackTrace();
		result = "실패";
	}//end try-catch
	
	out.print("<script>");
	out.print("alert('저장 " + result + "..')");
	out.print("location.href='write.jsp';");
	out.print("</script>");
%>