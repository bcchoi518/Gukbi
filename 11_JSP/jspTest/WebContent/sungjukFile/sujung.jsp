<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_fileInfo.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String info = "";
	
	try {
	//		File f = new File(uploadFile); // include 파일에 선언되어있음
		Scanner sReader = new Scanner(f);
		while (sReader.hasNextLine()) {
			String imsi = sReader.nextLine();
			String[] imsiArray = imsi.split(",");
			if (name.equals(imsiArray[0])) {
				info = imsi;
				break;
			}//if
		}//while
		sReader.close();
	} catch (Exception e ) {
		e.printStackTrace();
	}//try-catch
	
	String[] tempArray = info.split(",");
// 	String name = tempArray[0]; // 위에 존재
	String kor_ = tempArray[1];
	String eng_ = tempArray[2];
	String mat_ = tempArray[3];
	String sci_ = tempArray[4];
	String his_ = tempArray[5];
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
</head>
<body>
	<h2>성적관리(수정)</h2>
	<form name="sujungForm">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><%=name %><input type="hidden" name="name" value="<%=name %>"/></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="text" name="kor" value="<%=kor_ %>"/></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="text" name="eng" value="<%=eng_ %>"/></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="text" name="mat" value="<%=mat_ %>"/></td>
			</tr>
			<tr>
				<th>과학</th>
				<td><input type="text" name="sci" value="<%=sci_ %>"/></td>
			</tr>
			<tr>
				<th>역사</th>
				<td><input type="text" name="his" value="<%=his_ %>"/></td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onClick="sujung()">확인</button></td>
			</tr>
		</table>
	</form>
	<script>
		function sujung() {
			if (confirm('저장하시겠습니까?')) {
				document.sujungForm.action = 'sujungProc.jsp';
				document.sujungForm.method = 'post';
				document.sujungForm.submit();
			}//end if
		}//end sujung
	</script>
</body>
</html>