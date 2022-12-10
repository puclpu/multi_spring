<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/project.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div id="total">
		<div id="top">
			<jsp:include page="../../top.jsp"></jsp:include>
		</div>
		<div id="navigation">
			<jsp:include page="../../navigation.jsp"></jsp:include>
		</div>
		<div id="center">
		<hr>
			<h3>곡정보</h3>
			<table border="1">
				<tr>
					<td rowspan="4"><img alt="${vo.img }" src="resources/img/${vo.img }" width="300px"></td>
					<td colspan="2">${vo.title }</td>
					<td>담기</td>
				</tr>
				<tr>
					<td rowspan="3">${vo.singer }</td>
					<td colspan="2">발매일 : ${vo.musicDate }</td>
				</tr>
				<tr><td colspan="2">장르 : ${vo.genre }</td></tr>
				<tr><td colspan="2">조회수 : ${vo.hits }</td></tr>
			</table>
		</div> <!-- center -->
	</div> <!-- total -->
</body>
</html>