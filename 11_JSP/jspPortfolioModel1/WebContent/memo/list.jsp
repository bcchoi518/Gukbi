<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<%@page import="config.Util"%>
<%@ page import="memo.model.dao.MemoDAO"%>
<%@ page import="memo.model.dto.MemoDTO"%>

<%
	request.setCharacterEncoding("UTF-8");

	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	Util util = new Util();
	searchGubun = util.getNullBlankCheck(searchGubun, ""); 
	searchData = util.getNullBlankCheck(searchData, ""); 
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchGubun = "";
		searchData = "";
	}//if
			
	MemoDAO memoDao = new MemoDAO();
	ArrayList<MemoDTO> memoList = memoDao.getSelectAll(searchGubun, searchData);
	
	int totalRecord = memoList.size();
%>

<h2>메모목록</h2>

<form name="frm">
	<fieldset style="border:0px solid blue; width:100%; margin: 10px 0px 20px 0px">
		<input type="hidden" name="no" id="no" />
		<input type="hidden" name="procGubun" id="procGubun" value="memo_chugaProc" />
		<table border="0" width="100%" align="center">
			<tr>
				<td class="entryName" width="80px">작성자 : </td>
				<td><input type="text" name="writer" id="writer"/></td>
			</tr>
			<tr>
				<td class="entryName">메모내용 : </td>
				<td><textarea name="content" id="content" rows="3" cols="100"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnSave" onClick="frmSubmit()">등록하기</button> &nbsp;
					<button type="button" onClick="location.href='main.jsp?menuGubun=memo_list'">목록으로</button>
				</td>
			</tr>
		</table>
	</fieldset>
</form>
<script>
	function frmSubmit() {
		if (confirm('처리할까요?')) {
			const procGubun = document.frm.procGubun.value;
			document.frm.action = 'mainProc.jsp?menuGubun=' + procGubun;
			document.frm.method = 'post'
			document.frm.submit();
		}//if
	}//frmSubmit
</script>

<table border="1" align="center" style="text-align: center;">
	<tr>
		<th>순번</th>
		<th>작성자</th>
		<th>내용</th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
	<%
		if (totalRecord == 0) {
			out.println("<tr>");
			out.println("<td colspan=\"5\" height=\"100px\" style=\"text-align:center;\">저장된 정보가 없습니다.</td>");
			out.println("</tr>");
		}//if
	%>
	<%
		int num = totalRecord;
		for (int i = 0; i < memoList.size(); i++) {
			MemoDTO resultMemoDto = memoList.get(i);
	%>
		<tr>
			<td><%=num-- %></td>
			<td><a href="#" onClick="move('memo_view','<%=resultMemoDto.getNo() %>')"><%=resultMemoDto.getWriter() %></a></td>
			<td style="text-align:left">
				<%=resultMemoDto.getContent() %>
				<input type="hidden" id="no_<%=resultMemoDto.getNo() %>" value="<%=resultMemoDto.getNo() %>" />
				<input type="hidden" id="writer_<%=resultMemoDto.getNo() %>" value="<%=resultMemoDto.getWriter() %>" />
				<input type="hidden" id="content_<%=resultMemoDto.getNo() %>" value="<%=resultMemoDto.getContent() %>" />
			</td>
			<td><%=resultMemoDto.getRegiDate() %></td>
			<td>
				<a href="#" onClick="suntaek('<%=resultMemoDto.getNo() %>','memo_sujungProc')">[수정]</a>
				/
				<a href="#" onClick="suntaek('<%=resultMemoDto.getNo() %>','memo_sakjeProc')">[삭제]</a>
			</td>
		</tr>
	<%		
		}//for
	%>
</table>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="move('memo_list')">목록</a>
|
<a href="#" onClick="move('memo_chuga')">등록</a>
|
</div>

<!-- search start -->
<div style="border: 0px solid red; width:80%;">
	<form name="searchForm" style="padding:0px;">
		<div style="margin:0px; padding:0px; display:flex; justify-content: center;">
			<select name="searchGubun" style="border:0px; padding:0px 10px; height:30px; border-radius:10px 0px 0px 10px;">
				<option value="">-- 선택 --</option>
				<option value="writer" <% if (searchGubun.equals("writer")) { out.println("selected"); } %>>작성자</option>
				<option value="content" <% if (searchGubun.equals("content")) { out.println("selected"); } %>>내용</option>
				<option value="writer_content" <% if (searchGubun.equals("writer_content")) { out.println("selected"); } %>>작성자+내용</option>
			</select>
			<input type="text" name="searchData" value="<%=searchData %>" style="border:0px; margin:0px; padding:0px; height:30px; width:200px;"/>
			<button type="button" onclick="search()" style="border:0px; border-radius:0px 10px 10px 0px; margin:0px; padding:0px 10px; height:30px; font-size:1rem;">검색</button>
		</div>
	</form>
</div>
<!-- search end -->

<script>
	function suntaek(value1, value2) {
		let jsNo = $('#no_' + value1).val();
		let jsWriter = $('#writer_' + value1).val();
		let jsContent = $('#content_' + value1).val();
		
		$('#no').val(jsNo);
		$('#writer').val(jsWriter);
		$('#content').val(jsContent);
		$('#procGubun').val(value2);
		
		if (value2 == 'memo_sujungProc') {
			$('#btnSave').text('수정하기');
		} else if (value2 == 'memo_sakjeProc') {
			$('#btnSave').text('삭제하기');
		}//if
	}//suntaek
	
	function move(value1, value2) {
		if (value2 != undefined) {
			location.href = 'main.jsp?menuGubun=' + value1 + '&no=' + value2;
		} else {
			location.href = 'main.jsp?menuGubun=' + value1;
		}//if
	}//move
	
	function search() {
		document.searchForm.action = 'mainProc.jsp?menuGubun=memo_listSearch';
		document.searchForm.method = 'post';
		document.searchForm.submit();
	}//search
</script>