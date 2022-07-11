<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrqp{width:300px;
	
	border:1px solid blue;
	
}
#wrap p{border: 1px solid blue;
 	height: 30px;
 	}
button{
 	width :50px;
 	height: 50px;
 }
</style>
</head>
<body>
	<div id="wrqp">
	<p>동전이 있는 곳을  맞춰봐</p>
	<button onclick="location.href='exPro.jsp?btn=1'" name="btn" value="1">1번</button>
	<button onclick="location.href='exPro.jsp?btn=2'" name="btn" value="2">2번</button>
	<button onclick="location.href='exPro.jsp?btn=3'" name="btn" value="3">3번</button>
	</div>
	<div id="msg">
       <%
       String msg = request.getParameter("msg");
       if (msg != null){
          out.print(msg);
       }
    %>
</body>
</html>