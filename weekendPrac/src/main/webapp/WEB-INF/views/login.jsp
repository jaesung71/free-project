<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table,td,th{
		border:2px solid orange;
		border-collapse:collapse;
		
	}
	th,td{
		padding:20px;
		boarder:2px solid red;
	}

</style>
</head>
<body>
	<fieldset style="text-align:center">
	<legend>로그인</legend>
	<form action="login" method="post">
		<table>
		<tr>
		<td>ID :</td><td><input type="text" name="id"></td>
		</tr>
		<tr>
		<td>PW :</td><td><input type="password" name="pw"></td>
		</tr>
		<tr>
		<td></td><td><input type="submit" value="로그인"></td>
		</tr>
		</table>		
	</form>
	</fieldset>
	<a href="/prac">홈으로</a>
</body>
</html>