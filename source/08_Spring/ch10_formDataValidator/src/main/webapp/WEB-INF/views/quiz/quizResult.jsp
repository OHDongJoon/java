<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h3>현재 총  : ${cnt } 명</h3>
	<h4>이름 : ${quiz.name }</h4>
	<h4>국어 : ${quiz.kor }</h4>
	<h4>영어 : ${quiz.eng }</h4>
	<h4>수학 : ${quiz.mat }</h4>
	<h4>총점 : ${sum }</h4>
	<h4>평균 : <fmt:formatNumber value="${avg }" pattern="#,###.00" /></h4>
	
	
	<button onclick="history.back()">아전</button>
	<button onclick="location.href='${conPath }/quizForm.do'">다시</button>
</body>
</html>