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
	<fieldset style="width:100%;height:100%;text-align:center;">
	<legend>글작성</legend>
	<form action="writeBoard" enctype="multipart/form-data" method="post">
	<table style="text-align:center">
	<tr>
	<td>글등급 : </td><td><select name="boardGrade" id="boardGrade">
		<option value="0">찐따</option>
		<option value="1">아싸</option>
		<option value="2">셔틀</option>
		<option value="3">인싸</option>
		<option value="4">핵인싸</option>
	</select></td>
	</tr>
	<tr>
	<td>글제목 : </td><td><input type="text" name="boardtitle"></td>
	</tr>
	<tr>
	<td>글내용 : </td><td><textarea rows="10" cols="20" name="boardcontent" style="overflow:auto;"></textarea></td>
	</tr>
	<input type="hidden" name="id" value="${sessionScope.loginId}">
	<tr>
	<td></td><td><input type="file" multiple="multiple" name="upLoadFile"></td>
	</tr>
	<tr>
	<td></td><td><input type="submit" name="작성완료"></td>
	</tr>
	</table>
	</form>
	</fieldset>
	<a href="/prac">홈으로</a>
</body>
</html>