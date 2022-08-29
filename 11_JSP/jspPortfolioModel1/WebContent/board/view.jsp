<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>

<%	
	//예외처리 중요하니까 모든 가능성을 생각하자
	if (resultBoardDto.getNo() <= 0) {
		out.println("<script> alert('존재하지 않는 정보입니다.'); location.href='main.jsp?menuGubun=board_list'; </script>");
		return;
	}//if
%>

<h2>게시글 상세보기</h2>
<table border="0" align="center">
	<tr>
		<td class="entryName">no</td>
		<td><%=resultBoardDto.getNo() %></td>
	</tr>
	<tr>
		<td class="entryName">num</td>
		<td><%=resultBoardDto.getNum() %></td>
	</tr>
	<tr>
		<td class="entryName">tbl</td>
		<td><%=resultBoardDto.getTbl() %></td>
	</tr>
	<tr>
		<td class="entryName">작성자</td>
		<td><%=resultBoardDto.getWriter() %></td>
	</tr>
	<tr>
		<td class="entryName">제목</td>
		<td><%=resultBoardDto.getSubject() %></td>
	</tr>
	<tr>
		<td class="entryName">내용</td>
		<td><%=resultBoardDto.getContent().replace("\n", "<br>") %></td>
	</tr>
	<tr>
		<td class="entryName">이메일</td>
		<td><%=resultBoardDto.getEmail() %></td>
	</tr>
	<tr>
		<td class="entryName">refNo</td>
		<td><%=resultBoardDto.getRefNo() %></td>
	</tr>
	<tr>
		<td class="entryName">stepNo</td>
		<td><%=resultBoardDto.getStepNo() %></td>
	</tr>
	<tr>
		<td class="entryName">levelNo</td>
		<td><%=resultBoardDto.getLevelNo() %></td>
	</tr>
	<tr>
		<td class="entryName">parentNo</td>
		<td><%=resultBoardDto.getParentNo() %></td>
	</tr>
	<tr>
		<td class="entryName">조회수</td>
		<td><%=resultBoardDto.getHit() %></td>
	</tr>
	<tr>
		<td class="entryName">IP</td>
		<td><%=resultBoardDto.getIp() %></td>
	</tr>
	<tr>
		<td class="entryName">memberNo</td>
		<td><%=resultBoardDto.getMemberNo() %></td>
	</tr>
	<tr>
		<td class="entryName">noticeNo</td>
		<td><%=resultBoardDto.getNoticeNo() %></td>
	</tr>
	<tr>
		<td class="entryName">secretGubun</td>
		<td><%=resultBoardDto.getSecretGubun() %></td>
	</tr>
	<tr>
		<td class="entryName">등록일</td>
		<td><%=resultBoardDto.getRegiDate() %></td>
	</tr>
	<tr>
		<td class="entryName">첨부</td>
		<td><%=resultBoardDto.getAttachInfo() %></td>
	</tr>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('board_list')">목록</a>
|
<a href="#" onClick="move('board_chuga')">등록</a>
|
<a href="#" onClick="move('board_chuga','<%=resultBoardDto.getNo() %>')">답변</a>
|
<a href="#" onClick="move('board_sujung','<%=resultBoardDto.getNo() %>')">수정</a>
|
<a href="#" onClick="move('board_sakje','<%=resultBoardDto.getNo() %>')">삭제</a>
|
</div>

<script>
	function move(value1, value2) {
		let linkAddr = 'main.jsp?menuGubun='+ value1;
		if (value2 != undefined) {
			linkAddr += '&no=' + value2;
		}//if
		location.href = linkAddr;
	}//move
</script>