<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="guestBook.model.dao.GuestBookDAO"%>
<%@ page import="guestBook.model.dto.GuestBookDTO"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	
	GuestBookDTO arguGuestBookDto = new GuestBookDTO();
	arguGuestBookDto.setNo(no);
	
	GuestBookDAO guestBookDao = new GuestBookDAO();
	GuestBookDTO resultGuestBookDto = guestBookDao.getSelectOne(arguGuestBookDto);
	
	if (resultGuestBookDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 회원입니다.'); location.href='main.jsp?menuGubun=guestBook_list'; </script>");
		return;
	}//if
%>

<h2>회원삭제</h2>
<form name="sakjeForm">
	<input type="hidden" name="no" value="<%=resultGuestBookDto.getNo() %>" />
	<table border="0" align="center"> 
		<tr>
			<td class="entryName">이름 : </td>
			<td><%=resultGuestBookDto.getName() %></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호 : </td>
			<td><input type="password" name="passwd" /></td>
		</tr>
		<tr>
			<td class="entryName">이메일 : </td>
			<td><%=resultGuestBookDto.getEmail() %></td>
		</tr>
			<tr>
		<td class="entryName">메모내용 : </td>
		<td><%=resultGuestBookDto.getContent().replace("\n", "<br>") %></td>
	</tr>
	<tr>
		<td class="entryName">등록일 : </td>
		<td><%=resultGuestBookDto.getRegiDate() %></td>
	</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="sakje()">삭제하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=guestBook_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function sakje() {
		if (confirm('삭제할까요?')) {
			document.sakjeForm.action = "mainProc.jsp?menuGubun=guestBook_sakjeProc";
			document.sakjeForm.method = "post";
			document.sakjeForm.submit();
		}//if
	}//sakje
</script>