<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.io.FileWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>파일 쓰기</h2>
	
	<%
		// attach 폴더까지의 경로
		String attachPath = "D:/Developement/attach";// -Unix D:\\Developement\\attach - windows
		// 파일이 저장되는 폴더의 경로
		String uploadPath = attachPath + "/testFile/aaa";
		// 저장되는 파일명
		String uploadFile = uploadPath + "/test01.txt";
		
		String content = "";
		content += "홍길동,90,80,70,60,50\n";
		content += "이성순,99,88,77,66,55\n";
		try {
// 			FileWriter fw = new FileWriter(uploadFile); // write: 기존 내용에 덮어씀
			FileWriter fw = new FileWriter(uploadFile, true); // true를 적어주면 기존 내용 끝에 append(추가)함
			fw.write(content);
			fw.close();
			System.out.println("저장 성공..");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("저장 실패..");
		}//end try-catch
	%>

</body>
</html>