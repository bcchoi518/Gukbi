<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList"
%>
<%
	ArrayList<String> list = new ArrayList<>();
	String imsi = "";

	String name1 = "홍길동";
	int kor1 = 90;
	int eng1 = 80;
	int mat1 = 70;
	imsi = name1 +"|"+ kor1 +"|"+ eng1 +"|"+ mat1;
	list.add(imsi);
	
	String name2 = "이성순";
	int kor2 = 99;
	int eng2 = 88;
	int mat2 = 77;
	imsi = name2 +"|"+ kor2 +"|"+ eng2 +"|"+ mat2;
	list.add(imsi);
	
	String name3 = "장천용";
	int kor3 = 100;
	int eng3 = 100;
	int mat3 = 100;
	imsi = name3 +"|"+ kor3 +"|"+ eng3 +"|"+ mat3;
	list.add(imsi);
	
	out.print(list);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>test08.jsp</title>
</head>
<body>

	<h2>test08.jsp</h2>
	
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
		for (int i = 0; i < list.size(); i++) {
			String[] studentInfo = list.get(i).split("[|]");
			String name = studentInfo[0];
			int kor = Integer.parseInt(studentInfo[1]);
			int eng = Integer.parseInt(studentInfo[2]);
			int mat = Integer.parseInt(studentInfo[3]);
			int tot = kor + eng + mat;
			double avg = Math.round((tot / 3.0) * 100) / 100.0;
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