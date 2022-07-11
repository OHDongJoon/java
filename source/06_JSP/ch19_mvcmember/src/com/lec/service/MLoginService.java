package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.memberdao.MemberDao;
import com.lec.memberdto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 form 에서 받아온 mid , mpw 
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		// dao 생성 
		MemberDao mDao = MemberDao.getInstance();
		//int result = mDao.loginCheck 함수 호출
		int result = mDao.loginCheck(mid, mpw);
		//만약에 로그인 성공이면 result 에 할당
		if(result == MemberDao.LOGIN_SUCCESS) {
			HttpSession session = request.getSession();
			MemberDto member = mDao.getMember(mid);
			session.setAttribute("member", member);
		}else {
			request.setAttribute("loginErrorMsg", "id pw 가 틀립니다");
		}

	}

}
