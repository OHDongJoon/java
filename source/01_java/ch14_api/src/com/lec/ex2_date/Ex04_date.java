package com.lec.ex2_date;

import java.util.Date;

public class Ex04_date {
	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date);//가독성 저하 
		int year = date.getYear() + 1900; //  요놈 왜????????????????????????
		int month = date.getMonth() +1 ; // 0~11월
		int day = date.getDate(); // 일
		System.out.printf("%d년 %d월 %d일\n", year,month,day);
		// %d(정수) %f(실수) %s(문자열) %c(문자)
				// %ty(년) %tm(월) %td(일) %ta(요일) %tp(오전/오후) %t1(12시) %tm(분) %ts(초)
				System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %tS초\n", date, date, date, date, date, date, date, date);
				System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$tl시 %1$tM분 %1$tS초", date); // ??
	}
}