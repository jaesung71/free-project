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
	<div style="width:100%;height:100%;text-align:center;">
	<h1>글제목 : ${board.boardtitle}</h1><h3>조회수 : ${board.hitcount}</h3><br>
	<h2>글내용 : ${board.boardcontext}</h2>
	<c:if test="${sessionScope.loginId eq board.id}">
		<form action="alterBoard">
		<input type="hidden" name="boardseqs" value="${board.boardseqs}">
		<input type = "submit" value="수정">
		</form>
		<form action="deleteBoard">
		<input type="hidden" name="boardseqs" value="${board.boardseqs}"> 
		<input type="submit" value="삭제">
		</form>
	</c:if>
	</div>
	
	<div style="width:100%;height:100%;text-align:center;">
		
		<c:forEach var="comments" items="${cList}">
		<c:if test="${comments.boardseq eq board.boardseqs && comments.parentseq ==0}">
		<td>${comments.id} : </td><td>${comments.comments} </td><td>${comments.indate}</td>
		<c:if test="${sessionScope.loginId eq comments.id}">
		<form action="deleteComments">
				<input type="hidden" name="commentsseq" value="${comments.commentsseq}">
				<input type="hidden" name="boardseq" value="${board.boardseqs}">
				<input type="submit" value="삭제">
		</form>
		</c:if>
		<c:if test="${sessionScope.loginId!=null}">
			<form action="insertRcommentsform">
				<input type="hidden" name="boardseq" value="${board.boardseqs}">
				<input type="hidden" name="commentsseq" value="${comments.commentsseq}">
				<input type="submit" value="댓글">
			</form><br>
		</c:if>
		</c:if>
		</c:forEach>
	</div>
	
	<div style="width:100%;height:200px;text-align:center;">
	<font color="red">${warning}</font>
	<font color="green">${complete}</font>
	<form action="insertComments">
		댓글 : <textarea rows="1" cols="100" name="comments"></textarea>
		<input type="hidden" name="id" value="${sessionScope.loginId}">
		<input type="hidden" name="boardseq" value="${board.boardseqs}">
		<input type="submit" value="작성">
	</form>
	</div>
	<div style="text-align:right">
	<p><a href="goBoard">뒤로가기...</a></p>
	</div>
</body>
</html>