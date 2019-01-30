<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
	padding:10px;
  }
</style>
<script>
	function gardeFormSubmit(currentPage){
		var form = document.getElementById("gradeFrom");
		var page = document.getElementById("page");
		var boardGrade = document.getElementById("boardGrade");
		var id = document.getElementById("id");
		page.value=currentPage;
		from.submit();
	}
	function pagingFormSubmit(currentPage){
    var form = document.getElementById("pagingForm");
    var page = document.getElementById("page");
	var searchType = document.getElementById("searchType");
    var search = document.getElementById("search");
    page.value = currentPage;
    form.submit();
	}

</script>

</head>
<body>
	<fieldset style="text-align:center">
	<legend><font color="red">치명적인 재성인사이드</font></legend>
<!-- 	<form action="goBoard" id="gradeFrom"style="text-align:right;"> -->
<!-- 		<input type="hidden" name="page" id="page"> -->
<%-- 		<input type="hidden" name="id" id="id" value="${sessionScope.loginId}"> --%>
<!-- 		<select name="boardGrade" id="boardGrade"> -->
<!-- 		<option value="0" selected="selected"> -->
<!-- 		회원등급별 열람 -->
<!-- 		<option value="0">찐따</option> -->
<!-- 		<option value="1">아싸</option> -->
<!-- 		<option value="2">셔틀</option> -->
<!-- 		<option value="3">인싸</option> -->
<!-- 		<option value="4">핵인싸</option> -->
<!-- 		</select> -->
<%-- 		<input type="submit" value="이동" onclick="gardeFormSubmit(${navi.currentPage})"> --%>
<!-- 	</form> -->
	<div style="text-align:center;">
		<c:if test="${empty bList}">
			<font color="red">작성된 글이 없는 망게시판이다리~</font><hr>
		</c:if>
		<c:if test="${!empty bList}">
		<tr>
		<td><font color="green">화제글</font></td>
		</tr>
		<table>
		<tr>
		<td>글번호</td><td>글제목 </td><td>작성자</td><td>조회수</td><td>작성일</td><td>글등급</td>
		</tr>
		<c:if test="${bList2!=null}">
		<c:forEach var="board2" items="${bList2}" varStatus="test">
		<c:if test="${gradeValue>= board.boardGrade}">
		<c:if test="${board2.hitcount >=50}">
		<tr>
		<td>${board2.rownum}</td><td><a href="goInnerBoard?boardseq=${board2.boardseq}">${board2.boardtitle}</a></td><td>${board2.id}</td><td>${board2.hitcount}</td><td>${board2.indate}</td>
			<c:if test="${board2.boardGrade==0}">
				<td>찐따</td>
			</c:if>
			<c:if test="${board2.boardGrade==1}">
				<td>아싸</td>
			</c:if>
			<c:if test="${board2.boardGrade==2}">
				<td>셔틀</td>
			</c:if>
			<c:if test="${board2.boardGrade==3}">
				<td>인싸</td>
			</c:if>
			<c:if test="${board2.boardGrade==4}">
				<td>핵인싸</td>
			</c:if>
		</tr>
		</c:if>
		</c:if>
		</c:forEach>
		</c:if>
		</table>
		<hr>
		<table>
		<tr>
		<td>글번호</td><td>글제목 </td><td>작성자</td><td>조회수</td><td>작성일</td><td>글등급</td>
		</tr>
		<c:if test="${bList!=null}">
		<c:forEach var="board" items="${bList}">
		<c:if test="${gradeValue>= board.boardGrade}">
		<tr>
		<td>${board.rownum}</td><td><a href="goInnerBoard?boardseq=${board.boardseq}">${board.boardtitle}</a></td><td>${board.id}</td><td>${board.hitcount}</td><td>${board.indate}</td>
			<c:if test="${board.boardGrade==0}">
				<td>찐따</td>
			</c:if>
			<c:if test="${board.boardGrade==1}">
				<td>아싸</td>
			</c:if>
			<c:if test="${board.boardGrade==2}">
				<td>셔틀</td>
			</c:if>
			<c:if test="${board.boardGrade==3}">
				<td>인싸</td>
			</c:if>
			<c:if test="${board.boardGrade==4}">
				<td>핵인싸</td>
			</c:if>
		</tr>
		</c:if>
		<c:if test="${gradeValue ==null}">
		<c:if test="${board.boardGrade==0}">
		<tr>
		<td>${board.rownum}</td><td><a href="goInnerBoard?boardseq=${board.boardseq}">${board.boardtitle}</a></td><td>${board.id}</td><td>${board.hitcount}</td><td>${board.indate}</td>
			<c:if test="${board.boardGrade==0}">
				<td>찐따</td>
			</c:if>
			<c:if test="${board.boardGrade==1}">
				<td>아싸</td>
			</c:if>
			<c:if test="${board.boardGrade==2}">
				<td>셔틀</td>
			</c:if>
			<c:if test="${board.boardGrade==3}">
				<td>인싸</td>
			</c:if>
			<c:if test="${board.boardGrade==4}">
				<td>핵인싸</td>
			</c:if>
		</tr>
		</c:if>
		</c:if>
		</c:forEach>
		</c:if>
		</table>
		</c:if>
		<a href="javascript:pagingFormSubmit(${navi.currentPage-1})">이전페이지&nbsp;</a>
		<c:forEach begin="${navi.startPageGroup}" end="${navi.endPageGroup}" var="page">
		<c:if test="${navi.currentPage == page}">
		<b><a href="javascript:pagingFormSubmit(${page})">&nbsp;${page}&nbsp;</a></b>
		</c:if>
		<c:if test="${navi.currentPage != page}">
		<a href="javascript:pagingFormSubmit(${page})">&nbsp;${page}&nbsp;</a>	
		</c:if>
		</c:forEach>
		<a href="javascript:pagingFormSubmit(${navi.currentPage+1})">&nbsp;다음페이지</a>
	</div>
	<hr>
	<!-- 검색 code here -->
	<form action="goBoard" id="pagingForm">
		<input type="hidden" name="page" id="page">
		<select name="searchType" id="searchType" >
			<option value="${map.searchType}" selected="selected">
			<c:if test="${map.searchType==null}">선택</c:if>
			<c:if test="${map.searchType!=null}">
			<c:if test="${map.searchType == 'id'}">아이디</c:if>
			<c:if test="${map.searchType == 'boardtitle'}">제목</c:if>
			<c:if test="${map.searchType == 'boardcontent'}">내용</c:if>
			</c:if>
			</option>
			<c:if test="${map.searchType == 'boardtitle'|| map.searchType =='boardcontent' || map.searchType==null}">
            <option value="id">아이디</option>
            </c:if>
            <c:if test="${map.searchType == 'id'|| map.searchType =='boardcontent'|| map.searchType==null}">
            <option value="boardtitle">제목</option>
            </c:if>
            <c:if test="${map.searchType == 'boardtitle'|| map.searchType =='id'|| map.searchType==null}">
            <option value="boardcontent">내용</option>
            </c:if>
        </select>
		검색	<input type="text" name="search" id="search" value="${map.search}">
		<input type="submit" value="검색" onclick="pagingFormSubmit(${navi.currentPage})">
	</form>
	<hr>
	<form action="goWriteForm">
		<input type="submit" value="글쓰기">
	</form>
	</fieldset>
	<font color="red">${warning}</font>
	<a href="/prac">홈으로</a>
</body>
</html>