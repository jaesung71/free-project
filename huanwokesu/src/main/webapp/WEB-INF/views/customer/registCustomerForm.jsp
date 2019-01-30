<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록페이지</title>
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
	<legend>등록</legend>
	<form action="registCustomer" method="post">
		<table>
		<tr>
    	<td>ID</td><td><input type="text" name="customerid"></td>
    	</tr>
    	<tr>
    	<td>PW</td><td><input type="password" name="customerpw"></td>
    	</tr>
    	<tr>
    	<td>Name</td><td> <input type="text" name="name"></td>
    	</tr>
    	<tr>
    	<td>Phone</td><td> <input type="text" name="phone"><td>
    	</tr>
    	<tr>
    	<td>Birthdate</td><td> <input type="date" name="birthdate"><td>
    	</tr>
    	<tr>
    	<td>Address</td><td> <input type="text" name="address"><td>
    	</tr>
    	<tr>
    	<td></td><td><input type="submit" value="등록"></td>
    	</tr>
    	</table>
	</form>
	</fieldset>
	<a href="goChome">구매자 홈으로</a>
</body>
</html>