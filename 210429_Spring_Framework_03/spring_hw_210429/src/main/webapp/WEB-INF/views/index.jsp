<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<c:set var="root" value ="${pageContext.request.contextPath}"></c:set> 
<html>
<head>
	<title>Home</title>
	<%@include file="include/head.jsp" %>
</head>
<body>
<%@include file="include/header.jsp" %>
<div class="text-center"><h3>상품관리</h3></div>
<div class="container">
	<form action="${root}/regist" method="post">
    <div class="form-group">
      <label for="id">상품번호:</label>
      <input type="text" class="form-control" id="id" placeholder="id" name="id">
    </div>
    <div class="form-group">
      <label for="name">상품명:</label>
      <input type="text" class="form-control" id="name" placeholder="상품명" name="name">
    </div>
    <div class="form-group">
      <label for="price">가격:</label>
      <input type="text" class="form-control" id="price" placeholder="가격" name="price">
    </div>
    <div class="form-group">
      <label for="des">설명:</label>
      <input type="text" class="form-control" id="description" placeholder="설명" name="description">
    </div>
    <button type="submit" class="btn btn-primary">제출</button>
  </form>
  	
    <button type="button" id="list_btn" class="btn btn-primary">목록보기</button>
</div>
</body>
<script>
	$("#list_btn").on("click",()=>{
		location.href="${root}/list"
	});
</script>
</html>
