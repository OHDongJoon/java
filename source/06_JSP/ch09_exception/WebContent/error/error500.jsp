<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<%@ page isErrorPage="true" %> <!--  exception 내부 객체를 사용하기 위함 -->
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>공사중입니다. 빠른 시일내로 복구해라마씸.</h2>
	<h2>관리자에게문의합서 : kok3443@naver.com</h2>
	<%
	System.out.println(exception.getMessage());
	System.out.println(exception.getClass().getName());
	%>
</body>
</html>