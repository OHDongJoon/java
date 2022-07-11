<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
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
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto"/>
	<jsp:setProperty name="dto" property="*" />
	<%
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
			
		}
		MemberDto member = (MemberDto)session.getAttribute("member");
		String sessionPw = null;
		if(member!=null){
			sessionPw = member.getPw(); // 세션의 pw를 sessionPw에 할당
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){ // 현비밀번호를 맞게 입력한 경우 정보 수정 진행
			// 새비밀번호(pw파라미터)가 빈스트링이 들어왔을수도 있어여 그렇죠 ?
			if(dto.getPw()==null){
				dto.setPw(sessionPw);
			}
			MemberDao mDao = MemberDao.getInstance();
			int result = mDao.modifyMember(dto);
			if(result==MemberDao.SUCCESS){ // 수정 성공!~
				session.setAttribute("member", dto); // 수정된 DB내용을 session  속성도수 정 
%>
			<script>
				alert('회원정보 수정이 완료되었습니다');
				location.href = 'main.jsp';
			</script>

	<%		}else{// 수정 땡! 실패 ! 탈락!  %> 		
				<script>
					alert('회원정보 수정  실패 하였습니다 정보가 너무 길어 ');
					location.href = 'modify.jsp';
				</script>
	<% }
		}else{ //현비밀번호를 틀리게 입력한 경우 정보 수정 안함 
	%>		
		<script>
			alert('현비밀번호가 바르지 않습니둥. 확인');
			history.back();
		</script>
	<% 	}%>
	
</body>
</html>