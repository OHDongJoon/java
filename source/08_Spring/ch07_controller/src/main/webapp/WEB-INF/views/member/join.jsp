<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/uikit@3.15.0/dist/css/uikit.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/uikit@3.15.0/dist/js/uikit.min.js"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h2>
		<span onclick="history.back()">메인페이지로 가기</span>
	</h2>
	<div id="wrap"></div>
	<div class="content"></div>
	<ul class="mystyle" uk-accordion="collapsible: true; multiple:false; 
		animation:true; duration:500; active:true">
		<li><a class="uk-accordion-title" href="#">페이지</a>
			<div class="uk-accordion-content">
				<h2>member의 join.jsp 페이지입니다</h2>
			</div></li>
		<li><a class="uk-accordion-title" href="#">가입페이지</a>
			<div class="uk-accordion-content">
				<h3>${kind }가입페이지</h3>

			</div></li>
		<li><a class="uk-accordion-title" href="#">메인으로가기</a>
			<div class="uk-accordion-content">
				<h2 onclick="history.go(-1);">메인페이지로가기</h2>
				<<%-- h2 onclick="location.href='${conPath}/'">메인페이지로가기</h2> --%>
			</div></li>
	</ul>
</body>
</html>