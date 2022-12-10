<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert3.multi">
<table>
	<tr>
		<td>name</td>
		<td><input name="name"></td>
	</tr>
	<tr>
		<td>url</td>
		<td><input name="url"></td>
	</tr>
	<tr>
		<td>img</td>
		<td><input name="img"></td>
	</tr>
	<tr>
		<td colspan="2"><button>북마크 등록</button></td>
	</tr>
</table>
</form>
<hr>
<h3>북마크 삭제</h3>
<a href="delete3.multi?id=1">1번 북마크 삭제</a>
<a href="delete3.multi?id=2">2번 북마크 삭제</a>
<a href="delete3.multiid=?id=3">3번 북마크 삭제</a>
<hr>
<h3>북마크 검색s</h3>
<a href="one3.multi?id=1">1번 북마크 검색</a>
<a href="one3.multi?id=2">2번 북마크 검색</a>
<a href="one3.multi?id=3">3번 북마크 검색</a>
</body>
<hr>
<h3>북마크 전체 검색</h3>
<a href="list3.multi">북마크 전체 검색</a>
</html>