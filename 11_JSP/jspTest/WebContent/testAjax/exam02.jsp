<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h2>성적처리</h2>
	이름: <input type="text" name="name" id="name"/><br>
	국어: <input type="text" name="kor" id="kor"/><br>
	영어: <input type="text" name="eng" id="eng"/><br>
	수학: <input type="text" name="mat" id="mat"/><br>
	과학: <input type="text" name="sci" id="sci"/><br>
	역사: <input type="text" name="his" id="his"/><br>
	<button type="button" id="btnSave">확인</button>
	
	<div id="result" style="border: 0px solid red;"></div>
	
	<div id="displayArea" style="display:none;">
	<br>
	<hr>
	<br>
	
	이름: <span id="span_name"></span><br>
	국어: <span id="span_kor"></span><br>
	영어: <span id="span_eng"></span><br>
	수학: <span id="span_mat"></span><br>
	과학: <span id="span_sci"></span><br>
	역사: <span id="span_his"></span><br>
	총점: <span id="span_tot"></span><br>
	평균: <span id="span_avg"></span><br>
	등급: <span id="span_grade"></span><br>
	</div>
	<script>
		$(function() {
			$('#btnSave').click(function() {
				const name = $('#name').val();
				const kor = $('#kor').val();
				const eng = $('#eng').val();
				const mat = $('#mat').val();
				const sci = $('#sci').val();
				const his = $('#his').val();
				const param = {
						'name': name,
						'kor': kor,
						'eng': eng,
						'mat': mat,
						'sci': sci,
						'his': his
				};
				$.ajax({ //비동기식처리..
					type: 'post',
					data: param,
					url: 'exam02Proc.jsp',
					success: function(data) {
// 						$('#result').html(data);
						json_info = JSON.parse(data);
						$('#span_name').text(json_info.name);
						$('#span_kor').text(json_info.kor);
						$('#span_eng').text(json_info.eng);
						$('#span_mat').text(json_info.mat);
						$('#span_sci').text(json_info.sci);
						$('#span_his').text(json_info.his);
						$('#span_tot').text(json_info.tot);
						$('#span_avg').text(json_info.avg);
						$('#span_grade').text(json_info.grade);
						
						$('#displayArea').show();
					}
				});
			});
		});
	</script>
</body>
</html>