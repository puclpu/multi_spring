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
	<h3>회원가입</h3>
	<form action="insert.multi">
		<table class="table table-hover">
			<tr>
				<td>아이디</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input name="pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="tel"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">회원가입처리</button>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<h3>로그인</h3>
	<form action="login.multi">
		<table class="table table-hover">
			<tr>
				<td>아이디</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">로그인처리</button>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<h3>회원탈퇴</h3>
	<form action="delete.multi">
		<table class="table table-hover">
			<tr>
				<td>아이디</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">회원탈퇴처리</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>