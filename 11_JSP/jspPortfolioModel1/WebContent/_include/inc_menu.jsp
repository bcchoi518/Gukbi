<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<table border="0" align="center" width="90%" id="menuTable">
	<tr>
		<td colspan="11" style="padding-top:10px; text-align:right">
		<% if (sessionNo == 0) { %>
			<a href="main.jsp?menuGubun=noLogin_login">[로그인]</a>
		<% } else { %>
			<%=sessionName %> (<%=sessionGrade %>)님 환영합니다. 
			<a href="main.jsp?menuGubun=noLogin_logout">[로그아웃]</a>
		<% }//if %>
		</td>
	</tr>
	<tr>
		<td align="center" style="padding: 10px" id="dashBoard">
			<a href="<%=path %>">Home</a>
		</td>
		<td align="center" style="padding: 10px" id="member">
			<a href="<%=path %>/main/main.jsp?menuGubun=member_list" >회원관리</a>
		</td>
		<td align="center" style="padding: 10px" id="memo">
			<a href="<%=path %>/main/main.jsp?menuGubun=memo_list">메모장</a>
		</td>
		<td align="center" style="padding: 10px" id="guestBook">
			<a href="<%=path %>/main/main.jsp?menuGubun=guestBook_list">방명록</a>
		</td>
		<td align="center" style="padding: 10px" id="boardBasic">
			<a href="<%=path %>/main/main.jsp?menuGubun=boardBasic_list">게시판(B)</a>
		</td>
		<td align="center" style="padding: 10px" id="menu4">
			메뉴4
		</td>
		<td align="center" style="padding: 10px" id="menu5">
			메뉴5
		</td>
		<td align="center" style="padding: 10px" id="menu6">
			메뉴6
		</td>
		<td align="center" style="padding: 10px" id="menu7">
			메뉴7
		</td>
		<td align="center" style="padding: 10px" id="menu8">
			메뉴8
		</td>
		<td align="center" style="padding: 10px" id="menu9">
			메뉴9
		</td>
	</tr>
</table>
<script>
	function menuSelecter() {
		$('#<%=folderName %>').css({'color':'white','background-color':'#57cc99', 'border-radius':'20px', 'font-weight':'bold'});
	}//applyBgColor
	menuSelecter();
</script>