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
	function updateSubmit(currentPage){
		var form = document.getElementById("updateForm");
		var page = document.getElementById("page");
		var quantity = document.getElementById("quantity");
		var productseq = document.getElementById("productseq");
		page.value= currentPage;
		form.submit();
	}
</script>
</head>
<body>
	<fieldset style="text-align:center;width:100%;">
	<legend>상품관리 페이지</legend>
	<!-- 상품목록 -->
	<table>
	<tr>
	<td>상품등록번호</td><td>상품명</td><td>수량</td><td>가격</td><td>등록일</td>
	</tr>
	<c:if test="${pList==null}">
	<font color="red">등록된 상품이 없습니다.</font>
	</c:if>
	<c:if test="${pList!=null}">
	<c:forEach var="product" items="${pList}">
	<tr>
	<td>${product.productseq}</td>
	<td><a href="goQuantityUpdate?productseq=${product.productseq}
	&page=${navi.currentPage}&selectType=${map.selectType}&select=${map.select}">${product.name}</a></td>
	<td>
	<c:if test="${sessionScope.quantityUpdate!=null && sessionScope.productseqs == product.productseq}">
	<form action="qutityUpdate" id="updateForm">
	<input type="number" min="0" max="500"name="quantity" id="quantity">
	<input type="hidden" name="page" id="page">
	<input type="hidden" name="productseq" value="${product.productseq}" id="productseq">
	<input type="hidden" name="selectType"id="selectType" value="${map.selectType}">
	<input type="hidden" name="select"id="select" value="${map.select}">
	<input type="submit" value="수량수정" onclick="updateSubmit(${navi.currentPage})">
	</form>
	</c:if>
	<c:if test="${sessionScope.quantityUpdate==null || sessionScope.productseqs != product.productseq}">
	${product.quantity}
	</c:if>
	</td>
	
	<td>${product.price}</td><td>${product.indate}</td>
	</tr>
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
	<form action="goProductManagement" id="formSubmit">
		<input type="hidden" name="page" id="page">
		<select name="selectType" id ="selectType">
			<option selected="selected" value="${map.selectType}">
			<c:if test="${map.selectType == null}">선택</c:if>
			<c:if test="${map.selectType!=null}">
			<c:if test="${map.selectType == 'name'}">상품명 검색</c:if>
			<c:if test="${map.selectType == 'price'}">가격대 검색(입력 가격이하)</c:if>			
			</c:if>
			</option>
			<c:if test="${map.selectType == 'price'|| map.selectType==''||map.selectType==null}">
			<option name="name" value="name">상품명 검색</option>
			</c:if>
			<c:if test="${map.selectType == 'name'|| map.selectType==''||map.selectType==null}">
			<option name="price" value="price">가격대 검색(입력 가격이하)</option>
			</c:if>
		</select>
		<input type="text" name="select" id="select" value="${map.select}">
		<input type="submit" value="검색" onclick="pagingFormSubmit(${navi.currentPage})"> 
	</form>
	<hr>
	<font color="red">${warning}</font>
	<font color="green">${complete}</font>
	<form action="goRegistProductForm">
		<input type="submit" value="상품등록">
	</form>
	
	</fieldset>
	<a href="goAhome">메인으로</a>
</body>
</html>