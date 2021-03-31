<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="dto.Users"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	int msg=-1;
	String root = request.getContextPath();
	
	Users user = (Users) session.getAttribute("userinfo");
	
	if(request.getAttribute("msg")!=null){
		msg=(int)request.getAttribute("msg");
	}
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product</title>
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
    		if(${requestScope.msg}==0){
    			alert("저장되었습니다");
    		}else{
    			alert("저장되지않았습니다");
    		}
        $('#submit').on("click",()=>{
           if($('#name').val()!=null && $('#price').val()!=null && $('#info').val()!=null){
               $('#productIn').attr('action','${pageContext.request.contextPath}/product?act=productin').submit();
           }
        });
    });
</script>
</head>

<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand">${sessionScope.userinfo.userName}</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">MYPAGE</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/main?act=logout">LOGOUT</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product?act=productlist">PRODUCT
						LIST</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product?act=lastlist">ADDED
						LIST LAST</a></li>
			</ul>
		</div>
	</nav>
	<div class="container mt-5">
		<form id="productIn" name="productIn" method="post" >
			<div class="form-group">
				<label for="name">상품번호:</label> <input type="text"
					class="form-control" placeholder="상품명 입력" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="name">상품명:</label> <input type="text"
					class="form-control" placeholder="상품명 입력" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="price">상품 가격:</label> <input type="text"
					class="form-control" placeholder="상품가격" id="price" name="price">
			</div>
			<div class="form-group">
				<label for="info">상품 설명:</label> <input type="text"
					class="form-control" placeholder="상품설명" id="info" name="info">
			</div>
			<button type="submit" id="submit" class="btn btn-primary">전송</button>
			<button type="reset" class="btn btn-primary">취소</button>
		</form>
	</div>


</body>
</html>