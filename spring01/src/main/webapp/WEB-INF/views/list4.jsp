<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/sing.css">
</head>
<body>
<h3>전체 목록</h3>
<hr color="lime">
<c:forEach var="dto" items="${list}">
검색한 id >> ${dto.id} <br>
검색한 title >> ${dto.title} <br> <!-- dto.getName() -->
검색한 singer >> ${dto.singer} <br>
검색한 writer >> writer <br>
<hr color="lime">
</c:forEach>
</body>
</html>