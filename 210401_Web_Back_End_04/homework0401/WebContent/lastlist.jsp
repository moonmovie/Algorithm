<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.product.model.ProductDto,com.ssafy.product.model.UsersDto"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>등록된 상품</h2>
  <p>${sessionScope.userinfo.userName} 님이 등록한 마지막 상품목록입니다.</p>            
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
      <tr>
        <td>${requestScope.lastlist.id}</td>
        <td>${requestScope.lastlist.name}</td>
        <td>${requestScope.lastlist.price}</td>
        <td>${requestScope.lastlist.des}</td>
        <td>${requestScope.lastlist.adder}</td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>