package com.lec.ex5_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo;//책번호
	private String bookTitle;// 책이름
	private String writer; //저자
	private String borrower; //대출인
	private Date checkOutDate; // 대출일
	private byte state;  //대출중(1 or 대출가능(0
	
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	// BookLib = new BookLib("89a-01", "java", "홍길동(저자)");
	// book.checkOut("신길동") : 도서상태확인 - > 대출로직 -> 도서상태출력
	@Override
	public void checkOut(String borrower) throws Exception { //발생할수도 있고 아닐수도 잇고 
		if(state == STATE_BORROWED) {// state가 대출중이면(1)
			throw new Exception(bookTitle + "도서는 대출 중입니다");//에러메세지
		}
		//if 문이 참이 아닐때 내려와 
		//대출 로직
		this.borrower = borrower;
		checkOutDate = new Date(); // 오늘 날짜 시간 checkout 에 넣어 줘 
		state = STATE_BORROWED;
		// "java" 도서가 대출되었습니다. 대출인 : 신길동 대출일 2022-4-4(월) 2주이내에 반납하세요
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d(E)");
		System.out.println("\""+bookTitle + "\" 도서가 대출되었습니다");
		System.out.println("대출인 : " + borrower + " / 대출일: "+ sdf.format(checkOutDate) + "2주내로 반납하세요");
		
	}
	//book.checkIn() : 도서상태 확인 -> 연체여부 확인(if 연체되었을 경우 연체료 납부 y/n) -> 번납로직 -> 상태출력
	@Override
	public void checkIn() throws Exception {
		//반납하러왔는데 반납이 됭ㅆ엉
		if( state == STATE_NORMAL) {
			throw new Exception(bookTitle + "도서는 대출중이 아니에욤");
		}
		// 연체여부 확인 checkOutDate ~ 현재까지 14일 이내인지 여부 
		Date now = new Date(); //현재 특정한 시점
		long diff = now.getTime() - checkOutDate.getTime(); // 대출시점부터 현재까지의 밀리세컨
		long day = diff / (1000*60*60*24);
		if(day > 14 ) { //day가 14보다 크면 연체료받아 
			System.out.println("연체료는 일일 100원 부가됩니다. 내셔야할 연체료는 "+(day-14)*100); //15일 연체됬다 15-14 *100
			Scanner scanner = new Scanner(System.in);
			System.out.println("연체료를 내셨나요(y/n)");
			if(! scanner.next().equalsIgnoreCase("y")) {// 대소문자 구분없이  연체료를 냈다고 Y/y를 입력하지 않고 다른거 눌렀을때
				System.out.println("연체료를 내셔야 반납처리가 가능합니다");
				return;
			}
		} 
		//연체 안된경우  연체가 되든 안되든  연체됫으면 돈받고 아니면  돈 안받고 반납로직 바로가고 	
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"도서가 반납되었습니다");
	}
	// sysout(book) - > 책번호:89ㅁ-01 책이름:자바 저자:홍길동 대출가능 /
	//					책번호:89ㅁ-01 책이름:자바 저자:홍길동 대출중(반납예정일:2022-4-4(월))
	@Override
	public String toString() {
		//책번호:89ㅁ-01 책이름:자바 저자:홍길동
		String msg = "책번호: " + bookNo + "\t책이름:" + bookTitle +"\t저자" + writer;
		msg += (state == STATE_NORMAL) ? "\t대출가능 " : "\t대출중 ";
		if(state == STATE_BORROWED) {
			// 빌린시점 + 14일
			SimpleDateFormat sdf = new SimpleDateFormat("(대출일 : yyyy-M-d(E))");
			msg += sdf.format(checkOutDate);
			
		}
		return msg;
		//Date Date = new Date(checkOutDate.getTime()+(1000*60*60*24));
	
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
