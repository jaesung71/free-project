<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세페이지</title>
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
	<legend>상품명 : ${product.name}</legend>
	<td>수량 : ${product.quantity} ||</td><td>가격 : ${product.price} || </td><td>등록일 : ${product.indate}</td>
	<hr>
	<textarea style="text-align:center;"rows="10" cols="20">${product.comments}</textarea>
	<hr>
	<font color="red">${warning}</font>
	<form action="buyProduct">
		<input type="number" name="quantity" min="0" placeholder="구매수량 선택" style="text-align:center;"><br>
		<input type="hidden" name="productseq" value="${product.productseq}">
		<input type="hidden" name="page" value="${page}">
		<input type="submit" value="구입">
	</form>
	</fieldset>
</body>
<a href="goProductList">상품목록</a>
</html>