<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>정보 입력</h3>
	<form action="${pageContext.request.contextPath }/test/test1" method="post">
		name: <input type="text" name="name"><br/>
		age: <input type="text" name="age"><br/>
		<input type="submit" value="등록">
	</form>
</body>
</html>


