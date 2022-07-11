
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>
<body> <%-- gnb(로그인전/ 로그인후) - .logo - .lnb(도서보기, 도서등록(로그인후) --%>
 <header>
 	<div class="gnb">
 	
 	<!-- 로그인 전 메뉴(우측부터) : 고객센터, 회원가입, 로그인 -->
 	<ul>
 		<li><a href="">고객센터</a></li>
 		<li><a href="">회원가입</a></li>
 		<li><a href="">로그인</a></li>
 	</ul>
 	
 	
 	
 	</div>
 	<div class="logo" onclick="location.href='<%=conPath%>/main/main.jsp'">
 		logo
 	</div>
 	<div class="lnb">
 		<!-- 우측부터 메뉴 : 도서보기, 도서등록(로그인후) -->
 		<ul>
 			<li><a href="">도서보기</a></li>
 			
 		</ul>
 	</div>
 </header>
</body>
</html>