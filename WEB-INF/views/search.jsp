<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${search } <br>
<c:forEach var="vo" items="${list}">
${vo.title } <br>
${vo.singer }
<hr>
</c:forEach> 
<hr>
<hr>
<c:forEach var="vo" items="${list2}">
${vo.title } <br>
${vo.singer }
<hr>
</c:forEach>
</body>
</html>