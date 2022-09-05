<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="config.Util"%>
<%@ page import="memo.model.dao.MemoDAO"%>
<%@ page import="memo.model.dto.MemoDTO"%>

<%@ include file = "_inc_top.jsp" %>
<%@ include file = "_inc_script.jsp" %>

<%
//search start
	String searchValue = "O";
	String searchGubun = request.getParameter("searchGubun");
	String searchData = request.getParameter("searchData");
	
	Util util = new Util();
	searchGubun = util.getNullBlankCheck(searchGubun, "");
	searchData = util.getNullBlankCheck(searchData, "");
	searchData = util.getCheckString(searchData);
	
	if (searchGubun.equals("") || searchData.equals("")) {
		searchValue = "X";
		searchGubun = "";
		searchData = "";
	}//if
//search end
	MemoDAO memoDao = new MemoDAO();
//pager start
	String pageNumber_ = request.getParameter("pageNumber"); 
	pageNumber_ = util.getNullBlankCheck(pageNumber_, "1");
	
	int pageNumber = Integer.parseInt(pageNumber_);
	
	int totalRecord = memoDao.getTotalRecord(searchGubun, searchData);
	int pageSize = 5; // 한페이지에 나타낼 레코드 갯수
	int blockSize = 10;

	int block = (pageNumber - 1) / blockSize;
	int jj = totalRecord - pageSize * (pageNumber - 1); //단순히 화면에 보여주는 일련번호
	double totalPageDou = Math.ceil(totalRecord / (double)pageSize);
	int totalPage = (int)totalPageDou;
	
	int startRecord = pageSize * (pageNumber - 1) + 1;
	int lastRecord = pageSize * pageNumber;
//pager end	
	ArrayList<MemoDTO> memoList = memoDao.getSelectAll(searchGubun, searchData, startRecord, lastRecord);
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
<!-- pager start -->
<div style="border: 0px solid red; padding:10px 0px; width:80%;" align="center">
<%
	int totalBlock = totalPage / blockSize;
	double value1 = (double)totalBlock;
	double value2 = totalPage / blockSize;
	if (value1 - value2 == 0) {
		totalBlock = totalBlock - 1;
	}//if
%>
	<button class="pageBtn" onclick="goPage('<%=menuGubun %>','1','<%=searchGubun %>','<%=searchData %>')">&lt;&lt;</button>
<%
	if (block > 0) {
		int imsiPage = (block - 1) * blockSize + 1;
%>
		<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=imsiPage %>','<%=searchGubun %>','<%=searchData %>')">&lt;</button>
<% 
	} else {
%>
	<button class="pageBtn" >&lt;</button>
<%
	}//if
%>
<%
	for (int goPage=1; goPage <= blockSize; goPage++) {
		int imsiValue = block * blockSize + goPage;
		if (totalPage - imsiValue >= 0) {
			if (imsiValue == pageNumber) {
%>
				<button class="pageBtn <% if (pageNumber == imsiValue) { out.println("selected"); } %>" ><%=imsiValue %></button>
<%
			} else {
%>
				<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=imsiValue %>','<%=searchGubun %>','<%=searchData %>')"><%=imsiValue %></button>
<%
			}//if
		}//if
	}//for
%>
<%
	if (block - totalBlock <= 0) {
		int yyy = (block + 1) * blockSize + 1;
		//int zzz = block + 1;
%>
		<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=yyy %>','<%=searchGubun %>','<%=searchData %>')" >&gt;</button>
<%
	} else {
%>
		<button class="pageBtn" >&gt;</button>
<%		
	}//if
%>
<button class="pageBtn" onclick="goPage('<%=menuGubun %>','<%=totalPage %>','<%=searchGubun %>','<%=searchData %>')" >&gt;&gt;</button>
</div>
<!-- pager end -->
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
</script>