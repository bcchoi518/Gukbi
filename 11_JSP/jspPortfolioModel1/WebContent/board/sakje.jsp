<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>
    
<h2>글삭제</h2>

<form name="DirForm">
	<input type="hidden" name="no" value="<%=resultBoardDto.getNo() %>" />
	<input type="hidden" name="pageNumber" value="<%=pageNumber %>" />
	<input type="hidden" name="searchGubun" value="<%=searchGubun %>" />
	<input type="hidden" name="searchData" value="<%=searchData %>" />
	<table border="1">
		<tr>
			<td class="entryName">작성자</td>
			<td><%=resultBoardDto.getWriter() %></td>
		</tr>
		<tr>
			<td class="entryName">이메일</td>
			<td><%=resultBoardDto.getEmail() %></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" value="" /></td>
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
			<td class="entryName">공지글</td>
			<td>
				<% if (resultBoardDto.getNoticeNo() > 0) { %>
					O
				<% } else { %>
					X
				<% }//if %>
			</td>
		</tr>
		<tr>
			<td class="entryName">비밀글</td>
			<td>
				<% if (resultBoardDto.getSecretGubun().equals("T")) { %>
					O
				<% } else { %>
					X
				<% }//if %>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="save()" >삭제하기</button>
				<button type="button" onClick="location.href='main.jsp?menuGubun=board_list&searchGubun=<%=searchGubun %>&searchData=<%=searchData %>';" >목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function save() {
		if (confirm('삭제할까요?')) {
			document.DirForm.action = 'mainProc.jsp?menuGubun=board_sakjeProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
</script>