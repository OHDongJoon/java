package com.lec.ch19.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Book;

@Mapper
public interface BookDao {
	public List<Book> mainList(); //책들 모든 리스트 입력순 
	public List<Book> bookList(Book book); // 책이름 가나다순으로 페이징처리
	public int totCntBook(); //등록된 책 갯수
	public Book getDetailBook(int bnum); // bnum으로 상세보기
	public int registerBook(Book book);
	public int modifyBook(Book book);
}
