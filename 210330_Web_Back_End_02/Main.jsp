<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String root = request.getContextPath();

	String msg = (String)request.getAttribute("msg");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/71ec13f5ce.js" crossorigin="anonymous"></script>
    <script>
    $(document).ready(function () {
    	
        $('#loginbtn').on("click",()=>{
           if($('#userid').val()!=null && $('#userpwd').val()!=null){
               $('#loginform').attr('action','<%=root%>/main?act=login').submit();
           }
        });
    });
    </script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="mt-5"><i class="fas fa-archive"></i>&nbsp;MAIN PAGE</h2>
		<div class="row mt-5">
			<div class="col">
				<img src="https://cdn.crowdpic.net/list-thumb/thumb_l_6426B489FA5F75B26BD8B24C25B97222.jpg" width="100%" height="200px"/>
			</div>
			<div class="col aling-self-center mt-5">
				<form id="loginform" method="post">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">ID</span>
						</div>
						<input type="text" class="form-control" id="userid" name="userid">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">PW</span>
						</div>
						<input type="password" class="form-control" id="userpwd" name="userpwd">
					</div>
					<span class="err"><%=msg==null?"":msg %></span>
					<button id="loginbtn" type="submit" class="btn btn-primary float-right" style="width: 200px">로그인</button>
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>