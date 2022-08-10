<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.nio.file.Paths"%>
<%@ page import="java.nio.file.Files"%>
<%@ page import="java.io.FileWriter"%>
<%@ page import="java.util.List"%>

<%@ page import="config.Constants"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String arg1 = request.getParameter("arg1");
	if (arg1 == null || arg1.trim().equals("")) {
		out.println("<script>");
		out.println("alert('정상적인 접속이 아닙니다.');");
		out.println("location.href='main.jsp?menuGubun=memberFile_list';");
		out.println("</script>");
		return;
	}//end if
	
	String passwd = request.getParameter("passwd");
	
	if (passwd == null || passwd.trim().equals("")) {
		out.println("<script>");
		out.println("alert('비밀번호를 입력하지 않았습니다.');");
		out.println("location.href='main.jsp?menuGubun=memberFile_sakje&arg1=" + arg1 + "';");
		out.println("</script>");
		return;
	}//end if
	
	String attachPath = Constants.ATTACH_PATH;
	String uploadPath = attachPath + request.getContextPath();
	String uploadFile = uploadPath + "/member.txt";
	List<String> list = Files.readAllLines(Paths.get(uploadFile));
	
	int result = 0;
	String data = "";
	for (String line : list) {
		String[] imsiArray = line.split(",");
		if (imsiArray[0].equals(arg1)) {
			if (imsiArray[1].equals(passwd)) {
				continue;
			}//end if
		}//end if
		data += imsiArray[0] + ",";
		data += imsiArray[1] + ",";
		data += imsiArray[2] + ",";
		data += imsiArray[3] + ",";
		data += imsiArray[4] + ",";
		data += imsiArray[5] + ",";
		data += imsiArray[6] + "\n";
	}//end for
	
	try {
		FileWriter fw = new FileWriter(uploadFile);
		fw.write(data);
		fw.close();
		result = 1;
		System.out.println("파일 삭제 성공..");
	} catch (Exception e) {
// 		e.printStackTrace();
		System.out.println("파일 삭제 실패..");
	}//end try-catch
	
	if (result > 0) {
		out.println("<script>");
		out.println("location.href='main.jsp?menuGubun=memberFile_list';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('삭제 처리 중 오류가 발생했습니다.');");
		out.println("location.href='main.jsp?menuGubun=memberFile_sakje&arg1=" + arg1 + "';");
		out.println("</script>");
	}//end if
%>