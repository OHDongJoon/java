package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.memberdao.MemberDao;
import com.lec.memberdto.MemberDto;

public class MAllViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=3, BLOCKSIZE=5;
		int startRow =(currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> members = mDao.allMember(startRow,  endRow);
		request.setAttribute("mAllView", members);
		int totalCnt = mDao.getMemberTotCnt(); //현재 글 갯수
		int pageCnt = (int)Math.ceil((double)totalCnt / PAGESIZE);
        int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE +1;
        int endPage   = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		if(members != null) {
		
		
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // ★ 이하 페이지 관련 항목들
		request.setAttribute("pageNum", currentPage);// currentPage 넣는이유 : lnt형을 넘겨주기 위해서 ?
		}
		
	}

}
