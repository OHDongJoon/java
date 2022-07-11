<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/cdd">
</head>
<body>
	<h1>ex5_include.jsp 페이지입니다</h1>
	<h2>반갑습니당</h2>
	
	<%-- <%@ include file="includePage.jsp" %> --%> <!-- jsp 파일 원본 그대로 include
	include 왜 에러나 ? jsp파일이 들어가는데 conPath 가 includePage에도 있어서  2개 값이 들어갈수 없다? -->
	    
	 <h1>다시 ex5_include.jsp 페이지입니다</h1>
	 <jsp:include page="includePage.jsp"/> <!-- jsp 파일의 결과를 include -->
	 <h1>다시 ex5_include.jsp 페이지입니다</h1>
</body>
</html>