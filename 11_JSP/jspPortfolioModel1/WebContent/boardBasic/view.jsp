<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="boardBasic.model.dao.BoardBasicDAO"%>
<%@ page import="boardBasic.model.dto.BoardBasicDTO"%>

<%
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	
	BoardBasicDTO arguBoardBasicDto = new BoardBasicDTO();
	arguBoardBasicDto.setNo(no);
	
	BoardBasicDAO boardBasicDao = new BoardBasicDAO();
	boardBasicDao.setUpdateHit(arguBoardBasicDto);
	BoardBasicDTO resultBoardBasicDto = boardBasicDao.getSelectOne(arguBoardBasicDto);
	
	//예외처리 중요하니까 모든 가능성을 생각하자
	if (resultBoardBasicDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 정보입니다.'); location.href='main.jsp?menuGubun=boardBasic_list'; </script>");
		return;
	}//if
%>

<h2>게시글상세보기</h2>
<table border="0" align="center">
	<tr>
		<td class="entryName">no : </td>
		<td><%=resultBoardBasicDto.getNo() %></td>
	</tr>
	<tr>
		<td class="entryName">num : </td>
		<td><%=resultBoardBasicDto.getNum() %></td>
	</tr>
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
		<td class="entryName">refNo : </td>
		<td><%=resultBoardBasicDto.getRefNo() %></td>
	</tr>
	<tr>
		<td class="entryName">stepNo : </td>
		<td><%=resultBoardBasicDto.getStepNo() %></td>
	</tr>
	<tr>
		<td class="entryName">levelNo : </td>
		<td><%=resultBoardBasicDto.getLevelNo() %></td>
	</tr>
	<tr>
		<td class="entryName">조회수 : </td>
		<td><%=resultBoardBasicDto.getHit() %></td>
	</tr>
	<tr>
		<td class="entryName">등록일 : </td>
		<td><%=resultBoardBasicDto.getRegiDate() %></td>
	</tr>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('boardBasic_list')">목록</a>
|
<a href="#" onClick="move('boardBasic_chuga')">등록</a>
|
<a href="#" onClick="move('boardBasic_sujung','<%=no %>')">수정</a>
|
<a href="#" onClick="move('boardBasic_sakje','<%=no %>')">삭제</a>
|
<a href="#" onClick="move('boardBasic_reply','<%=no %>')">답글</a>
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