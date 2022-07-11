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
	<style></style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('input[name="mid"]').keyup(function(){
				var mid = $('input[name="mid"]').val();
				$.ajax({
					url : '${conPath}/idConfirm.do',
					data : {mid : mid},
					type : 'post',
					dataType : 'html',
					success : function(data){
						$('#idConfirmResult').html(data); // 사용가능한 ID입니다
					}
				});// ajax함수
			});// keyup 이벤트
			$('input[name="memail"]').keyup(function(){
				var memail = $('input[name="memail"]').val();
				$.ajax({
					url : '${conPath}/mailConfirm.do',
					data : {memail : memail},
					type : 'post',
					dataType : 'html',
					success : function(data){
						$('#maileConfirmResult').html(data); // 사용가능한 이메일
					}
				});// ajax함수
			});// keyup 이벤트
			$('input[name="mpw"], input[name="mpwChk"]').keyup(function(){
				var mpw = $('input[name="mpw"]').val();
				var mpwChk = $('input[name="mpwChk"]').val();
				if(mpw == mpwChk){
					$('#pwChkResult').text('비밀번호 일치');
				}else{
					$('#pwChkResult').html('<b>비밀번호 불일치</b>');
				}
			}); // pw check
			$('form').submit(function(){
				var idConfirmResult = $('#idConfirmResult').text().trim();
				var pwChkResult     = $('#pwChkResult').text().trim();
				var maileConfirmResult = $('#maileConfirmResult').text().trim();
				if(idConfirmResult != '사용가능 ID입니다'){
					alert('사용가능한 ID로 가입하세요');
					return false;
				}else if(pwChkResult != '비밀번호 일치'){
					alert('비밀번호를 확인하세요');
					return false;
				}else if(maileConfirmResult != '사용가능 이메일입니다'){
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
    $( "#datepicker" ).datepicker({
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
<jsp:include page="../member/header.jsp"/>
<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
     <table>
        <caption>회원가입</caption>
         <tr>
             <th>아이디</th>
             <td><input type="text" name="mid" required="required"></td>
        </tr>
        <tr>
				<td></td><td><div id="idConfirmResult"> &nbsp; </div></td>
		</tr>
        <tr>
                 <th>비밀번호</th>
                  <td><input type="password" name="mpw" required="required"></td>
        </tr>
        <tr>
                 <th>확인비밀번호</th>
                  <td><input type="password" name="mpwChk" required="required"></td>
        </tr>
        <tr><td></td><td><div id="pwChkResult"> &nbsp; </div></td></tr>
        <tr>
	        <th>이름</th>
	        <td><input type="text" name="mname" required="required"></td>
        </tr>
         <tr>
	        <th>메일</th>
	        <td><input type="email" name="memail" required="required" ></td>
        </tr>
        <tr>
				<td></td><td><div id="maileConfirmResult"> &nbsp; </div></td>
		</tr>
        <tr>
	        <th>사진</th>
	        <td><input type="file" name="mphoto" ></td>
        </tr>
        <tr>
	        <th>생년월일</th>
	        <td><input type="text" name="mbirth" id="datepicker"></td>
        </tr>
        <tr>
	        <th>주소</th>
	        <td><input type="text" name="maddress" ></td>
        </tr>
        <tr>
				<td colspan="2"><input type="submit" value="가입"></td>
			</tr>
    </table>
  </form>
  <jsp:include page="../member/footer.jsp"/>
</body>
</html>