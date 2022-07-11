<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel ="stylesheet "type="text/css">
</head>
<body>
<%
	String id = null, name = null;
	Cookie[] cs = request.getCookies();
	if(cs!= null){ // null 이면 로그인 안한거야    중요한건 id 쿠키 잇냐  name 쿠키잇냐
		for(int i=0 ; i <cs.length ; i++){// 0번째 부터 cs쿠키 있는지 
			if(cs[i].getName().equals("id")){ //cs[i]네임에 id 가있냐
				id = cs[i].getValue();
			}else if(cs[i].getName().equals("name")){
				name = cs[i].getValue();
			}
		}// for - 로그인을 후 id변수에 로그인한 id가 들어가고 name변수엔 로그인한 name이 할당
		//  로그인 전 : id변수와 name 변수엔 null 값 일꺼야 
	}//if
	
%>
<%if(name!=null){//로그인 후 화면  네임이 널이 아님 %>
 <h1><%=name %>(<%=id %>)님 반갑습니다</h1>
 	<button onclick="location.href='logout.jsp'">로그아웃</button>
 	<button onclick="location.href='cookielist.jsp'">쿠키들 확인</button>
<%}else if(name==null){//로그인 전  네임이 널임%>
	<h1>손님(guest) 반갑습니다. 로그인하세요</h1>
	<button onclick="location.href='login.html'">로그인</button>
	<button onclick="location.href='cookielist.jsp'">쿠키들 확인</button>
<%} %>
</body>
</html>