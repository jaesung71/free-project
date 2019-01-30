<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	
// 	var login;
	
// 	function makeCancel(){
// 		document.getElemetById("login").innerHTML=login;
// 	}

// 	function makeLogin(){
		
// 		window.open("goLogin","로그인창",,"top=20,left=20,width=20,height=20");
		
// 		login = document.getElementById("login").innerHTML;
// 		var content="";
		
// 		content += "<form action='goLogin'>";
// 		content += "ID :<input type='text' name='customerid'><br>";
// 		content += "PW :<input type='password' name='customerpw'><br>";
// 		content += "<input type='submit' value='login'>";
// 		content += "<input type='button' onclick='makeCancel()' value='cancel'>";
// 		content += "</form>";
		
// 		document.getElemetById("login").innerHTML=content;

// 	}

</script>
<body>
	<fieldset style="text-align:center;width:100%">
	<legend>홈</legend>
		<c:if test="${sessionScope.loginId!=null}">
		<font color="green">${complete}</font><br>
		<form action="logout">
			<input type="submit" value="로그아웃">
		</form>
		<br>
		<form action="goProductList">
			<input type="submit" value="상품목록">
		</form>
		<form action="goSoldList">
			<input type="submit" value="구매내역">
		</form>
		</c:if>
		<hr>
		<c:if test="${sessionScope.loginId==null}">
		<font color="red">${warning}</font>
		<form action="goRegistCustomer">
			<input type="submit" value="등록">
		</form>
		<br>
<!-- 		<div id="login"> -->
<!-- 			<a onclick="javascript:makeLogin()">로그인</a> -->
<!-- 		</div> -->
		<form action="goLogin">
			ID :<input type="text" name="customerid"><br>
			PW :<input type="password" name="customerpw"><br>
			<input type="submit" value="로그인	">
		</form>
		</c:if>
	</fieldset>
	<a href="/prac">홈으로</a>
</body>
</html>