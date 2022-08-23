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
	
	//예외처리 중요하니까 모든 가능성을 생각하자
	if (resultGuestBookDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 방명록입니다.'); location.href='main.jsp?menuGubun=guestBook_list'; </script>");
		return;
	}//if
%>

<h2>방명록상세보기</h2>
<table border="0" align="center">
	<tr>
		<td class="entryName">이름 : </td>
		<td><%=resultGuestBookDto.getName() %></td>
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
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('guestBook_list')">목록</a>
|
<a href="#" onClick="move('guestBook_chuga')">등록</a>
|
<a href="#" onClick="move('guestBook_sujung','<%=no %>')">수정</a>
|
<a href="#" onClick="move('guestBook_sakje','<%=no %>')">삭제</a>
|
</div>
<form name="dataTransferForm">
	<input type="hidden" name="menuGubun" />
	<input type="hidden" name="no" />
</form>
<script>
	function move(value1, value2) {
		if (value2 != undefined) {
			document.dataTransferForm.no.value = value2;
		}//if
		document.dataTransferForm.menuGubun.value = value1;
		
		document.dataTransferForm.action = 'main.jsp';
		document.dataTransferForm.method = 'post';
		document.dataTransferForm.submit();
	}//move
</script>