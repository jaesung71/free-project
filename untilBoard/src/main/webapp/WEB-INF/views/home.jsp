<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div style="width:100%;height:100%;text-align:center;">
	<font color="red">${warning}</font>
	<font color="green">${complete}</font>
	<hr>
	<c:if test="${sessionScope.loginId!=null}">
	<h1>${sessionScope.loginId}님 어서오세요</h1>
	</c:if>
	<hr>
	<form action="goRegist">
		<input type="submit" value="회원가입으로 이동">
	</form>
	<hr>
	<c:if test="${sessionScope.loginId==null}">
	<form action="goLogin">
		<input type="submit" value="로그인으로 이동">
	</form>
	</c:if>
	<c:if test="${sessionScope.loginId!=null}">
	<form action="logout">
		<input type="submit" value="로그아웃">
	</form>
	</c:if>
	<form action="goBoard">
		<input type="submit" value="게시판으로 이동">
	</form>
	</div>
</body>
</html>
