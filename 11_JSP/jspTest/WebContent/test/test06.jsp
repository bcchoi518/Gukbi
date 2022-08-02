<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String imsiInfo01 = "홍길동/90/80/70";
	String imsiInfo02 = "이성순/99/88/77";
	String imsiInfo03 = "장천용/100/100/100";
	
	String memo = imsiInfo01 + "|" + imsiInfo02 + "|" + imsiInfo03;
	out.print(memo);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>test06.jsp</title>
</head>
<body>
	<h2>test06.jsp</h2>
	
	<table border="1">
		<tr>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>
			<td>평균</td>
		</tr>
	<%
		String[] students = memo.split("[|]");
		for (int i = 0; i < students.length; i++) {
			String[] studentInfo = students[i].split("/");
			String name = studentInfo[0];
			int kor = Integer.parseInt(studentInfo[1]);
			int eng = Integer.parseInt(studentInfo[2]);
			int mat = Integer.parseInt(studentInfo[3]);
			int tot = kor + eng + mat;
			double avg = tot / 3.0;
	%>
		<tr>
			<td><%=name %></td>
			<td><%=kor %></td>
			<td><%=eng %></td>
			<td><%=mat %></td>
			<td><%=tot %></td>
			<td><%=avg %></td>
		</tr>
	<%
		}//end for
	%>
	</table>
</body>
</html>