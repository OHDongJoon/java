<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String conPath = request.getContextPath();
	String appPath = application.getContextPath(); //  /ch05_jsp
	String absolutePath = application.getRealPath("."); // 현재 프로젝트의 절대경로
	
%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
<%
	String filePath = application.getRealPath("WEB-INF/input.txt");
	out.println(filePath + "의 내용입니다<br><br>");
	// 스트림객체생성 (파일은 연다) - 읽는다  - 스트림객체를닫는다 (파일닫는다)
	BufferedReader br = new BufferedReader(new FileReader(filePath));// 스트림객체생성
	while(true){
		String line = br.readLine();// 파일 읽기(한줄씩), 한줄씩 읽다가 끝나면 null 반환
		if(line==null) break;
		out.println(line + "<br>");
	}
	br.close();
	/* BufferedReader br = null;
	try{
		br = new BufferedReader(new FileReader(filePath)); // 스트림객체생성
		while(true){
			String line = br.readLine(); // 파일 읽기(한줄씩), 한줄씩 읽다가 끝나면 null 반환
			if(line == null){
				break;
			}
			out.println(line + "<br>");
		}
	}catch(Exception e){
		out.println("파일이 존재하지 않거나 읽을 수 없는 파일입니다");
	}finally{
		try{
			if(br!=null) br.close();
		}catch(Exception e){
			
		}
	} 	*/
%>
<body>

</body>
</html>