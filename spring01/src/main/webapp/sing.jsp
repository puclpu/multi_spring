<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/sing.css">
</head>
<body>
<hr>
<h3>노래 등록</h3>
<form action="insert4.multi">
<table class="table table-dark table-striped">
	<tr>
		<td>title</td>
		<td><input name="title"></td>
	</tr>
	<tr>
		<td>singer</td>
		<td><input name="singer"></td>
	</tr>
	<tr>
		<td>writer</td>
		<td><input name="writer"></td>
	</tr>
	<tr>
		<td colspan="2"><button class="btn btn-success">노래 등록</button></td>
	</tr>
</table>
</form>
<hr>
<h3>노래 수정</h3>
<form action="update4.multi">
<table class="table table-dark table-striped">
	<tr>
		<td>id</td>
		<td><input name="id"></td>		
	</tr>
	<tr>
		<td>title</td>
		<td><input name="title"></td>
	</tr>
	<tr>
		<td>singer</td>
		<td><input name="singer"></td>
	</tr>
	<tr>
		<td>writer</td>
		<td><input name="writer"></td>
	</tr>
	<tr>
		<td colspan="2"><button class="btn btn-success">노래 수정</button></td>
	</tr>
</table>
</form>
<hr>
<h3>노래 삭제</h3>
<form action="delete4.multi">
<table class="table table-dark table-striped">
	<tr>
		<td>title</td>
		<td><input name="title"></td>
	</tr>
	<tr>
		<td colspan="2"><button class="btn btn-success">노래 삭제</button></td>
	</tr>
</table>
</form>
<hr>
<h3>노래 검색</h3>
<a href="one?id=1"><button class="btn btn-success">1번 노래 검색</button></a> 
<a href="one?id=4"><button class="btn btn-success">4번 노래 검색</button></a> 
<a href="one?id=5"><button class="btn btn-success">5번 노래 검색</button></a> 
<hr>
<h3>노래 목록</h3>
<a href="list4"><button class="btn btn-success">전체 목록 가져오기</button></a>
</body>
</html>