package com.lec.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.my.model.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board bod);
	public int insert(Board bod);
	public int totCnt();
	public int hitup();
	public Board detail(int bid);
	public Board updateView(int bid);
	public int update(Board bod);
	public int delete(int bid);
}
