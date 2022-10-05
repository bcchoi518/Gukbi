<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>

<table border="0" style="width:100%" align="center">
	<tr>
		<td style="padding:20px 0px">
			<span id="procGubun" style="display:none">chuga</span>
			<span id="no" style="display:none">${requestScope.no }</span>
			<span id="commentNo" style="display:none"></span>
			이름: <input type="text" name="commentWriter" id="commentWriter" size="10" value="" />
			비밀번호: <input type="password" name="commentPasswd" id="commentPasswd" size="10" value="" /><br>
			댓글: <input type="text" name="commentContent" id="commentContent" size="100" value="" />
				 <button type="button" id="btnCommentSave">등록</button>
				 <button type="button" id="btnCommentReset">초기화</button>
		</td>
	</tr>
</table>

<table border="0" style="width:100%" align="center">
	<tr>
		<td style="padding:0px 0px 10px 0px">
			<table border="0" style="width:100%" align="center">
				<c:forEach var="dto" items="${requestScope.list }">
					<tr>
						<td>
						${dto.writer }
						<input type="hidden" name="commentWriter_${dto.commentNo }" id="commentWriter_${dto.commentNo }" value="${dto.writer }"/>
						&nbsp; 
						${dto.regiDate }</td>
						<td align="right">
							<a href="#comment" onclick="suntaek('sujung', '${dto.commentNo }')">[수정]</a>
							/
							<a href="#comment" onclick="suntaek('sakje', '${dto.commentNo }')">[삭제]</a>
						</td>
					</tr>
					<tr>
						<td>
							${dto.content }
							<input type="hidden" name="commentContent_${dto.commentNo }" id="commentContent_${dto.commentNo }" value="${dto.content }"/>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr>
		</td>
	</tr>
</table>

<input type="hidden" id="result" />

<script>
	$('#btnCommentSave').click(function () {
		if (confirm('OK?')) {
		const param = {
			no: $('#no').text(),
			procGubun: $('#procGubun').text(),
			commentNo: $('#commentNo').text(),
			commentWriter: $('#commentWriter').val(),
			commentPasswd: $('#commentPasswd').val(),
			commentContent: $('#commentContent').val()
		}//param
		console.log(param);
		const url = '${path }/board/commentProc';
		$.ajax({
			type: 'post',
			data: param,
			url: url,
			success: function(result) {
				$('#result').val(result);
				if($('#result').val() > 0) {
					alert('성공');
				} else {
					alert('실패');
				}//if
				commentList();
			}//success
		});//ajax
		}//if
	});//btnCommentSave.Click
	
	$('#btnCommentReset').click(function () {
		$('#procGubun').text('chuga');
		$('#commentNo').text('');
		$('#commentWriter').val('');
		$('#commentPasswd').val('');
		$('#commentContent').val('');
		$('#btnCommentSave').text('등록');
	});
	
	function suntaek(value1, value2) {
		$('#procGubun').text(value1);
		$('#commentNo').text(value2);
		$('#commentWriter').val($('#commentWriter_'+ value2).val());
		$('#commentContent').val($('#commentContent_'+ value2).val());
		
		if (value1 == 'sujung') {
			document.querySelector('#btnCommentSave').innerText = '수정';
		} else if (value1 == 'sakje') {
			document.querySelector('#btnCommentSave').innerText = '삭제';
		}//if
	}//suntaek
</script>