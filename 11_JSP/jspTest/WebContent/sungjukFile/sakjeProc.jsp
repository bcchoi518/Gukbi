<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_fileInfo.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	
	String newValue = "";
	try {
	//		File f = new File(uploadFile); // include 파일에 선언되어있음
		Scanner sReader = new Scanner(f);
		while (sReader.hasNextLine()) {
			String imsi = sReader.nextLine();
			String[] imsiArray = imsi.split(",");
			if (name.equals(imsiArray[0])) {
	
			} else {
				newValue += imsi + "\n";
			}//if
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
		out.println("alert('정상적으로 삭제되었습니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('삭제 중 오류가 발생했습니다.');");
		out.println("location.href='sakje.jsp?name=" + name + "';");
		out.println("</script>");
	}//if
%>