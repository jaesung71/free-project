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
	
	<fleldset style="text-align:center;width:100%;">
	<legend>관리자 페이지</legend>
		<c:if test="${sessionScope.AdminloginId==null}">
		<form action="goAdminLogin">
		<input type="submit" value="로그인">
		</form>
		</c:if>
		<c:if test="${sessionScope.AdminloginId!=null}">
		<form action="goProductManagement">
		<input type="submit" value="상품관리">
		</form>
		<form action="goCustomerManagement">
		<input type="submit" value="회원관리">
		</form>
		<form action="adminlogout">
		<input type="submit" value="로그아웃">
		</form>
		</c:if>
	</fleldset>
	<a href="/prac">홈으로</a>
</body>
</html>