<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
    <%int a = 5; %>
    <h2> a : <%=a %></h2>
    <h2>a : ${a }(요건 안 나와요)</h2>
<!--     <form action ="ex3_suPro.jsp"> -->
	<form action="../Ex3">
         누적을 원하는수 <input type="number" min="1" name="su" required="required">
         <input type="submit" value="누적">
    </form>
</body>
</html>