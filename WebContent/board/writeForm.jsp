<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글작성</h3>
	<form action="${pageContext.request.contextPath}/BoardWrite" method="post">
		writer:<input type="text" name="writer" value="${sessionScope.id}" readonly><br>
		title:<input type="text" name="title"><br>
		content:<input type="text" name="content"><br>
		<input type="submit" value="작성"><br>
	</form>
	

</body>
</html>