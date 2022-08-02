<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>test04.jsp</title>
</head>
<body>
	<h2>test04.jsp</h2>
	
		<%
			for (int i = 1; i < 10; i++) {
				out.println(i);
			}
		%>
	
	<hr>
	
	<table border = "1" width="100px">
		<%
			for (int i = 1; i < 10; i++) {
		%>
			<tr>
			 <td><%=i %></td>
			</tr>
		<%	
			}
		%>
	</table>
	
	<hr>
	
	<table border = "1">
		<tr>
		<%
			for (int i = 1; i < 10; i++) {
		%>
			 <td width="50px"><%=i %></td>
		<%	
			}
		%>
		</tr>
	</table>
	
	<hr>
	
	<table border = "1" width="100px">
		<%
			int sum = 0;
			for (int i = 1; i < 10; i++) {
				sum += i;
		%>
			<tr>
				<td><%=i %></td>
				<td><%=sum %></td>
			</tr>
		<%	
			}
		%>
	</table>
	
	<hr>
	
	<table border="1" width="500px">
		<tr bgcolor="#FFFF3">
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>1</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>2</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>3</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>4</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>5</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>6</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>7</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>8</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>9</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
		<tr>
			<td>10</td>
			<td>연습입니다.</td>
			<td>홍길동</td>
			<td>2022-08-02</td>
			<td>21</td>
		</tr>
	</table>
	
	<hr>
	
	<table border="1" width="500px">
		<tr bgcolor="#FFFF3">
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
			for (int i = 1; i < 11; i++) {
/* 				String imsiBg = "";
				if (i % 2 == 0) {
					imsiBg = "bgcolor=\"gray\"";
				}//end if */
				if (i % 2 == 0) {
		%>
				<%-- <tr <%=imsiBg %>> --%>
				<tr bgcolor="gray">
			<% } else { %>
				<tr bgcolor="magenta">
			<% } //end if %>
				<td><%=i %></td>
				<td>연습입니다.</td>
				<td>홍길동</td>
				<td>2022-08-02</td>
				<td>21</td>
			</tr>
		<% 
			} //end for
		%>
	</table>
	
	<hr>
	
	<table border="1" width="500px">
		<tr bgcolor="#FFFF3">
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
			int k = 0;
			while (k < 5) {
				k++;
		%>
			<tr>
				<td><%=k %></td>
				<td>연습입니다.</td>
				<td>홍길동</td>
				<td>2022-08-02</td>
				<td>21</td>
			</tr>
		<%
			} //end while
		%>
	</table>
	
</body>
</html>