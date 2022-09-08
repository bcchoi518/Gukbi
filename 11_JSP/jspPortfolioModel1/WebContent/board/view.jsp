<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>
<%@ include file = "_inc_script.jsp" %>

<%
	String viewPasswd = request.getParameter("viewPasswd");
	if (viewPasswd == null || viewPasswd.trim().equals("")) {
		viewPasswd = "";
	}//if
	
	String imsiPage = "viewPage";
	if (resultBoardDto.getSecretGubun().equals("T")) {
		if (!resultBoardDto.getPasswd().equals(viewPasswd)) {
			imsiPage = "viewPasswdPage";
			if (!viewPasswd.equals("")) {
				out.println("<script>");
				out.println("alert('입력한 값이 정확하지않습니다.');");
				out.println("</script>");
			}//if
		}//if
	}//if
%>

<% if (imsiPage.equals("viewPasswdPage")) {//비밀글.. %>
	<form name="passwdForm">
		<input type="hidden" name="no" value="<%=resultBoardDto.getNo() %>" />
		<input type="hidden" name="searchGubun" value="<%=searchGubun %>" />
		<input type="hidden" name="searchData" value="<%=searchData %>" />
		<table border="0" align="center">
			<tr>
				<td colspan="2" align="center">
					<h2>글상세보기 (비밀글입니다.)</h2>
				</td>
			</tr>
			<tr>
				<td align="center">
					비밀번호 :&nbsp;
					<input type="password" name="viewPasswd" />
					<button type="button" onclick="passwdSubmit()">확인</button>
				</td>
			</tr>
		</table>
	</form>
	<script>
		function passwdSubmit() {
			document.passwdForm.action = 'main.jsp?menuGubun=board_view';
			document.passwdForm.method = 'post';
			document.passwdForm.submit();
		}//passwdSubmit
	</script>
<% 
	} else { 
		boardDao.setUpdateHit(arguBoardDto);
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
	<div style="border: 0px solid red; padding-top:10px; width:80%;" align="center">
		<table border="0" width="100%">
			<tr>
				<td width="100px"  class="entryName">이전글</td>
				<td>
					<% if (resultBoardDto.getPreNo() > 0) { %>
						<a href="#" onClick="goPage('board_view','<%=pageNumber %>','<%=searchGubun %>','<%=searchData %>','<%=resultBoardDto.getPreNo() %>')"><%=resultBoardDto.getPreSubject() %></a>
					<% } else { %>
						이전글이 없습니다.
					<% }//if %>
				</td>
			</tr>
			<tr>
				<td class="entryName">다음글</td>
				<td>
					<% if (resultBoardDto.getNxtNo() > 0) { %>
						<a href="#" onClick="goPage('board_view','<%=pageNumber %>','<%=searchGubun %>','<%=searchData %>','<%=resultBoardDto.getNxtNo() %>')"><%=resultBoardDto.getNxtSubject() %></a>
					<% } else { %>
						다음글이 없습니다.
					<% }//if %>
				</td>
			</tr>
		</table>
	</div>
<% }//if %>
<div style="border: 0px solid red; padding-top:20px; width:80%; text-align:right;">
|
<a href="#" onClick="goPage('board_list')">전체목록</a>
|
<a href="#" onClick="goPage('board_list','1','<%=searchGubun %>','<%=searchData %>')">목록</a>
|
<a href="#" onClick="goPage('board_chuga','<%=pageNumber %>','<%=searchGubun %>','<%=searchData %>')">등록</a>
|
<a href="#" onClick="goPage('board_chuga','<%=pageNumber %>','<%=searchGubun %>','<%=searchData %>','<%=resultBoardDto.getNo() %>')">답변</a>
|
<a href="#" onClick="goPage('board_sujung','<%=pageNumber %>','<%=searchGubun %>','<%=searchData %>','<%=resultBoardDto.getNo() %>')">수정</a>
|
<a href="#" onClick="goPage('board_sakje','<%=pageNumber %>','<%=searchGubun %>','<%=searchData %>','<%=resultBoardDto.getNo() %>')">삭제</a>
|
</div>

<% if (imsiPage.equals("viewPage")) { %>
	<a name="comment"></a>
	<div id="commentResult" style="border: 0px solid red; margin: 10px 0px; width: 80%" align="center"></div>

	<script>
		$(document).ready(function () {
			commentList();
		});
		function commentList() {
			const param = {
					'no' : <%=resultBoardDto.getNo() %>
			}
			const url = '../board/commentList.jsp';
			$.ajax({
				type: 'post',
				data: param,
				url: url,
				success: function(data) {
					$('#commentResult').html(data);
				}
			});
		}//commentList
	</script>
<% }//if %>
