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
	<form action="ex02_scope.jsp">
	   <p>이름<input type="text" name="name"></p>
	   <p>ID<input type="text" name="id"></p>
	   <p><input type="submit"></p>
	</form>
	<%
	   pageContext.setAttribute("pageName", "pageValue"); // 페이지를 벗어나면 없어지는 속성
	   request.setAttribute("requestName", "requestValue"); // 새로은 request객체를 생성하면 없어지는
	   session.setAttribute("sessionName", "sessionValue"); // 브라우저를 닫으면 없어지는 
	   application.setAttribute("applicationName", "applicationValue"); // 톰캣 재실행하면 없어지는 
		//forward 할 객체 (dispatcher)
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=kim&id=aaa");
	    dispatcher.forward(request, response);
	   %>
<%-- 	<jsp:forward page="ex02_scope.jsp"/> <!-- 위에 set 추가 한다음   --> --%>
	<h3>페이지내 속성변수 값 		: <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 속성변수 값 	: <%=request.getAttribute("requestName") %></h3>
	<h3>session 속성변수 값	: <%=session.getAttribute("sessionName") %></h3>
	<h3>application 속성변수 값 : <%=application.getAttribute("applicationName") %></h3>
	<hr>
	<h3>페이지내 속성변수 값	     : ${pageScope.pageName }</h3>
	<h3>request 속성변수 값 	 : ${requestScope.requestName }</h3>
	<h3>session 속성변수 값 	 : ${sessionScope.sessionName }</h3>
	<h3>application 속성변수 값  : ${applicationScope.applicationName }</h3>
	<hr>
	<h3>페이지내 속성변수 값	     : ${pageName }</h3>
	<h3>request 속성변수 값 	 : ${requestName }</h3>
	<h3>session 속성변수 값 	 : ${sessionName }</h3>
	<h3>application 속성변수 값  : ${applicationName }</h3>	
</body>
</html>