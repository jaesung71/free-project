<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="width:100%;height:100%;text-align:center;">
	<legend>게시글 작성</legend>
	<form action="writing">
	 글제목 : <input type="text" name="boardtitle"><br>
	 글내용 : <textarea rows="10" cols="20" name="boardcontext"></textarea><br>
    	<input type="hidden" name="id" value="${sessionScope.loginId}">
    	<input type="submit" value="글작성">
    </form>
	</fieldset>
</body>
</html>