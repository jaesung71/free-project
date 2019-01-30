<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	table {
    width: 100%;
    border: 1px solid #444444;
	border-collapse:collapse;
  }
  	th, td {
    border: 2px solid #444444;
	padding:20px;
  }
</style>
</head>
<body>
	<fieldset style="text-align:center;width:100%;">
	<legend>로그인</legend>
	<form action="login" method="post">
		<table>
		<tr>
    	<td>ID</td><td><input type="text" name="customerid"></td>
    	</tr>
    	<tr>
    	<td>PW</td><td><input type="password" name="customerpw"></td>
    	</tr>
    	<tr>
    	<td></td><td><input type="submit" value="로그인"></td>
    	</tr>
    	</table>
	</form>
	</fieldset>	
	<a href="goChome">구매자 홈으로</a>
</body>
</html>