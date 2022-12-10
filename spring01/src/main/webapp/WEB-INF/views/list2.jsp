<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="dto" items="${list}">
id : ${dto.id} <br>
title : ${dto.title} <br>
content : ${dto.content} <br>
writer : ${dto.writer} <br>
<hr color="lime">

</c:forEach>
</body>
</html>