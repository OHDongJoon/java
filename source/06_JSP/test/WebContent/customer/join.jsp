<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<script src="<%=conPath %>/js/join.js"></script>
</head>
<body>
<!-- customer -->
<form action="joinOk.jsp" method="post" name="join_frm">
	<table>
	<caption>회원가입</caption>
	<tr>
		<th>아이디</th>
		<td><input type="text" name= "cid" required="required"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="cpw" required="required"></td>
	</tr>
	<tr>
		<th>확인비밀번호</th>
		<td><input type="password" name="pwChk"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="cname" required="required"></td>
	</tr>
	<tr>
		<th>전화</th>
		<td><input type="number" name="ctel" required="required"></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" name="cemail"></td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name ="caddress"></td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td><input type="date" name="tempbirth" ></td>
	</tr>
	<tr>
		<th>성별</th>
	<td>
		<input type="radio" name="gender" value="m">남
		<input type="radio" name="gender" value="f">여
	</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="회원가입" onclick="infoConfirm()">
			<input type="reset" value="다시하기" >
			<input type="button" value="로그인" onclick="location.href='login.jsp'"></td>
	</tr>
	</table>
</form>
</body>
</html>