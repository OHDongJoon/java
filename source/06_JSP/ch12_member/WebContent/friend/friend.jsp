<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
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
<script>
function search(){
	var name = frm.name.value;
	var tel =frm.tel.value;
	location.href = 'friend.jsp?name='+name+'&tel='+tel;
}

</script>
<body>
<%
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
%>
	<form action="friendOk.jsp" method="post" name="frm">
	<table>
	<tr>
		<th>친구이름</th>
			<td><input type="text" name ="name"></td>
		<th>전화</th>
			<td><input type="text" name="tel"></td>
		<td colspan="3">
		<input type="button" value="검색" onclick="search()">
		<input type="submit" value="추가">
		</td>
	</tr>
	<tr>
		<td colspan="5">
<%
	FriendDao Dao = FriendDao.getInstance();
	ArrayList<FriendDto> friends = Dao.selectSearchFriend(name, tel);
	if(!friends.isEmpty()){
		for(FriendDto f : friends){
			out.println("<h3>번호:"+f.getNo()+",이름 :" +f.getName() + ",번호 :" + f.getTel()+"</h3><br>"); 
			
		}
	}
%>
		
		</td>
	</tr>
	</table>
	</form>


</body>
</html>