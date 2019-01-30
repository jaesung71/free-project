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
	<fieldset style="text-align:center;">
	<legend>상품리스트</legend>
	<!-- 상품목록 -->
	<table>
	<tr>
	<td>상품등록번호</td><td>상품명</td><td>수량</td><td>가격</td><td>등록자</<td>등록일</td>
	</tr>
	<c:if test="${pList==null}">
	<font color="red">등록된 상품이 없습니다.</font>
	</c:if>
	<c:if test="${pList!=null}">
	<c:forEach var="product" items="${pList}">
<%-- 	<c:if test="${product.quantity >= 1 }"> --%>
	<tr>
	<td>${product.productseq}</td>
	<td><a href="productdetail?productseq=${product.productseq}&page=${navi.currentPage}">${product.name}</a></td>
	<td>${product.quantity}</td><td>${product.price}</td><td>${product.indate}</td>
	</tr>
<%-- 	</c:if> --%>
	</c:forEach>
	</c:if>
	</table>
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
	<form action="goProductList" id="formSubmit">
		<input type="hidden" name="page" id="page">
		<select name="selectType" id ="selectType">
			<option selected="selected" value="${map.selectType}">
			<c:if test="${map.selectType == null}">선택</c:if>
			<c:if test="${map.selectType!=null}">
			<c:if test="${map.selectType == 'name'}">상품명 검색</c:if>
			<c:if test="${map.selectType == 'price'}">가격대 검색(입력 가격이하)</c:if>			
			</c:if>
			</option>
			<c:if test="${map.selectType == 'price'|| map.selectType==''||map.selectType == null}">
			<option name="name" value="name">상품명 검색</option>
			</c:if>
			<c:if test="${map.selectType == 'name'|| map.selectType==''||map.selectType == null}">
			<option name="price" value="price">가격대 검색(입력 가격이하)</option>
			</c:if>
			
		</select>
		<input type="text" name="select" id="select" value="${map.select}">
		<input type="submit" value="검색" onclick="pagingFormSubmit(${navi.currentPage})"> 
	</form>
	</fieldset>
	<a href="goChome">이전페이지</a>
</body>
</html>