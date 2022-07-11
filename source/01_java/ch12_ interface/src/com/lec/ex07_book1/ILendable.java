package com.lec.ex07_book1;
// Book 에 작업명세 
// 상수랑 추상메소드
public interface ILendable {
	public byte STATE_BORROWED = 1; // " 대출 중 "
	public byte STATE_NORMAL   = 0; // "대출 가능" 을 의미
	public void checkOut(String borrower, String checkoutDate); // 대출시 대출인과 대출일 이용
	public void checkIn(); // 반납
	public void printState(); // 도서정보와 대출 상태 출력
}
