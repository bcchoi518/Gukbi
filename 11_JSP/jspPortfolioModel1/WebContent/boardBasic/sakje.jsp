<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>  

<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	
	BoardBasicDTO arguBoardBasicDto = new BoardBasicDTO();
	arguBoardBasicDto.setNo(no);
	
	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	BoardBasicDTO resultBoardBasicDto = boardBasicDao.getSelectOne(arguBoardBasicDto);
	
	if (resultBoardBasicDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 정보입니다.'); location.href='main.jsp?menuGubun=boardBasic_list'; </script>");
		return;
	}//if
%>

<h2>게시글삭제</h2>
<form name="frm">
	<input type="hidden" name="no" value="<%=resultBoardBasicDto.getNo() %>" />
	<table border="0" align="center"> 
		<tr>
			<td class="entryName">작성자 : </td>
			<td><%=resultBoardBasicDto.getWriter() %></td>
		</tr>
		<tr>
			<td class="entryName">제목 : </td>
			<td><%=resultBoardBasicDto.getSubject() %></td>
		</tr>
		<tr>
			<td class="entryName">내용 : </td>
			<td><%=resultBoardBasicDto.getContent().replace("\n", "<br>") %></td>
		</tr>
		<tr>
			<td class="entryName">이메일 : </td>
			<td><%=resultBoardBasicDto.getEmail() %></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호 : </td>
			<td><input type="password" name="passwd" /></td>
		</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="formSubmit()">삭제하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=boardBasic_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function formSubmit() {
		if (confirm('삭제할까요?')) {
			document.frm.action = "mainProc.jsp?menuGubun=boardBasic_sakjeProc";
			document.frm.method = "post";
			document.frm.submit();
		}//if
	}//formSubmit
</script>