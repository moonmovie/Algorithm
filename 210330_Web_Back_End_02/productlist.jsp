<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.Product"%>
<%

ArrayList<Product> list = (ArrayList) request.getAttribute("list");
 
 %>
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
  <p>관리자들이 등록한 상품목록입니다.</p>            
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
    <%
    	for(Product p : list){
    %>
      <tr>
        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td><%=p.getDes()%></td>
        <td><%=p.getAdder()%></td>
      </tr>
      
      <%
      } 
      %>
    </tbody>
  </table>
</div>
</body>
</html>