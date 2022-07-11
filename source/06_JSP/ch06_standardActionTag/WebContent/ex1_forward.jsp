<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex_forward.jsp?n=1로 요청 
	forward : 현재의 페이지에서 다른 특정페이지로 전환할 때 사용. 
	--> 
	<!--  ? : 전달할 파라미터값 -->
	<h2>ex1_forward.jsp 페이지 입니다</h2>
	<jsp:forward page="ex2_forward.jsp"/>
	
	<!-- sendRedirect 는  파라미터가 전달 안됨 request는 새롭게 만드는거여서 ? -->
	<%--  --%>
	
</body>
</html>
