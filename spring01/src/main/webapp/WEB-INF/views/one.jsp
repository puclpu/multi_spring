<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/sing.css">
</head>
<body>
<%-- 검색된 id는 ${dto.id} <br> 
검색된 title는 ${dto.title} <br>
검색된 contents는 ${dto.singer} <br>
검색된 writer는 ${dto.writer} <br> --%>
<h3>검색 결과입니다</h3>
<table class="table table-dark table-striped">
	<tr>
		<td>id</td>
		<td>${dto.id}</td>
	</tr>
	<tr>
		<td>title</td>
		<td>${dto.title}</td>
	</tr>
	<tr>
		<td>singer</td>
		<td>${dto.singer}</td>
	</tr>
	<tr>
		<td>writer</td>
		<td>${dto.writer}</td>
	</tr>
</table>
</body>
</html>