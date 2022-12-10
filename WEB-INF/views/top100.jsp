<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/project.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
</script>
<script type="text/javascript">
	$(function() {
		$('.b1').on('click',(function() {
			/* alert( $(this).attr("add")) */
			$.ajax({
				url : "putmysong",
				data : {
					memberid : "<%=session.getAttribute("id")%>",
					musicid : $(this).attr("add")
				},
				success : function() {
					alert('마이뮤직에 담았습니다.')
				}
			}) //ajax
			$.ajax({
				url : "puthit",
				data : {
					id : $(this).attr("add")
				},
				success : function() {

				}
			})
		}))//on

	})
</script>
<style type="text/css">
button {
	color: #e5e5e5;
	border: 0;
	outline: 0;
	background: white;
}

table {
	text-align: center;
}

table th, td {
	border-top: 1px solid #e5e5e5;
	border-bottom: 1px solid #e5e5e5;
}

.titlesinger {
	text-align: left;
	padding-left: 10px;
}
</style>
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
			<div id="table">
				<h2>TOP 100</h2>
				<table style="width: 100%">
					<tr>
						<th>순위</th>
						<th colspan="2">곡정보</th>
						<th>담기</th>
					</tr>
					<%
						int ranking = 1;
					%>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td><%=ranking%></td>
							<td style="width: 100px;"><img alt="${vo.img }"
								src="resources/img/${vo.img }" height="100px"></td>
							<td class="titlesinger"><a href="one?id=${vo.id }">${vo.title }
									<br> ${vo.singer }
							</a></td>
							<td><input name="musicid" id="musicid" type="hidden" value="${vo.id }">
								<button class="b1" add="${vo.id}">+</button></td>
						</tr>
						<%ranking++;%>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- center -->
	</div>
	<!-- total -->
</body>
</html>