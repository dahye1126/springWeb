<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>게시판</h3>
	<a href="${pageContext.request.contextPath }/board/writeForm">글작성</a>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="a" items="${list}">
		<tr>
			<td>${a.num}</td>
			<td><a href="${pageContext.request.contextPath }/BoardViewItem?num=${a.num}">${a.title}</a></td>
			<td>${a.writer}</td>
		</tr>
		</c:forEach>
	</table>
	
	<form action="${pageContext.request.contextPath}/BoardSearch" method="post">
		<input type="radio" name="searchCheck" value="writer" checked="checked">작성자
		<input type="radio" name="searchCheck" value="title">제목
		<input type="text" name="search">
		<input type="submit" value="검색">
	</form>

</body>
</html>