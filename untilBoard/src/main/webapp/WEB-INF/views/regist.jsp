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
	<legend>회원가입 페이지</legend>
	<form action="regist" method="post">
		ID : <input type="text" name="id"><br>
		pw : <input type="password" name="pw"><br>
		name : <input type="text" name="name"><br>
		age : <input type="text" name="age"><br>
		email : <input type="email" name="email"><br>
		phone : <input type="text" name="phone"><br>
		<input type="submit" value="가입">
	</form>	
	</fieldset>
</body>
</html>