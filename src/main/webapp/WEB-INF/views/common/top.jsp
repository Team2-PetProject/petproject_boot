<%@page import="com.example.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 
<style type="text/css">
	  .title{
		float: left;
	} 
	.right-box{
		 float: right;
	} 
	
	a{
		text-decoration: none;
	}
	/*  .header-container{
		display: flex;
		justify-content: space-between;
		align-items: center;
		 height: 10rem; 
	}  */
</style>
	<div class="inner">
		<div class="hearder-container">
			  <!-- <div class="title"> -->
				<a href="#"><img><b class= "title">Kkosunnae</b></a>
			 <!-- </div>  -->
			<!-- title -->
			
			<div class="right-box">
				<a href="loginForm">로그인</a>
				<button>채팅</button>&nbsp;
				<button>알림</button>&nbsp;
				<%
					MemberDTO dto = (MemberDTO) session.getAttribute("login");
					if(dto == null){
				%>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false">회원</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="login">로그인</a></li>
						<li><a class="dropdown-item" href="MemberUIServlet">회원가입</a></li>
					</ul>
				</div>
				<%
					} else{
				%>
			
					<div class="btn-group" role="group">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false">회원</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="LogoutServlet">로그아웃</a></li>
						<li><a class="dropdown-item" href="CartListServlet">장바구니</a></li>
					</ul>
				</div>	
				<% 
					}
				%>
			</div>
			
		</div>
		<!-- header-container -->
	</div>
   

