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
	<legend>회원등록</legend>
	<form action="touroku" method="post">
	<table style="text-align:center;">
	<tr>
	<td>ID : <input type="text" name="id"></td>
	</tr>
	<tr>
	<td>PW : <input type="password" name="pw"></td>
	</tr>
	<tr>
	<td>NAME : <input type="text" name="name"></td>
	</tr>
	<tr>
	<td>AGE : <input type="number" name="age"></td>
	</tr>
	<tr>
	<td><input type="submit" value="등록"></td>
	</tr>
	</table>
	</form>
	</fieldset>
	<a href="/prac">홈으로</a>
</body>
</html>