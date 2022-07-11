<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
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
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto"/>
	<jsp:setProperty name="dto" property="*" />
<%
	String tempbirth = request.getParameter("tempbirth");
	dto.setCbirth(Date.valueOf(tempbirth));
	String oldPw = request.getParameter("oldPw"); //현비번 받아오기
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	String sessionPw = null; //sessionPw 초기값 
	if(customer != null){  // 커스터머가 널이 아니면 
		sessionPw = customer.getCpw(); //sessionPw 에 겟 cpw
	}
	//새 비번 수정 하지 않을 때 (pw가 null 이 들어옴)
	if(dto.getCpw()==null){ // 비번 수정 안해서
		
		dto.setCpw(sessionPw);
	}
	if(oldPw.equals(sessionPw)){//현 비번 맞게 입력해서 수정 진행
		CustomerDao mDao = CustomerDao.getInstance();
		int result = mDao.updateCustomer(dto);
		if(result == CustomerDao.SUCCESS){
		session.setAttribute("customer", dto);
%>
<script>
			            alert('회원정보 수정이 완료되었습니다');
			          location.href = '<%=conPath%>/main/main.jsp';
					</script>
<%			}else{%>
					<script>
						alert('회원정보 수정이 실패되었습니다. 정보가 너무 깁니다');
						location.href = 'modifyForm.jsp';
					</script>
<%			}
		}else{ // 현비밀번호를 틀리게 입력한 경우 뭐가 카고 돌려보냄
%>
			<script>
				alert('현비밀번호가 바르지 않습니다. 확인하세요');
				history.back();
			</script>			
<%	}%>	
		
	}
	}


	
</body>
</html>