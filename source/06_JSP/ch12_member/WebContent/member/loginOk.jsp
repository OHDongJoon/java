<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.loginCheck(id,pw);
	if(result == MemberDao.LOGIN_SUCCESS){//로그인성공
		MemberDto member = mDao.getMember(id);
		session.setAttribute("member", member);
		response.sendRedirect("main.jsp");
	}else if(result == MemberDao.LOGIN_FAIL_PW){// 비번 오류
		%>
		<script>
			alert('비번 확인하세요');
			history.back();
		</script>
	<% }else{ %>// 아디 오류
		<script>
			alert('존재하지 않는 아이디입니다')
			history.go(-1);
		</script>
	<% }%>

</body>
</html>