<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>td{padding : 10px;}</style>
</head>
<body>
	<%
	// 불러오면 무조건 스트링 으로 받아와서 integer.parseInt 쓰자
	int su1 = Integer.parseInt(request.getParameter("su1"));
	int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h3><%=su1 %>단부터<%=su2%>단까지 구구단 출력</h3>
	<table>
	<%for(int i =1 ; i <= 9 ; i++) {%>
	<tr>
      <%for(int j=su1 ; j<=su2 ; j++){ %>
      	<td> <%=j %> * <%=i %> = <%=i*j %> </td>
      <%} %>
	</tr>
	<%} %>
	</table>
	<button onclick="history.go(-1);">뒤로가기</button>
	<button onclick="location.href='ex6_su2Input.jsp'">새로하기</button>
</body>
</html>