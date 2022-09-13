<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "_inc_top.jsp" %>

<%
	BoardChkDAO boardChkDao = new BoardChkDAO();
	ArrayList<BoardChkDTO> boardChkList = boardChkDao.getSelectAll();
%>

<h2>게시판관리목록</h2>

<fieldset style="border:0px solid blue; width:80%; margin: 10px 0px 20px 0px">
	<form name="chugaForm">
		<table border="0" align="left">
			<tr>
				<td>
					<input type="text" name="procGubun" id="procGubun" value="chugaProc"/><br>
					<input type="text" name="boardChkNo" id="boardChkNo" /><br>
					tbl: <input type="text" name="tbl" id="tbl"/><br>
					tblName: <input type="text" name="tblName" id="tblName"/>
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" id="btnSave" onClick="save()">확인</button> &nbsp;
					<button type="button" id="btnReset" onClick="resetForm()">초기화</button> &nbsp;
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function save() {
			if (confirm('처리할까요?')) {
				document.chugaForm.action = 'mainProc.jsp?menuGubun=boardChk_chugaProc';
				document.chugaForm.method = 'post'
				document.chugaForm.submit();
			}//if
		}//save
	</script>
</fieldset>

<table border="1" width="80%" style="text-align: center;">
	<tr>
		<th>No</th>
		<th>tbl</th>
		<th>tblName</th>
		<th>regiDate</th>
		<th>&nbsp;</th>
	</tr>
	<%
		if (boardChkList.size() == 0) {
			out.println("<tr>");
			out.println("<td colspan=\"5\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
			out.println("</tr>");
		}//if
	%>
	<%
		for (int i = 0; i < boardChkList.size(); i++) {
			BoardChkDTO resultBoardChkDto = boardChkList.get(i);
	%>
		<tr>
			<td><%=resultBoardChkDto.getBoardChkNo() %></td>
			<td><%=resultBoardChkDto.getTbl() %></td>
			<td><%=resultBoardChkDto.getTblName() %></td>
			<td><%=resultBoardChkDto.getRegiDate() %></td>
			<td>
			<a href="#" onclick="choose('sujungProc','<%=resultBoardChkDto.getBoardChkNo() %>','<%=resultBoardChkDto.getTbl() %>','<%=resultBoardChkDto.getTblName() %>','수정')">수정</a>
			/
			<a href="#" onclick="choose('sakjeProc','<%=resultBoardChkDto.getBoardChkNo() %>','<%=resultBoardChkDto.getTbl() %>','<%=resultBoardChkDto.getTblName() %>','삭제')">삭제</a>
			</td>
		</tr>
	<% }//for %>
</table>
<script>
	function choose(value1, value2, value3, value4, value5) {
		$('#procGubun').val(value1);
		$('#boardChkNo').val(value2);
		$('#tbl').val(value3);
		$('#tblName').val(value4);
		$('#btnSave').text(value5);
	}//choose
	
	function resetForm() {
		$('#procGubun').val('chugaProc');
		$('#boardChkNo').val('');
		$('#tbl').val('');
		$('#tblName').val('');
		$('#btnSave').text('확인');
	}//reset
</script>