<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="java.util.Scanner" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>파일 읽기</h2>
	
	<%
		// attach 폴더까지의 경로
		String attachPath = "D:/Developement/attach";// -Unix D:\\Developement\\attach - windows
		// 파일이 저장되는 폴더의 경로
		String uploadPath = attachPath + "/testFile/aaa";
		// 저장되는 파일명
		String uploadFile = uploadPath + "/test01.txt";
		
		try {
			java.io.File f = new java.io.File(uploadFile);
			Scanner sReader = new Scanner(f);
			while (sReader.hasNextLine()) {
				String data = sReader.nextLine();
				String[] imsiArray = data.split(",");
				int tot = 0;
				double avg = 0.0;
				String grade = "가";
				for (int i = 1; i < imsiArray.length; i++) {
					tot += Integer.parseInt(imsiArray[i]);
				}//end for
				avg = tot / (double) (imsiArray.length - 1);
				if (avg >= 90) {
					grade = "수";
				} else if (avg >= 80) {
					grade = "우";
				}  else if (avg >= 70) {
					grade = "미";
				}  else if (avg >= 60) {
					grade = "양";
				}//end if
				data += "," + tot + "," + avg + "," + grade;
				data = data.replace(",", " &nbsp;&nbsp; ");
				out.print("[ " + data + " ]<br>");
			}//end while
			sReader.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}//end try-catch
	%>

</body>
</html>