<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="dto.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
$(document).ready(function () {
	
    $('#search_btn').on("click",()=>{
       if($('#search_ip').val()!=null){
           $('#search_fm').attr('action', '${pageContext.request.contextPath}/product?act=search').submit();
       }
    });
});

</script>
</head>
<body>
	<div class="container">
		<h2>등록된 상품</h2>
		<p>관리자들이 등록한 상품목록입니다.</p>

		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<form class="form-inline" id="search_fm" method="post">
				<select class="form-control" id="sel1" name="sel1">
					<option>상품명</option>
					<option>가격이하</option>
				</select> 
				<input class="form-control mr-sm-2" type="text"
					placeholder="Search" id="search_ip" name="search_ip">
				<button class="btn btn-success" id="search_btn" type="submit">찾기</button>
			</form>
		</nav>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>가격</th>
					<th>상품 설명</th>
					<th>상품 등록자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Product" items="${requestScope.list}">
					<tr>
						<td>${Product.id}</td>
						<td>${Product.name}</td>
						<td>${Product.price}</td>
						<td>${Product.des}</td>
						<td>${Product.adder}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
</body>
</html>