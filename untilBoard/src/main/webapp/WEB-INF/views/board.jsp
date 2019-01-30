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
	<fieldset style="text-align:center;">
	<legend>게시판</legend>
	<table>
	<tr>
	<td>글번호</td><td>글제목</td><td>조회수</td><td>게시자</td><td>게시일</td>
	</tr>
	<c:forEach var="Board" items="${bList}" varStatus="test">
	<tr>
	<td>${test.count}</td><td><a href="innerBoard?boardseqs=${Board.boardseqs}">${Board.boardtitle}</a></td><td>${Board.hitcount}</td><td>${Board.id}</td><td>${Board.indate}</td><br>
	</tr>
	</c:forEach>
	</table>
	<font color="red">${warning}</font>
	<font color="green">${complete}</font>
	<form action="writeBoard">
		<input type="submit" value="글작성하기">
	</form>
	</fieldset>
</body>
</html>