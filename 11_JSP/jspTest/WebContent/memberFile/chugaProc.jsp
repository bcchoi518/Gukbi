<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter"%>
<%@ page import="java.time.LocalDateTime"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String passwdChk = request.getParameter("passwdChk");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String regiDate = "";
	LocalDateTime time = LocalDateTime.now();
	regiDate += time.getYear() + "-";
	regiDate += time.getMonthValue() + "-";
	regiDate += time.getDayOfMonth();
	
	if (id == null || id.trim().equals("")) {
		out.println("<script>");
		out.println("alert('아이디를 입력하지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
		return;
	}//end if
	if (passwd == null || passwd.trim().equals("")) {
		out.println("<script>");
		out.println("alert('비밀번호를 입력하지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
		return;
	}//end if
	if (passwdChk == null || passwdChk.trim().equals("")) {
		out.println("<script>");
		out.println("alert('비밀번호확인을 입력하지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
		return;
	}//end if
	if (!passwd.equals(passwdChk)) {
		out.print("비밀번호 동일하지 않음..");
		return;
	}//end if
	if (name == null || name.trim().equals("")) {
		out.println("<script>");
		out.println("alert('이름을 입력하지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
		return;
	}//end if
	if (phone == null || phone.trim().equals("")) {
		out.println("<script>");
		out.println("alert('전화번호를 입력하지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
		return;
	}//end if
	if (email == null || email.trim().equals("")) {
		out.println("<script>");
		out.println("alert('이메일을 입력하지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
		return;
	}//end if
	if (address == null || address.trim().equals("")) {
		out.println("<script>");
		out.println("alert('주소를 입력하지 않았습니다.');");
		out.println("location.href='../main/main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
		return;
	}//end if
	
	String data = "";
	data += id + ",";
	data += passwd + ",";
	data += name + ",";
	data += phone + ",";
	data += email + ",";
	data += address + ",";
	data += regiDate + "\n";
	
	String attachPath = "D:/Developement/attach";
	String uploadPath = attachPath + request.getContextPath();
	String uploadFile = uploadPath + "/member.txt";
	
	File isDir = new File(uploadPath);
	if (isDir.exists()) {
		System.out.print("경로 존재..");
	} else {
		isDir.mkdirs();
		System.out.print("경로 생성..");
	}//end if
	
	File file = new File(uploadFile);
	file.createNewFile();
	
	int result = 0;
	try {
		FileWriter fw = new FileWriter(uploadFile, true);
		fw.write(data);
		fw.close();
		result = 1;
		System.out.println("파일 저장 성공..");
	} catch (Exception e) {
// 		e.printStackTrace();
		System.out.println("파일 저장 실패..");
	}//end try-catch
	
	if (result > 0) {
		out.println("<script>location.href='main.jsp?menuGubun=memberFile_list';</script>");
	} else {
		out.println("<script>");
		out.println("alert('추가 처리 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=memberFile_chuga';");
		out.println("</script>");
	}//end if
%>