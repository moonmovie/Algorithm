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
		<button type="button" id="list_btn" class="btn btn-primary">상품등록</button>
	</div>
	<div class="container mt-5" id="product" style="display:none;">
		
		<button type="button" id="update_btn" class="btn btn-primary" style="display:none;">상품수정</button>
		<button type="button" id="delete_btn" class="btn btn-primary" style="display:none;">상품삭제</button>
	</div>
</body>
</html>