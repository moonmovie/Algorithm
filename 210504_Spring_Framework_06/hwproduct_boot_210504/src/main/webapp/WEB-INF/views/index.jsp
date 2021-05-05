<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<c:set var="root" value ="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="include/head.jsp" %>
</head>
<body>
<%@include file="include/header.jsp" %>

	<div class="container">
		<h2>물품목록</h2>
		<p>등록된 물품입니다.</p>
		<table class="table table-striped" id="listtable">
			
		</table>
		<div class="d-flex justify-content-center">
			<ul class="pagination">
			</ul>
		</div>
		<button type="button" id="list_btn" class="btn btn-primary">상품등록</button>
		
	</div>
	<div class="container" id="product">

	</div>
</body>
</html>