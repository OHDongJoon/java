<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<%@ page session="false"%>
<html>
<head>


<title>Title</title>
 
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/uikit.min.css" />
        <script src="js/uikit.min.js"></script>
        <script src="js/uikit-icons.min.js"></script>
<meta charset="utf-8">


<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>

	<h1>${greeting }</h1>
	<p>The time on the server is ${serverTime}.</p>
	<p>2022년 07월 14일</p>
	<p><img src="${conPath }/img/hot.gif" alt="text"></p>
<ul uk-accordion =duration:500;>
    <li>
        <a class="uk-accordion-title" href="#"></a>
        <div class="uk-accordion-content"></div>
    </li>
</ul> 

</body>
</html>

