<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- model에 의해 dto가 전달되어 있는 상태 -->
<!-- model의 속성을 출력할 때는 EL을 쓴다 -->
<!-- expression(표현식, 출력) language (EL) -->
전달받은 id : ${dto.id} <br>
전달받은 name : ${dto.name} <br>
전달받은 url : ${dto.url} <br>
전달받은 img : <img src="resources/img/${dto.img}">
<br>
</body>
</html>