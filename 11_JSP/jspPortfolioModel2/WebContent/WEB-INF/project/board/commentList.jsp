<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<table border="0" style="width:100%" align="center">
	<tr>
		<td style="padding:20px 0px">
			<span id="procGubun" style="display:">chugaProc</span><br>
			<span id="no" style="display:;">no</span><br>
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
	<tr>
		<td style="padding:0px 0px 10px 0px">
			<table border="0" style="width:100%" align="center">
				<tr>
					<td>작성자 &nbsp; 등록일</td>
					<td align="right">
						<a href="#comment" onclick="">[수정]</a>
						/
						<a href="#comment" onclick="">[삭제]</a>
					</td>
				</tr>
				<tr>
					<td>
						댓글 내용
					</td>
				</tr>
			</table>
			<hr>
		</td>
	</tr>
</table>

<input type="hidden" id="result" />