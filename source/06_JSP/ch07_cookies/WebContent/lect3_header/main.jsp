<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#mainForm_wrap{
			width: 430px; 
			mamrgin : 0 auto;
			height: 620px;
			line-height: 620px; 
			text-align:center;
			font-size:1.5em; 
			font-weight: bold;
			color:red;
		}
		
	</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		content
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>