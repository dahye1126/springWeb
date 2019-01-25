<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>내 정보확인</h3>
	<form action="${pageContext.request.contextPath}/member/edit" method="post">
		id : <input type="text" name="id" value="${m.id}" readonly><br>
		pwd : <input type="text" name="pwd" value="${m.pwd}"><br>
		name : <input type="text" name="name" value="${m.name}" readonly><br>
		email : <input type="text" name="email" value="${m.email}"><br>
		<input type="submit" value="수정"><br>
		<input type="button" value="확인" onclick="javascript:history.go(-1)">
	</form>

</body>
</html>