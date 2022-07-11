<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
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
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setCbirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		}
		
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer!=null){
			sessionPw = customer.getCpw(); // 세션의 pw를 sessionPw에 할당
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){ // 현비밀번호를 맞게 입력한 경우 정보 수정 진행
			// 새비밀번호(pw파라미터)가 null로 입력되지 않을 경우 현비밀번호로 수정
			if(dto.getCpw()==null){
				dto.setCpw(sessionPw);
			}
			System.out.println("수정전 :"+dto);
			CustomerDao cDao = CustomerDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result==CustomerDao.SUCCESS){ // 수정성공
				session.setAttribute("customer", dto); // 수정된 DB내용을 session 속성도 수정
%>				
				<script>
					alert('회원정보 수정이 완료되었습니다');
					location.href = 'main.jsp';
				</script>				
<%		}else{ // 수정실패%>
				<script>
					alert('회원정보 수정이 실패되었습니다. 정보가 너무 깁니다');
					location.href = 'modify.jsp';
				</script>	
<%		}
		}else{ // 현비밀번호를 틀리게 입력한 경우 정보 수정 안 함
%>		
			<script>
				alert('현비밀번호가 바르지 않습니다. 확인하세요');
				history.back();
			</script>	
<%	}%>
</body>
</html>