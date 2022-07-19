package com.lec.ch12.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	private int bid ;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;//날짜까지 뿌린다 Timestamp , 날짜를 입력 받는다 date
	private Date date;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
}
