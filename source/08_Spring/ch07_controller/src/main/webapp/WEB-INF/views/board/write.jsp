<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.15.0/dist/css/uikit.min.css" />
  <script src="https://cdn.jsdelivr.net/npm/uikit@3.15.0/dist/js/uikit.min.js"></script>
    <link rel="stylesheet" href="style.css">
</head>
<body>
	
	<hr>
	<h2><span onclick="history.back()">메인페이지로 가기</span></h2>
	<div id="wrap"></div>
    <div class="content"></div>
        <ul class="mystyle" uk-accordion="collapsible: 
        true; multiple:false; animation:true; duration:500; active:true">
            <li >
                <a class="uk-accordion-title" href="#">Item 1</a>
                <div class="uk-accordion-content">
		<h2>board의 write.jsp페이지 입니다</h2>               
		 </div>
            </li>
            <li>
                <a class="uk-accordion-title" href="#">Item 2</a>
                <div class="uk-accordion-content">
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor reprehenderit.</p>
                </div>
            </li>
            <li>
                <a class="uk-accordion-title" href="#">Item 3</a>
                <div class="uk-accordion-content">
                    <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat proident.</p>
                </div>
            </li>
        </ul>
	
</body>
</html>