<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	if(session.getAttribute("member")!=null){ // 로그인 상태
		response.sendRedirect("main.jsp");
	}
%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<form action="loginOk.jsp" method="post">
		<table>
			<caption>로그인</caption>
			<tr><th>아이디</th>
				<td><input type="text" name="cid" required="required"
						value="<%
									String cid=(String)session.getAttribute("cid");
									out.print(cid!=null ? cid : "");
									
						%>">
			<tr><th>비밀번호</th><td><input type="password" name="cpw" required="required"></td></tr>
		<tr><td colspan="2">
						<input type="submit" value="로그인">
						<input type="button" value="회원가입" onclick="location.href='join.jsp'">
			</td></tr>
			
		</table>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>