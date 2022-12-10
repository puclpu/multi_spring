<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/out.css">
<script type="text/javascript" src="resources/js/out.js"></script>
<script type="text/javascript">
	/* go() */ /* out.js에 있는 go함수 호출하여 실행 */
</script>
</head>
<body>
	<hr>
	<h3>게시판 글쓰기</h3>
	<form action="insert2.multi">
		<table class="table table-hover">
			<tr>
				<td>title</td>
				<td><input name="title" value="fun"></td>
			</tr>
			<tr>
				<td>content</td>
				<td><input name="content" value="fun"></td>
			</tr>
			<tr>
				<td>writer</td>
				<td><input name="writer" value="apple"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">게시물 글쓰기 완료</button>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<h3>게시판 글삭제</h3>
	<form action="delete2.multi">
		<table class="table table-hover">
			<tr>
				<td>id</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">게시물 글삭제 완료</button>
				</td>
			</tr>
		</table>
	</form>
	
	<hr>
	<h3>게시글 검색</h3>
	<a href="one2.multi?id=103">103번 글 검색</a>
	<a href="one2.multi?id=104">104번 글 검색</a>
	<a href="one2.multi?id=105">105번 글 검색</a>
	
	<hr>
	<h3>게시글 전체검색</h3>
	<a href="list2.multi">게시글 전체 검색</a>
	
</body>
</html>