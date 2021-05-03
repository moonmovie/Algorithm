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
<div class="text-center"><h3>도서관리</h3></div>
<div class="container">
	<form action="${root}/bookregist" method="post">
    <div class="form-group">
      <label for="id">도서번호:</label>
      <input type="text" class="form-control" id="isbn" placeholder="id" name="isbn">
    </div>
    <div class="form-group">
      <label for="name">도서명:</label>
      <input type="text" class="form-control" id="title" placeholder="도서명" name="title">
    </div>
    <div class="form-group">
      <label for="price">가격:</label>
      <input type="text" class="form-control" id="price" placeholder="가격" name="price">
    </div>
    <div class="form-group">
      <label for="author">저자:</label>
      <input type="text" class="form-control" id="author" placeholder="저자" name="author">
    </div>
    <div class="form-group">
      <label for="des">설명:</label>
      <input type="text" class="form-control" id="dcpt" placeholder="설명" name="dcpt">
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
