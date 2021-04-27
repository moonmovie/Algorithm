<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="include/head.jsp"%>
</head>
<body>
	<%@include file="include/header.jsp"%>

	<div class="container">
		<h2>상품목록</h2>
		<p>등록된 상품입니다.</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>상품번호</th>
					<th>상품명</th>
					<th>가격</th>
					<th>설명</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty products }">
					<c:forEach items="${products }" var="pd" varStatus="vs">
						<tr>
							<td>${vs.count }</td>
							<td>${pd.id }</td>
							<td>${pd.name }</td>
							<td>${pd.price }</td>
							<td>${pd.description }</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty products }">
					<tr>
						<td>항목이 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		 <button type="button" id="list_btn" class="btn btn-primary">상품등록하기</button>
	</div>
</body>
<script>
	$("#list_btn").on("click",()=>{
		location.href="${root}/"
	});
</script>
</html>