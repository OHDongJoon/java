package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;
// 뭔차이?
public class Ex02_greagorinCalendar {
	public static void main(String[] args) {
		//Calendar cal = Calendar.getInstance();// 싱글톤 클래스
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(cal);
		int year = cal.get(Calendar.YEAR); // 년도
		int month = cal.get(Calendar.MONTH)+1; //월(Calendar,MONTH 0,1,2,3,...11월
		int day = cal.get(Calendar.DAY_OF_MONTH); // 일
		int week = cal.get(Calendar.DAY_OF_WEEK);//일1, 월2, 화3, 수4, ....토 7
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24시간 단위
		int ampm = cal.get(Calendar.AM_PM); /// 0 오전 1 오후 
		int hour = cal.get(Calendar.HOUR); // 12시간단위
		int minute = cal.get(Calendar.MINUTE); // 분
		int second = cal. get(Calendar.SECOND); // 초
		int millisec = cal.get(Calendar.MILLISECOND); //밀리세컨
		System.out.printf("%d년 %d월 %d일", year, month, day);
		switch(week) {
		case 1: System.out.println("일요일"); break;
		case 2: System.out.println("월요일"); break;
		case 3: System.out.println("화요일"); break;
		case 4: System.out.println("수요일"); break;
		case 5: System.out.println("목요일"); break;
		case 6: System.out.println("금요일"); break;
		case 7: System.out.println("토요일"); break;
		
		}
		System.out.println(ampm == 0 ? "오전" : "오후");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, minute, second, millisec);
		System.out.printf("%d시 %d분 %d초\n", hour24, minute, second, millisec);
		
		// %d(정수) %f(실수) %s(문자열) %c(문자)
		// %ty(년) %tm(월) %td(일) %ta(요일) %tp(오전/오후) %t1(12시) %tm(분) %ts(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %tS초\n", cal, cal, cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$tl시 %1$tM분 %1$tS초", cal); // ??
	}
	
}
