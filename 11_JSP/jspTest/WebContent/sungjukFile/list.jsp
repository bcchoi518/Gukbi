<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_fileInfo.jsp" %>

<%
	ArrayList<String> list = new ArrayList<>();
	try {
// 		File f = new File(uploadFile); // include 파일에 선언되어있음
		Scanner sReader = new Scanner(f);
		while (sReader.hasNextLine()) {
			String imsi = sReader.nextLine();
			list.add(imsi);
		}//while
		sReader.close();
	} catch (Exception e ) {
		e.printStackTrace();
	}//try-catch
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
</head>
<body>
	<h2>성적관리(목록)</h2>
	<table border="1">
		<tr>
			<th>No.</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>과학</th>
			<th>역사</th>
		</tr>
	<%
		int imsiNo = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] imsiArray = list.get(i).split(",");
	%>
		<tr>
			<td><%=imsiNo++ %></td>
			<td><a href="#" onClick="move('view','<%=imsiArray[0] %>')"><%=imsiArray[0] %></a></td>
			<td><%=imsiArray[1] %></td>
			<td><%=imsiArray[2] %></td>
			<td><%=imsiArray[3] %></td>
			<td><%=imsiArray[4] %></td>
			<td><%=imsiArray[5] %></td>
		</tr>
	<%
		}//for
	%>
		<tr>
			<td height="30px" colspan="7" align="right">
				<a href="#" onClick="move('list')">목록</a>
				|
				<a href="#" onClick="move('chuga')">등록</a>
			</td>
		</tr>
	</table>
	<script>
		function move(value1, value2) {
			if (value2 == undefined) {
				location.href = value1 + '.jsp';
			} else {
				location.href = value1 + '.jsp?name=' + value2;
			}//if
		}//move
	</script>
</body>
</html>