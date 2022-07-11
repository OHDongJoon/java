<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	header {width : 1000px; margin: 0 auto;}
	header #nav ul {overflow: hidden;}
	header #nav ul li{list-style: none; float:right; padding: 10px 30px;}
	header #nav ul li a{
		text-decoration : none;
		font-weight : bold;
		font-size :1.5em;
        color: #A47160;
	}
	</style>
	<link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>
<body>
<header>
		<div id="nav">
	 
		
		 
		
			<ul>
				<li><a href="">로그인전메뉴4</a></li>
				<li><a href="">로그인전메뉴3</a></li>
				<li><a href="">로그인전메뉴2</a></li>
				<li><a href="">로그인전메뉴1</a></li>
			</ul>
		
		
		
			
		
		</div>
	</header>
</body>
</html>