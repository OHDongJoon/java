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
<%!String cid, cname, ctel , cgender, cemail, caddress; Timestamp cbirth; %>
<%
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	if(customer==null){
		response.sendRedirect("login.jsp");
	}else{
		cid = customer.getCid();
		cname = customer.getCname();
		ctel = customer.getCtel();
		cgender = customer.getCgender();
		cemail = customer.getCemail();
		caddress = customer.getCaddress();
		cbirth = customer.getCbirth();
	}

%>
<form action="modifyOk.jsp" method="post" name="modify_frm" onsubmit="return infoConfirm()">
		<table>
			<caption>정보수정</caption>
			<tr><th>아이디</th>
					<td><input type="text" name="cid" value="<%=cid%>" readonly="readonly"></td>
			</tr>
			<tr><th>현비밀번호</th>
					<td><input type="password" name="oldPw" required="required"></td>
			</tr>
			<tr><th>새비밀번호</th>
					<td><input type="password" name="cpw" placeholder="비밀번호 수정이 싫으면 입력 안해도 돼"></td>
			</tr>
			<tr><th>새비밀번호</th>
					<td><input type="password" name="pwChk"></td>
			</tr>
			<tr><th>이름</th>
					<td><input type="text" name="cname" value="<%=cname %>" required="required"></td>
			</tr>
			<tr><th>전화번호</th>
				<td><input type="text" name="ctel" value="<%=ctel %>"></td>
			</tr>
			<tr><th>이메일</th>
					<td><input type="email" name="cemail" value='<%=cemail==null? "":cemail %>'></td>
			</tr>
			<tr><th>생일</th>
					<td><input type="date" name="tempbirth" value='<%=cbirth==null? "":cbirth.toString().substring(0,10)%>'></td>
			</tr>
			<tr><th>주소</th>
					<td><input type="text" name="caddress" value='<%=caddress==null? "":caddress %>'></td>
			</tr>
			<tr>
				<th>성별</th>
					<td>
						<%if("m".equals(cgender)){ %>
							<input type="radio" name="cgender" value="m" checked="checked">남
							<input type="radio" name="cgender" value="f">여
						<%}else if("f".equals(cgender)){ %>
						<input type="radio" name="cgender" value="m" >남
						<input type="radio" name="cgender" value="f"checked="checked">여
						<%}else{ %>
							<input type="radio" name="cgender" value="m">남
							<input type="radio" name="cgender" value="f">여
						<%} %>
					</td>
				</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="정보수정">
					<input type="reset" value="취소" onclick="history.back()">
					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
				</td>
			</tr>
		</table>
		</form>
</body>
</html>