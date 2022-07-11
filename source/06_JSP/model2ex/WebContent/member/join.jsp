<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<style>
	#content_form {
			width: 800px; height:690px; 
			margin: 20px auto 0px;
	}
	#idConfirmResult, #pwChkResult, #emailConfirmResult{text-align: left; padding-left: 30px;}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	$(document).ready(function(){
		$('input[name="mId"]').keyup(function(){
			var mId = $('input[name="mId"]').val();
			$.ajax({
				url : '${conPath}/idConfirm.do',
				data : 'mId=' + mId,
				type : 'get',
				dataType : 'html',
				success : function(data){
					$('#idConfirmResult').html(data); // 사용가능한 ID입니다
				}
			});// ajax함수
		});// keyup 이벤트
		$('input[name="mEmail"]').keyup(function(){
			var mEmail = $('input[name="mEmail"]').val();
			$.ajax({
				url : '${conPath}/mailConfirm.do',
				data : 'mEmail='+mEmail,
				type : 'get',
				dataType : 'html',
				success : function(data){
					$('#emailConfirmResult').html(data); // 사용가능한 이메일
				}
			});// ajax함수
		});// keyup 이벤트
		$('input[name="mPw"], input[name="mPwChk"]').keyup(function(){
			var mPw = $('input[name="mPw"]').val();
			var mPwChk = $('input[name="mPwChk"]').val();
			if(mPw == mPwChk){
				$('#pwChkResult').text('비밀번호 일치');
			}else{
				$('#pwChkResult').html('<b>비밀번호 불일치</b>');
			}
		}); // pw check
		$('form').submit(function(){
			var idConfirmResult = $('#idConfirmResult').text().trim();
			var pwChkResult     = $('#pwChkResult').text().trim();
			var emailConfirmResult = $('#emailConfirmResult').text().trim();
			if(idConfirmResult != '사용 가능한 ID'){
				alert('사용가능한 ID로 가입하세요');
				return false;
			}else if(pwChkResult != '비밀번호 일치'){
				alert('비밀번호를 확인하세요');
				return false;
			}else if(emailConfirmResult != '사용 가능한 메일입니다'){
				alert('사용가능한 이메일로 가입하세요');
				return false;
			}
		});//form 태그 이벤트
	});
</script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#mBirth" ).datepicker({
    	dateFormat : 'yy-mm-dd',
    	changeMonth : true, // 월을 바꿀 수 있는 셀렉트 박스 표시
    	monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	showMonthAfterYear : true,
    	yearSuffix : '년', // "2020년 3월"
    	showOtherMonths : true,
    	dayNamesMin:['일','월','화','수','목','금','토'],
			changeYear : true, // 년을 바꿀 수 있는 셀렉트 박스 표시
			minDate : '-100y', // 현재 날짜로부터 100년 이전까지 표시
			maxDate : 'y', // 현재 날짜이전까지만 표시
			yearRange : 'c-100:c+100', // 년도 선택 셀렉트 
    });
  } );
  </script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
		<table>
			<caption>회원가입</caption>
			<tr><th>아이디</th>
					<td>
						<input type="text" name="mId" required="required">
						<div id="idConfirmResult"> &nbsp; </div>
					</td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="mPw" required="required"></td>
			</tr>
			<tr><th>비밀번호</th>
					<td>
						<input type="password" name="mPwChk" required="required">
						<div id="pwChkResult"> &nbsp; </div>
					</td>
			</tr>
			<tr><th>이름</th>
					<td><input type="text" name="mName" required="required"></td>
			</tr>
			<tr><th>메일</th><td><input type="email" name="mEmail"><div id="emailConfirmResult"> &nbsp; </div></td></tr>
			<tr><th>사진</th><td><input type="file" name="mPhoto"></td></tr>
			<tr><th>생년월일</th><td><input type="text" name="mBirth" id="mBirth"></td></tr>
			<tr><th>주소</th><td><input type="text" name="mAddress"></td></tr>
			<tr><td colspan="2">
						<input type="submit" value="회원가입" class="btn">
						<input type="button" value="로그인" class="btn"
								onclick="location.href='${conPath}/loginView.do'">
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>