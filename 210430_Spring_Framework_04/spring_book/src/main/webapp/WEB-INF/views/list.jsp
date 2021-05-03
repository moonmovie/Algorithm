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
		<h2>도서목록</h2>
		<p>등록된 도서입니다.</p>
		<table class="table table-striped" id="listtable">
			<thead>
				<tr>
					<th>번호</th>
					<th>도서번호</th>
					<th>제목</th>
					<th>저자</th>
					<th>가격</th>
					<th>설명</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty books }">
					<c:forEach items="${books }" var="book" varStatus="vs">
					<%-- location.href='${root}/revisebook?isbn='${book.isbn } --%>
						<tr onclick="location.href='${root}/revisebook?isbn=${book.isbn }'">
							<td>${vs.count }</td>
							<td>${book.isbn }</td>
							<td>${book.title }</td>
							<td>${book.author }</td>
							<td>${book.price }</td>
							<td>${book.dcpt }</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty books }">
					<tr>
						<td>항목이 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		 <button type="button" id="list_btn" class="btn btn-primary">상품등록하기</button>
	</div>
	<nav aria-label="...">
  		<ul class="pagination">
		   <!--  <li class="page-item disabled">
		      <span class="page-link">Previous</span>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item active">
		      <span class="page-link">
		        2
		        <span class="sr-only">(current)</span>
		      </span>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">Next</a>
		    </li> -->
	  </ul>
	</nav>
</body>
<script>
	$("#list_btn").on("click",()=>{
		location.href="${root}/regist"
	});
</script>
</html>