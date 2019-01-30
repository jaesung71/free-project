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
  border:1px solid black;
  border-collapse:collapse;
 }
 th,td{
  padding:10px;
 }
</style>
</head>
<body>
	<fieldset style="width:100%;height:100%;text-align:center;">
	<legend>글제목 : <font color="green">${board.boardtitle}</font><br>
	조회수 : ${board.hitcount} | 작성자 : ${board.id} | 작성일 : ${board.indate}
	</legend>
	<hr>
	<div style="width:100%;height:200px;text-align:center;overflow:auto;">
		${board.boardcontent}
	</div>
	<hr>
	첨부파일 :
	<c:if test="${sessionScope.loginId!=null}">
	<c:forEach var="file" items="${bfList}">
	<font color="green"><a href="fileDownload?downLoadFile=${file.dbName}&orgName=${file.orgName}">${file.orgName}</a></font><br>
	</c:forEach>
	</c:if>
	<hr>
	<c:if test="${board.id == sessionScope.loginId ||sessionScope.loginId==sessionScope.god}">
		<form action="goModifyForm">
		<input type="hidden" name="boardseq" value="${board.boardseq}">
		<input type="submit" value="수정">
		</form>
		<form action="deleteBoard">
		<input type="hidden" name="boardseq" value="${board.boardseq}">
		<input type="submit" value="삭제">
		</form>
	</c:if>
	<hr>
	<div style="width:100%;height:100%;text-align:center;overflow:auto;">
	<c:forEach var="comment" items="${cList}">
	<c:if test="${comment.parentseq==0}">
	<font color="green">${comment.comments}</font> <br> 작성자 : ${comment.id} | 작성일 : ${comment.indate}
		
		<form action="rCommentOpen" method="post">
			<input type="hidden" name="boardseq" value="${board.boardseq}">
			<input type="hidden" name="commentsseq" value="${comment.commentseq}">
			<input type = "submit" value="대댓글작성">
		</form>
	<c:if test="${comment.id == sessionScope.loginId||sessionScope.loginId==sessionScope.god}">
	<form action="deleteComment">
		<input type="hidden" name="boardseq" value="${board.boardseq}">
		<input type="hidden" name="commentseq" value="${comment.commentseq}">
		<input type="submit" value="삭제">
	</form>
	<form action="upmodifyForm">
		<input type="hidden" name="boardseq" value="${board.boardseq}">
		<input type="hidden" name="commentseq" value="${comment.commentseq}">
		<input type="submit" value="수정">
	</form>
	<c:if test="${sessionScope.mForm!=null}">
		<form action="modifyComment">
		<input type="text" name="comments">
		<input type="hidden" name="boardseq" value="${board.boardseq}">
		<input type="hidden" name="commentseq" value="${comment.commentseq}">
		
		<input type="submit" value="수정">
		</form>
	</c:if>
	</c:if>
	<c:if test="${sessionScope.loginId!=null&&sessionScope.rCom!=null}">
		<form action="insertRComment" method="post">
			대댓글 : <input type="text"style="width:400px;overflow:auto;" name="comments" >
			<input type="hidden" name="boardseq" value="${board.boardseq}">
			<input type="hidden" name="id" value="${sessionScope.loginId}">
			<input type="hidden" name="commentsseq" value="${comment.commentseq}">
			<input type="submit" value="작성">
		</form>
	</c:if>
	</c:if>
	<c:forEach items="${rcList}" var="rComment">
		<c:if test="${comment.commentseq == rComment.parentseq}">
		<font color="red">┗${rComment.comments}</font> <br> 작성자 : ${rComment.id} | 작성일 : ${rComment.indate}<br><hr>
			<c:if test="${rComment.id == sessionScope.loginId||sessionScope.loginId==sessionScope.god}">
			<form action="deleteComment">
				<input type="hidden" name="boardseq" value="${board.boardseq}">
				<input type="hidden" name="commentseq" value="${rComment.commentseq}">
				<input type="submit" value="삭제">
			</form>
			<form action="upmodifyForm">
				<input type="hidden" name="boardseq" value="${board.boardseq}">
				<input type="hidden" name="commentseq" value="${rComment.commentseq}">
				<input type="submit" value="수정">
			</form>
			</c:if>
		</c:if>
	</c:forEach>
	</c:forEach>
	</div>
<%-- 	<c:if test="${sessionScope.loginId!=null}"> --%>
	<form action="insertComment" method="post">
	댓글 : <input type="text" style="width:400px;overflow:auto;" name="comments">
	<input type="hidden" name="boardseq" value="${board.boardseq}">
	<input type="hidden" name="id" value="${sessionScope.loginId}">
	<input type="submit" value="작성">
	</form>
<%-- 	</c:if> --%>
	</fieldset>
	<a href="goBoard?page=1">게시판으로</a>
	
</body>
</html>