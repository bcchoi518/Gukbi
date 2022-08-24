<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="guestBook.model.dao.GuestBookDAO"%>
<%@ page import="guestBook.model.dto.GuestBookDTO"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	
	GuestBookDTO guestBookArguDto = new GuestBookDTO();
	guestBookArguDto.setNo(no);
	
	GuestBookDAO guestBookDao = new GuestBookDAO();
	GuestBookDTO resultGuestBookDto = guestBookDao.getSelectOne(guestBookArguDto);
	
	if (resultGuestBookDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 방명록입니다.'); location.href='main.jsp?menuGubun=guestBook_list'; </script>");
		return;
	}//if
%>

<h2>방명록수정</h2>
<form name="frm">
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
			<td><input type="text" name="email" value="<%=resultGuestBookDto.getEmail() %>"/></td>
		</tr>
		<tr>
			<td>방명록내용 : </td>
			<td><textarea name="content" rows="15" cols="100"><%=resultGuestBookDto.getContent() %></textarea></td>
		</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="formSubmit()">수정하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=guestBook_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function formSubmit() {
		if (confirm('수정할까요?')) {
			document.frm.action = "mainProc.jsp?menuGubun=guestBook_sujungProc";
			document.frm.method = "post";
			document.frm.submit();
		}//if
	}//formSubmit
</script>