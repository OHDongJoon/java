<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); 
	if(session.getAttribute("name")!=null){
		response.sendRedirect("main.jsp");
	}
	String msg = request.getParameter("msg");
%>
<%if (msg!=null){ %>
	<script>
	alert('<%=msg%>');
	</script>
	<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id = "loginForm_wrap">
	<form action="loginPro.jsp" method="post">
	<table>
		<tr><td></td></tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" required="required" autofocus="autofocus"
				value="<%
					String id =(String)session.getAttribute("id");
					if(id != null){
						out.print(id);
					}
				%>">
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" required="required"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="로그인" class="loginBtn_style"></td>
		</tr>
		<tr>
			<td colspan="2">
			<%
				String msg2 = request.getParameter("msg");
				if(msg2 != null){
					%>
					<p id="login_findIdPw" onclick="alert('아이디는 aaa/pw는111');">
							아이디와 비밀번호를 확인하세요
						</p>
				<% 
				}
				%>
				</td>			
		</tr>
	</table>
		<p id="login_join">아직 회원이 아니신가요?<a href="<%=conPath%>/member/join.jsp" >회원가입</a>
	</form>
	</div>
		<jsp:include page="footer.jsp"/>
</body>
</html>