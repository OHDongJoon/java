<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h3>cnt : ${cnt }</h3>
	<form action="${conPath }/quizForm.do" method="post">
	<table>
		<tr>
		  <th>이름</th>
		  <td><input type="text" name="name"></td>
		 </tr>
		 <tr>
		   <th>국어</th>
		   <td><input type="number" name="kor"></td>
		   </tr>
		 <tr>
		   <th>영어</th>
		     <td><input type="number" name="eng"></td>
		   </tr>
		  <tr>
		    <th>수학</th>
		      <td><input type="number" name="mat"></td>
		   </tr>
		  <tr>
		      <td><input type="submit" value="입력"></td>
		   </tr>
	</table>
	</form>
	<h4>${nameError }</h4>
	<h4>${korError }</h4>
	<h4>${engError }</h4>
	<h4>${matError }</h4>
</body>
</html>