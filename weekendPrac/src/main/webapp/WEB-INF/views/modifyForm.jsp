<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form action="modifyBoard" enctype="multipart/form-data" method="post">
	<table>
	<tr>
	<td>글제목 : </td><td><input type="text" name="boardtitle" value="${board.boardtitle}"></td>
	</tr>
	<tr>
	<td>글내용 : </td><td><textarea rows="10" cols="20" name="boardcontent" style="overflow:auto;">${board.boardcontent}</textarea></td>
	</tr>
	<tr>
	<td>현재 첨부파일 :</td><td><c:forEach items="${bfList}" var="file">
	<input type="text" name="orgName" value="${file.orgName}"><br>
	<input type="hidden" name="boardfileseq" value="${file.boardfileseq}">
	</c:forEach>
	</td>
	</tr>
	<tr>
	<td>추가 첨부파일 : </td><td><input type="file" name="uploadFile" multiple="multiple"><br>
	<input type="hidden" name="boardseq" value="${board.boardseq}"></td>
	</tr>
	<tr>
	<td></td><td><input type="submit" name="작성완료"></td>
	<tr>
	</table>
	</form>
	</fieldset>
	<a href="/prac">홈으로</a>
</body>
</html>