<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="../css/ex3.css" rel="stylesheet"> -->
<link href="/ch03_semiServlet/css/ex3.css" rel="stylesheet">
<!-- 맨앞에 / 를 붙이면 톰캣이 실행하는 콘테스트 루트로 인식 -->
</head>
<!-- ex/ex3.jsp - > 파라미터를 가지고 Ex3서블릿에 요청 -->
<body>
	<!-- form action="../Ex3"></form -->
	<form action="/ch03_semiServlet/Ex3" method="get">
		<select name="su">
			<option value="2">2단</option>
			<option value="3">3단</option>
			<option value="4">4단</option>
			<option value="5">5단</option>
			<option value="6">6단</option>
			<option value="7" selected="selected">7단</option> <!--  처음실행할때 7단 부터 나오게 쓰  -->
			<option value="8">8단</option>
			<option value="9">9단</option>
		</select>
		<input type="submit" value="구구단 출력">
	</form>
</body>
</html>