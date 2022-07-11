<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#main_form{
	margin : 0 auto;
	width: 1000px;
	height: 500px;
	border: 1px solid gray;
}
#main_form h2{
	text-align: center;
	line-height: 500px;
	font-size: 1.5em;
}
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id = main_form>
<%
	String name = (String)session.getAttribute("name");
	if(name != null){
		session.invalidate();
		out.println("<h2>로그아웃되었습니다. 잠시후 메인페이지로 이동하겠습니다</h2>");
		%>
		<script>
		setTimeout(function go_url(){
            location.href="<%=conPath%>/member/main.jsp"
        },3000);   //  3초후 go_url() 함수를 호출한다.
		</script>
		
	<%}else{
		out.println("<h2>로그인 상태가 아닙니다</h2>");
	} %>
	
</div>	
<jsp:include page="footer.jsp"/>	
	
	

</body>
</html>