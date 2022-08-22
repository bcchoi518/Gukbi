<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<table border="0" align="center" width="90%" id="menuTable">
	<tr>
		<td colspan="11" style="padding-top:10px; text-align:right">
			OOO님 환영합니다.
		</td>
	</tr>
	<tr>
		<td align="center" style="padding: 10px" id="home">
			<a href="<%=path %>">Home</a>
		</td>
		<td align="center" style="padding: 10px" id="member">
			<a href="<%=path %>/main/main.jsp?menuGubun=member_list" >회원관리</a>
		</td>
		<td align="center" style="padding: 10px" id="memo">
			<a href="<%=path %>/main/main.jsp?menuGubun=memo_list">메모장</a>
		</td>
		<td align="center" style="padding: 10px" id="menu2">
			<a href="<%=path %>/main/main.jsp?menuGubun=guestBook_list">방명록</a>
		</td>
		<td align="center" style="padding: 10px" id="menu3">
			메뉴3
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