<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
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
	<fieldset style="text-align:center;">
	<legend>상품등록</legend>
	<form action="registProduct" method="post">
	<table>
	<tr>
	<td>상품이름</td><td><input type="text" name="name" placeholder="상품명" style="text-align:center;width:100%;"></td>
	</tr>
	<tr>
	<td>상품수량</td><td><input type="number" min="0" max="500"name="quantity" placeholder="상품수량 최대 500개"style="text-align:center;width:100%;"></td>
	</tr>
	<tr>
	<td>상품가격</td><td><input type="text" name="price" placeholder="상품가격"style="text-align:center;width:100%;"></td>
	</tr>
	<tr>
	<td>상품설명</td><td><textarea rows="10" cols="20" name="comments" placeholder="상품설명"style="text-align:center;width:100%;"></textarea></td>
	</tr>
	<tr>
	<td></td><td><input type="submit" value="등록"></td>
	</tr>
	</table>
	</form>
	</fieldset>
</body>
</html>