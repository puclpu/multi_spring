<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dto" class="com.multi.mvc01.MemberDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
입력받은 id: <%=dto.getId() %> <br>
입력받은 pw: <%=dto.getPw() %> <br>
입력받은 name: <%=dto.getName() %> <br>
입력받은 tel: <%=dto.getTel() %> <br>
		
</body>
</html>