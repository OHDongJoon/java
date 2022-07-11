<%@page import="com.lec.book.BookDto"%>
<%@page import="com.lec.book.BookDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%	// 한글 인코딩처리 - multipartRequest 객체 생성 - 첨부된 파일명 get - 그외 파라미터에서 입력된 get - insert
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("bookImg");
	int maxSize = 1024*1024*5; // 최대 업로드 용량이 5M
	String[] image = {"",""};
	MultipartRequest mRequest = null;
	try{
		//Multipartrequest 객체 생성   
		mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());  // Def
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름들
		int idx = 0;
		while(paramNames.hasMoreElements()){ // 가르키는 곳에 있어 ?
			String param = paramNames.nextElement();
		image[idx] = mRequest.getFilesystemName(param); // 해당 파라미터 이름으로 저장된 파일이름
		idx++;
		} //while

	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	// 서버의 bookImg폴더 파일을 소스의 bookImg폴더로 복사
	for(String img : image){ // 첨부된 파일이 없으면 위에서 null 로 저장 되서 내려옴
		if(img != null){
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path+"/"+img);
			try{
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro/source/06_JSP/ch14_fileUp/WebContent/bookImg/" + img);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readbyteCnt = is.read(bs);
					if(readbyteCnt == 1) break;
					os.write(bs, 0, readbyteCnt);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
					if(os != null) os.close();
					if(is != null) is.close(); 
			}							
		}
	
	}
			
	
	// 파일첨부외 파라미터에서 입력된 정보 get
	 int 	bid	= 0;
	 String 	btitle = mRequest.getParameter("btitle");
	 int 	bprice = Integer.parseInt(mRequest.getParameter("bprice"));
	 String 	bimage1 = image[1]==null? "noImg.png" : image[1];
	 String 	bimage2 = image[0]!=null? image[0]:"NOTHING.JPG" ;
	 String 	bcontent = mRequest.getParameter("bcontent");
	 int		bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
	 Date brdate = null;
	// DB에 insert 
	BookDao bDao = BookDao.getInstance();
	BookDto book = new BookDto(bid , btitle, bprice, bimage1, bimage2,
			bcontent, bdiscount, brdate); 
	int result = bDao.insertBook(book);
	if(result == BookDao.SUCCESS){
		out.println("<h2>책 등록 성공</h2>");
	}else{
		out.println("<h2>책 등록  실패</h2>");
	}
%>
	<h3>책이름 : <%=btitle %></h3>
	
	<h3>책대표이미지 : <%=path %>/ <%=bimage1%></h3>
	<img src="<%=conPath %>/bookImg/<%=bimage1 %>" alt="대표">
	
	<h3>책이미지2 : <%=path + "/" + bimage2 %></h3>
	<img src="../bookImg/<%=bimage2 %>">
	
	<h3>책 설명</h3>
	<pre><%=bcontent %></pre>
	<h3>책가격: <del><%=bprice%></del> <%=bprice*(100-bdiscount)/100 %>원</h3>
	<h3>할인율 : <%=bdiscount %></h3>
	<a href="ex3_list_board.jsp">책 전체리스트(게시판스타일 )</a>
	<a href="ex3_list_boardP.jsp">책 리스트(paging 게시판스타일 )</a>
	<a href="ex3_list_product.jsp">책 전체 리스트(쇼핑몰스타일)</a>
	<a href="ex3_list_productp.jsp">책 리스트(paging 추가된 쇼핑몰스타일)</a>
</body>
</html>






