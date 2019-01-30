<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="text-align:center;">
	<legend>글수정</legend>
	<form action="modify">
		글제목 : <input type="text" name="boardtitle" value="${board.boardtitle}"><br>
		<div style="width:100%;height:100%;text-align:center;">
		글내용 : <input type="text" name="boardcontext" value ="${board.boardcontext}">
		</div>
		<input type="hidden" name="boardseqs" value="${board.boardseqs}">
		<input type="submit" value="수정">
	</form>
	</fieldset>
</body>
</html>