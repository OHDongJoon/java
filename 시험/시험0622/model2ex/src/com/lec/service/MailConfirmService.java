package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.memberdao.MemberDao;

public class MailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmEmail(memail);
		if(result == MemberDao.EXISTENT) {
		  request.setAttribute("maileConfirmResult", "중복된 이메일입니다");
		}else {
		  request.setAttribute("maileConfirmResult", "사용가능 이메일입니다");
		}

	}

}
