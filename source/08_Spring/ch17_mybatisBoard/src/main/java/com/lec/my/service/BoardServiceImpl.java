package com.lec.my.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.my.dao.BoardDao;
import com.lec.my.model.Board;
import com.lec.my.util.Paging;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(),pageNum, 10, 5);
		Board bod = new Board();
		bod.setStartRow(paging.getStartRow());
		bod.setEndRow(paging.getEndRow());
		return boardDao.boardList(bod);
	}

	@Override
	public int insert(Board bod) {
		
		return boardDao.insert(bod);
	}

	@Override
	public int totCnt() {
		return boardDao.totCnt();
	}

	@Override
	public int hitup(int bid) {
		return boardDao.hitup(bid);
	}

	@Override
	public Board detail(int bid) {
		hitup(bid);
		return boardDao.detail(bid);
	}

	@Override
	public Board updateView(int bid) {
		// TODO Auto-generated method stub
		return boardDao.updateView(bid);
	}

	@Override
	public int update(Board bod) {
		return boardDao.update(bod);
	}

	@Override
	public int delete(int bid) {
		return boardDao.delete(bid);
	}

	@Override
	public int boardReply(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		boardDao.boardReplyPreStep(board);
		return boardDao.boardReply(board);
	}

}
