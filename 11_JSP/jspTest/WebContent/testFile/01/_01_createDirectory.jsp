<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>디렉토리 만들기</h2>
	<%
		// attach 폴더까지의 경로
		String attachPath = "D:/Developement/attach";//-Unix D:\\Developement\\attach - windows
		// 파일이 저장되는 폴더의 경로
		String uploadPath = attachPath + "/testFile/aaa";
		
		java.io.File isDir = new java.io.File(uploadPath);
		
		if (isDir.exists()) {
			System.out.println("디렉토리 존재함..");
		} else {
			System.out.println("디렉토리 존재안함..");
			
			try {
				// mkdirs: s가 있으면 경로상에 존재하지 않는 폴더도 같이 만들라는 의미
				isDir.mkdirs();
				System.out.println("디렉토리 생성 성공..");
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("디렉토리 생성 실패..");
			}//end try-catch
		}//end if
	%>

</body>
</html>