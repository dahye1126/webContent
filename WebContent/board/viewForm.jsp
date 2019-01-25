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
글번호: ${a.num}<br>
작성자: ${a.writer}<br>
작성시간: ${a.w_date}<br>
제목: ${a.title}<br>
내용: ${a.content}<br>

	<a href="board/list.jsp">목록</a>
	
	
	<%-- <c:if "${a.writer}".equals("${sessionScope.id}")> --%>
	<c:if test = "${sessionScope.id eq a.writer}">

		<a href="board/list.jsp">수정</a>
		<a href="board/list.jsp">삭제</a>
	</c:if>


</body>
</html>