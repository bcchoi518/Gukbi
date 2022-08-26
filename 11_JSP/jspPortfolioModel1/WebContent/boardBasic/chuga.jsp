<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="config.Util"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>
<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>

<%@ include file = "_inc_top.jsp" %>

<%
	String no_ = request.getParameter("no");

	Util util = new Util();
	no_ = util.getNullBlankCheck(no_, "0");
	int no = Integer.parseInt(no_);
	
	String imsiTitle = "";
	String subject = "";
	String content = "";
	if (no > 0) {
		BoardBasicDTO arguBoardBasicDto = new BoardBasicDTO();
		arguBoardBasicDto.setNo(no);
		
		BoardBasicDAO arguBoardBasicDao = new BoardBasicDAO();
		BoardBasicDTO resultBoardBasicDto = arguBoardBasicDao.getSelectOne(arguBoardBasicDto);
		
		imsiTitle = "답변글등록";
		subject = resultBoardBasicDto.getSubject();
		content = resultBoardBasicDto.getContent();
	} else {
		imsiTitle = "게시글등록";
	}//if
%>

<h2><%=imsiTitle %></h2>
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
			<td><input type="text" name="subject" value="<%=subject %>"/></td>
		</tr>
		<tr>
			<td class="entryName">내용 : </td>
			<td><textarea name="content" rows="15" cols="100"><%=content.replace("\n", "<br>") %></textarea></td>
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
			document.frm.action = "mainProc.jsp?menuGubun=boardBasic_chugaProc";
			document.frm.method = "post";
			document.frm.submit();
		}//if
	}//formSubmit
</script>