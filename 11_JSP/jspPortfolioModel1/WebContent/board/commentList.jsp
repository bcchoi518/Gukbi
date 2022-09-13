<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="config.Util"%>
<%@ page import="board.model.dto.BoardCommentDTO"%>
<%@ page import="board.model.dao.BoardDAO"%>

<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<%
	String no_ = request.getParameter("no");
	Util util = new Util();
	no_ = util.getNullBlankCheck(no_, "0");
	int no = Integer.parseInt(no_);
	
	BoardCommentDTO arguBoardCommentDto = new BoardCommentDTO();
	arguBoardCommentDto.setBoardNo(no);
	
	BoardDAO boardDao = new BoardDAO();
	ArrayList<BoardCommentDTO> commentList = boardDao.getCommentSelectAll(arguBoardCommentDto);
%>
<table border="0" style="width:100%" align="center">
	<tr>
		<td style="padding:20px 0px">
			<span id="procGubun" style="display:">chugaProc</span><br>
			<span id="no" style="display:;"><%=no %></span><br>
			<span id="commentNo" style="display:"></span><br>
			이름: <input type="text" name="commentWriter" id="commentWriter" size="10" value="" />
			비밀번호: <input type="password" name="commentPasswd" id="commentPasswd" size="10" value="" /><br>
			댓글: <input type="text" name="commentContent" id="commentContent" size="100" value="" />
				 <button type="button" id="btnCommentSave">등록하기</button>
				 <button type="button" id="btnCommentReset">초기화</button>
		</td>
	</tr>
</table>

<table border="0" style="width:100%" align="center">
<% for (BoardCommentDTO resultBoardCommentDto : commentList) { %>
	<tr>
		<td style="padding:0px 0px 10px 0px">
			<table border="0" style="width:100%" align="center">
				<tr>
					<td><%=resultBoardCommentDto.getWriter() %> &nbsp; <%=resultBoardCommentDto.getRegiDate() %></td>
					<td align="right">
						<a href="#comment" onclick="suntaek('sujungProc','<%=resultBoardCommentDto.getCommentNo() %>','<%=resultBoardCommentDto.getWriter() %>', '<%=resultBoardCommentDto.getContent() %>', '수정하기')">[수정]</a>
						/
						<a href="#comment" onclick="suntaek('sakjeProc','<%=resultBoardCommentDto.getCommentNo() %>','<%=resultBoardCommentDto.getWriter() %>', '<%=resultBoardCommentDto.getContent() %>', '삭제하기')">[삭제]</a>
					</td>
				</tr>
				<tr>
					<td>
						<%=resultBoardCommentDto.getContent() %>
					</td>
				</tr>
			</table>
			<hr>
		</td>
	</tr>
	<% }//for %>
</table>

<input type="hidden" id="result" />

<script>
	$(document).ready(function () {
		$('#btnCommentSave').click(function () {
			commentSave();
		});
		$('#btnCommentReset').click(function () {
			commentReset();
		});
	});
	
	function commentSave() {
		const param = {
			'procGubun' : $('#procGubun').text(),
			'no' : $('#no').text(),
			'commentNo' : $('#commentNo').text(),
			'writer' : $('#commentWriter').val(),
			'passwd' : $('#commentPasswd').val(),
			'content' : $('#commentContent').val()
		}
		const url = '../board/commentChugaProc.jsp';
		$.ajax({
			type: 'post',
			data: param,
			url: url,
			success: function(data) {
				$('#result').val(data);
				if ($('#result').val() == 1) {
					alert('성공');
				} else {
					alert('실패');
				}//if
				commentList();
			}
		});
	}//commentSave
	
	function suntaek(value1, value2, value3, value4, value5) {
		$('#procGubun').text(value1);
		$('#commentNo').text(value2);
		$('#commentWriter').val(value3);
		$('#commentContent').val(value4);
		$('#btnCommentSave').text(value5);
	}//suntaek
	
	function commentReset() {
		$('#procGubun').text('chuga');
		$('#commentNo').text('');
		$('#commentPasswd').val('');
		$('#commentWriter').val('');
		$('#commentContent').val('');
		$('#btnCommentSave').text('등록하기');
	}//commentReset
</script>