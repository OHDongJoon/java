<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
w
</script>
<body>
<% String num = request.getParameter("num");// null이거나 숫자스트링%>
	<fieldset>
			<legend>숫자입력</legend>
		<form action="" method="get">					<!-- if num이 null이 아니면 프린트 num 해 임뫄  -->
			자연수<input type="number" name="num" value="<%if(num!=null) out.print(num);%>"> 
			<input type="submit"value="누적">

		</form>
	</fieldset>
	<%
	if(num!=null && !num.equals("")){ // num이 아닐때랑 빈스트링이면 !!!!!!!!!!!!!!!!!!!!!!
		int n = Integer.parseInt(num);
		int total = 0 ;// 누적변수 초기화
		for(int i =1 ; i <=n ; i ++){
			total += i;
		}
		out.print("<h2>1부터" + n+"까지 누적합은" + total + " </h2>");
		
	}
	%>

</body>
</html>