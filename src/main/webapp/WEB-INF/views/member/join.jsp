<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){    //$(document)객체
	$('#idBtn').click(function(){//$('#check')아이디 / $('.check')클래스
		var id = $('#id').val(); //val: 태그의 값을 쓰거나 읽는 함수(value속성값에)
		if(id==''||id==null) {
			alert('id를 입력하시오');
			return;
		}
		var param = "id="+id;
		$.ajax({ //비동기적 요청보내다
			type:"POST",
			url:"${pageContext.request.contextPath}/member/checkId", //보낼곳
			data:param, //전송할 데이터
			success:function(data){ //응답제대로받았을때 호출되는 함수 (서버에서 처리된값을 가져오는 함수)
				var obj = eval('('+data+')'); //obj:멤버변수 flag //eval : json 표현을 바꿔주다
				var str = '';
				if(obj.flag) {
					str='사용가능한 아이디';
				}else {
					str = '중복된 아이디';
					$('#id').val('');
				}
				$('#idResult').html(str);
			}
		});
	});
});


</script>



</head>
<body>
<h3>회원가입</h3>
	<form action="${pageContext.request.contextPath}/member/join" method="post">
		id : <input type="text" name="id" id="id">
		<input type="button" value="중복체크" id="idBtn"><span id="idResult"></span>
		<br>
		pwd : <input type="text" name="pwd"><br>
		name : <input type="text" name="name"><br>
		email : <input type="text" name="email"><br>
		<input type="submit" value="가입">
		<input type="reset" value="취소">
	</form>
</body>
</html>