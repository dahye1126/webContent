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
	<c:forEach begin="0" end="${listLength}" step="1" var="i" varStatus="status">
		글번호: ${list.get(i).num}<br>
		작성자: ${list.get(i).writer}<br>
		작성시간: ${list.get(i).w_date}<br>
		제목: ${list.get(i).title}<br>
		내용: ${list.get(i).content}<br>
	</c:forEach>

</body>
</html>