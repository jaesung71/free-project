<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<fieldset style="text-align:center;padding:10;">
	<legend><h1><font color="green">재성인사이드</font></h1></legend>
		<c:if test="${sessionScope.loginId != null}">
		<font color="green">
		<c:if test="${sessionScope.grade!=null}">
			<c:if test="${sessionScope.grade==0}">찐따 </c:if>
			<c:if test="${sessionScope.grade==1}">아싸 </c:if>
			<c:if test="${sessionScope.grade==2}">셔틀 </c:if>
			<c:if test="${sessionScope.grade==3}">인싸 </c:if>
			<c:if test="${sessionScope.grade==4}">핵인싸 </c:if>
			<c:if test="${sessionScope.grade==5}">인싸그자체 </c:if>
		</c:if>
		${sessionScope.loginId}님 환영합니다.
		</font>
		<hr>
		<form action = "logout">
			<input type="submit" value="로그아웃">
		</form>
		
		</c:if>
		<c:if test="${sessionScope.loginId == null}">
		<form action="goTouroku">
			<font color="red">${warning}</font><br>
			<font color="green">${complete}</font><br>
			<input type="submit" value="회원가입하러 가깅">
		</form>
		<hr>
		<form action="goLogin">
			<input type="submit" value="로그인해버렷-">
		</form>
		<hr>
		</c:if>
		<form action="goBoard">
			<input type="submit" value="게시판와도코">
		</form>
	</fieldset>
</html>
