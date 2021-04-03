<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ssafy.product.model.ProductDto"%>
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
    $('#delete_btn').on("click",()=>{
        console.log("aa");
        $('#updatepro').attr('action','${pageContext.request.contextPath}/product?act=delete').submit();
        
     });
     $('#modify_btn').on("click",()=>{
        if($("#id").val()!=null&&$('#name').val()!=null && $('#price').val()!=null && $('#des').val()!=null){
            console.log("bb");
            $('#updatepro').attr('action','${pageContext.request.contextPath}/product?act=modify').submit();
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
					
					<th></th>
					<th></th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Product" items="${requestScope.list}">
					<tr>
						
						<c:choose>
						<c:when test="${userinfo.userId eq Product.adder}">
						<form id="updatepro" name="updatepro" method="post">
						<td><input type="text" id="id" name="id" value ="${Product.id}" readonly/></td>
						<td><input type="text" id="name" name="name" value ="${Product.name}" ></td>
						<td><input type="text" id="price" name="price" value ="${Product.price}" ></td>
						<td><input type="text" id="des" name="des" value ="${Product.des}" ></td>
						<td>${Product.adder}</td>
						<td>
						<button class="btn btn-outline-primary" type="submit" id="modify_btn">수정</button>
						</td>
						<td>
						<button class="btn btn-outline-primary" type="submit" id="delete_btn">삭제</button>
						</td>
						</form>
						</c:when>
						
						<c:when test="${userinfo.userId ne Product.adder}">
						<td>${Product.id}</td>
						<td>${Product.name}</td>
						<td>${Product.price}</td>
						<td>${Product.des}</td>
						<td>${Product.adder}</td>
						</c:when>
						</c:choose>					
						
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
</body>
</html>