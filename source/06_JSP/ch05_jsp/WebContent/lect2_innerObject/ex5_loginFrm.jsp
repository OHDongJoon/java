<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		td{text-align: center;padding:5px;}
		#msg {color:red; text-align: center;}  /*msg 잘못쳤을때 빨간 글 뜨게 */
	</style>
</head>
<body>
	<form action="ex5_loginCertification.jsp">
		<table>
			<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><td colspan="2"><input type="submit" value="로그인"></td></tr>
					
			</table>
	</form>
	<div id="msg">
	<%
		String msg = request.getParameter("msg");
		 if(msg != null){  // msg가 널이 아니면
			 out.print(msg);
		 }
	%>
	</div>
</body>
</html>