<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "_inc_top.jsp" %>
    
<%

%>

<h2>글쓰기</h2>

<form name="DirForm">
	<table border="1">
		<tr>
			<td class="entryName">작성자</td>
			<td><input type="text" name="writer" id="writer" value="" /></td>
		</tr>
		<tr>
			<td class="entryName">이메일</td>
			<td><input type="text" name="email" id="email" value="" /></td>
		</tr>
		<tr>
			<td class="entryName">비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" value="" /></td>
		</tr>
		<tr>
			<td class="entryName">제목</td>
			<td><input type="text" name="subject" id="subject" value="" /></td>
		</tr>
		<tr>
			<td class="entryName">내용</td>
			<td><textarea name="content" id="content" style="width:300px; height:100px;" ></textarea></td>
		</tr>
		<tr>
			<td class="entryName">공지글</td>
			<td>
				<input type="radio" name="noticeGubun1" id="noticeGubun1" value="T" /> 공지글 &nbsp;
				<input type="radio" name="noticeGubun2" id="noticeGubun2" value="F" checked/> 공지글아님 &nbsp;
			</td>
		</tr>
		<tr>
			<td class="entryName">비밀글</td>
			<td>
				<input type="radio" name="secretGubun1" id="secretGubun1" value="T" /> 비밀글 &nbsp;
				<input type="radio" name="secretGubun2" id="secretGubun2" value="F" checked/> 비밀글아님 &nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="save()" >저장하기</button>
				<button type="button" onClick="location.href='main.jsp?menuGubun=board_list';" >목록으로</button>
			</td>
		</tr>
	</table>
</form>

<script>
	function save() {
		if (confirm('등록할까요?')) {
			document.DirForm.action = 'mainProc.jsp?menuGubun=board_chugaProc';
			document.DirForm.method = 'post';
			document.DirForm.submit();
		}//if
	}//save
</script>