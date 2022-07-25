package com.lec.my.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.my.model.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int insert(Board bod);
	public int totCnt();
	public int hitup(int bid);
	public Board detail(int bid);
	public Board updateView(int bid);
	public int update(Board bod);
	public int delete(int bid);
	public int boardReply (Board board, HttpServletRequest request);
}
