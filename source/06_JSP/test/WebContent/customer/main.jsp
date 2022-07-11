<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
#main_form{
	margin : 0 auto;
	width: 1000px;
	height: 500px;
	border: 1px solid gray;
}
#main_form h2{
	text-align: center;
	line-height: 500px;
	font-size: 3em;
}

</style>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<!-- customer  -->
<jsp:include page="header.jsp"></jsp:include>
	<div id=main_form>
		<h2>main 화면</h2>
	</div>
<jsp:include page="footer.jsp"/>


</body>
</html>