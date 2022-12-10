<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
</script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			id = $('#id').val()
			alert(id)
		})
	})
</script>
</head>
<body>
spring 40 test <br>
<%session.setAttribute("id", "peach"); %>
<a href="top100">top100</a>

<div>
	
</div>
</body>
</html>