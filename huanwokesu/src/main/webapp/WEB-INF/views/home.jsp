<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<fieldset style="text-align:center;width:100%">
	<legend>홈</legend>
		<form action="goAhome">
			<input type="submit" value="관리자 페이지">
		</form>
		<hr>
		<form action="goChome">
			<input type="submit" value="구매자 페이지">
		</form>
	</fieldset>
</html>
