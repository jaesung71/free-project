<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 페이지</title>
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
<script>
	function pagingFormSubmit(currentPage){
		var form = document.getElementById("formSubmit");
		var page = document.getElementById("page");
		var selectType = document.getElementById("selectType");
		var select = document.getElementById("select");

		page.value = currentPage;
		form.submit();
	}
</script>
</head>
<body>
	<fieldset style="text-align:center;width:100%;">
	<legend>회원관리 페이지</legend>
	<!-- 회원목록 -->
	<table>
	<c:if test="${cList==null}">
		<font color="red">등록된 고객이 없습니다.</font>
	</c:if>
	<c:if test="${cList !=null}">
	<tr>
	<td>고객아이디</td><td>고객이름</td><td>고객전화번호</td><td>고객생일</td><td>고객주소</td><td>가입일</td>
	</tr>
	<c:forEach var="customer" items="${cList}">
	<tr>
	<td>${customer.customerid}</td><td>${customer.name}</td><td>${customer.phone}</td><td>${customer.birthdate}</td><td>${customer.address}</td><td>${customer.indate}</td>
	</tr>
	</c:forEach>
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
	<form action="goCustomerManagement" id="formSubmit">
	<input type="hidden" name="page" id="page">
		<select name="selectType" id ="selectType">
			<option selected="selected" value="${map.selectType}">
			<c:if test="${map.selectType == null}">선택</c:if>
			<c:if test="${map.selectType!=null}">
			<c:if test="${map.selectType == 'customerid'}">아이디 검색</c:if>
			<c:if test="${map.selectType == 'name'}">고객이름 검색</c:if>			
			</c:if>
			</option>
			<c:if test="${map.selectType == 'name'||map.selectType==''||map.selectType==null}">
			<option name="customerid" value="customerid">아이디 검색</option>
			</c:if>
			<c:if test="${map.selectType == 'customerid'||map.selectType==''||map.selectType==null}">
			<option name="name" value="name">고객이름 검색</option>
			</c:if>
			
		</select>
		<input type="text" name="select" id="select" value="${map.select}">
		<input type="submit" value="검색" onclick="pagingFormSubmit(${navi.currentPage})"> 
	</select>
	</form>	
	</fieldset>
	<a href="goAhome">메인으로</a>
</body>
</html>