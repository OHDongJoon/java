<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	 <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/uikit.min.css" />
        <script src="js/uikit.min.js"></script>
        <script src="js/uikit-icons.min.js"></script>
</head>
<body>

	<div align="center">
	<div class="uk-cover-container uk-height-medium">
    <video src="https://yootheme.com/site/images/media/yootheme-pro.mp4" autoplay loop muted playsinline uk-cover></video>
</div>
 

		<hr width="500" color="green">
		<h2>파일 UPLOAD</h2>
		<hr width="500" color="green">
		<form action="fileupload" method="post" enctype="multipart/form-data">
			<p>첨부파일1 <input type="file" name="file1"></p>
			<p>첨부파일2 <input type="file" name="file2"></p>
			<p>첨부파일3 <input type="file" name="file3"></p>
			<input type="submit" value="전송">
		</form>
 	</div>
</body>
</html>