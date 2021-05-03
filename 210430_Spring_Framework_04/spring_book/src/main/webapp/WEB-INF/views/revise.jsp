<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="include/head.jsp"%>
</head>
<body>
	<%@include file="include/header.jsp"%>

	<div class="container">
		<form id="bookform" method="post">
		    <div class="form-group">
		      <label for="id">도서번호:</label>
		      <input type="text" class="form-control" id="isbn" value=${book.isbn } name="isbn" readonly>
		    </div>
		    <div class="form-group">
		      <label for="name">도서명:</label>
		      <input type="text" class="form-control" id="title" value="${book.title }" name="title">
		    </div>
		    <div class="form-group">
		      <label for="price">가격:</label>
		      <input type="text" class="form-control" id="price" value="${book.price }" name="price">
		    </div>
		    <div class="form-group">
		      <label for="author">저자:</label>
		      <input type="text" class="form-control" id="author" value="${book.author }" name="author">
		    </div>
		    <div class="form-group">
		      <label for="des">설명:</label>
		      <input type="text" class="form-control" id="dcpt" value="${book.dcpt }" name="dcpt">
		    </div>
		    <button type="submit" id="revise_btn" class="btn btn-primary">수정</button>
		    <button type="submit" id="delete_btn" class="btn btn-primary">삭제</button>
	   </form>
  	
	</div>
</body>
<script>
	$("#revise_btn").on("click",()=>{
		$("#bookform").attr("action","${root}/revise").submit();
	});
	$("#delete_btn").on("click",()=>{
		location.href="${root}/delete";
		$("#bookform").attr("action","${root}/delete").submit();;
	});
</script>
</html>