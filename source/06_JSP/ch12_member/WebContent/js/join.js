/**
 * 
 */
function infoConfirm(){
	if(join_frm.cpw.value != join_frm.pwChk.value){
		alert('비밀번호를 확인하세요');
		join_frm.cpw.value = '';
		join_frm.pwChk.value= '';
		join_frm.cpw.focus();
		return;
	}
	join_frm.submit();
}