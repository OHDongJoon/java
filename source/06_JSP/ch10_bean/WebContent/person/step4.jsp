<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 프로세스단 -->
<jsp:useBean class="com.lec.ex.Person" id="p" scope="request"/>
	<jsp:setProperty name="p" property="name" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty name="p" property="age" value="<%=Integer.parseInt(request.getParameter(\"age\")) %>" />
	<!-- 				객체이름 p      p의 gender  -->
	<jsp:setProperty name="p" property="gender" value='<%=request.getParameter("gender").charAt(0) %>' />
	<jsp:setProperty name="p" property="address" value='<%=request.getParameter("address") %>' />
	
	<jsp:forward page="pView.jsp"/>
</body>
</html>