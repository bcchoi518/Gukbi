<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>파일 목록</h2>
	<%
		// attach 폴더까지의 경로
		String attachPath = "D:/Developement/attach";// -Unix D:\\Developement\\attach - windows
		// 파일이 저장되는 폴더의 경로
		String uploadPath = attachPath + "/testFile";
		
		String directory = uploadPath;
		String[] files = new java.io.File(directory).list();
		
		for (String file : files) {
			out.println("<a href=\"#\" onClick=\"move('" + file +"')\">" + file + "</a><br>");
		}//end for
	%>
	<form name="form">
		<input type="hidden" name="fileName" />
	</form>
	
	<script>
		function move(value1) {
			if (confirm(value1 + '를 정말 삭제할까요?')) {
				//location.href = 'aaa.jsp?fileName=' + value1;
				document.form.fileName.value = value1;
				
				document.form.action = "aaa.jsp";
				document.form.method = "post";
				document.form.submit();
			}//end if
		}//end move
	</script>
</body>
</html>