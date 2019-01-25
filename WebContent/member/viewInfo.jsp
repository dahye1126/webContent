<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${sessionScope.id}의 정보</h3>
<form action="${pageContext.request.contextPath}/EditInfo" method="post">
		id : <input type="text" name="id" value="${m.id}" readonly>
		pwd : <input type="text" name="pwd" value="${m.pwd}"><br>
		name : <input type="text" name="name" value="${m.name}" readonly><br>
		email : <input type="text" name="email" value="${m.email}"><br>
		<input type="submit" value="수정">
</form>
</body>
</html>