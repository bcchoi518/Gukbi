<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_sessionChk.jsp" %>
<%@ include file = "_inc_top.jsp" %>

<%@ page import="config.Util"%>
<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>

<%
	String no_ = request.getParameter("no");

	Util util = new Util();
	no_ = util.getNullBlankCheck(no_, "0");
	int no = Integer.parseInt(no_);
	
	BoardBasicDTO boardBasicArguDto = new BoardBasicDTO();
	boardBasicArguDto.setNo(no);
	
	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	BoardBasicDTO resultBoardBasicDto = boardBasicDao.getSelectOne(boardBasicArguDto);
	
	if (resultBoardBasicDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 정보입니다.'); location.href='main.jsp?menuGubun=boardBasic_list'; </script>");
		return;
	}//if
%>

<h2>답변글등록</h2>
<form name="frm">
	<input type="hidden" name="no" value="<%=no %>" />
	<table border="0" align="center"> 
		<tr>
			<td class="entryName">작성자 : </td>
			<td><input type="text" name="writer" value="<%=sessionName %>"/></td>
		</tr>
		<tr>
		<tr>
			<td class="entryName">제목 : </td>
			<td><input type="text" name="subject" value="<%=resultBoardBasicDto.getSubject() %>"/></td>
		</tr>
		<tr>
			<td class="entryName">내용 : </td>
			<td><textarea name="content" rows="15" cols="100"><%=resultBoardBasicDto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td class="entryName">이메일 : </td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호 : </td>
			<td><input type="password" name="passwd" /></td>
		</tr>
		<tr align="center" height="50px">
			<td colspan="2">
				<button type="button" onClick="formSubmit()">저장하기</button>
				<button type="button" onClick="location.href='../main/main.jsp?menuGubun=boardBasic_list';">목록으로</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function formSubmit() {
		if (confirm('저장할까요?')) {
			document.frm.action = "mainProc.jsp?menuGubun=boardBasic_replyProc";
			document.frm.method = "post";
			document.frm.submit();
		}//if
	}//formSubmit
</script>