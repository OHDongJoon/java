package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Book[] books = { new Book("890-101-1", "자바", "홍길동"), 
				new Book("110-324-1","오라클","신동"),
				new Book("110-234-2","mysql","강호동"), 
				new Book("233-432-3","web","고동"),
				new Book("44-33-3","jsp","방동"), 
				new Book("675-41234-3","spring","개발동"), };

		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호(1 : 대출 | 2:반납| 3:책 list| 0 : 종료)
		int idx; // 대출하거나 반납하려고 할 때 조회된 책 index 조회 때문에
		String bTitle, borrower, checkOutDate; // 사용자에게 받을 책이름 , 대출인, 대출일
		do {
			System.out.print("1:대출 | 2:반납| 3:책 list| 0:종료 :");
			fn = scanner.nextInt();// 입력 받은 값 fn 에 넣어
			switch (fn) { // fn이 1이면
			case 1: // 1 이면 책이름 입력
				// 대출 : 1.책이름입력 2.책조회 3.책상태확인 4.대출인입력 5. 대출일입력 6. 대출메소드 호출
				// 1.책이름 입력
				System.out.print("대출 하고자 하는 책이름은?"); // 책이름 입력받은값 bTitle 에 넣어
				bTitle = scanner.next(); // 스페이스바 들어가면놉 String 스캐너 받는법 white-space 앞 까지 스트링만 받음

				// 2. 책조회
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // 2.책조회
				if (idx == books.length) { // 5라는건 책이 없다
					System.out.println("현재 보유하지 않은 도서 입니다.");
				} else {// 도서를 대출처리
						// 3.책상태확인
					if (books[idx].getState() == Book.STATE_BORROWED) { // 대출 불가 상태
						System.out.println("현재 대출중인 도서입니다");
					} else { // 대출 가능 상태
						// 4.5.6
						System.out.println("대출자는 ? ");
						borrower = scanner.next();
						System.out.println("대출일은 ? ");
						checkOutDate = scanner.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2:	// 반납 : 1. 책이름  2. 책조회  3. 반납  4. 
				// 1 책이름
				System.out.print("반납할 책이름은 ?");
				bTitle = scanner.next();
				// 2. 책 조회 확장 for문은 인덱스가 어딧는지몰라 
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {// idx 찾은 그위치
					//3.반납
					books[idx].checkIn();
					
				}
				break;
			case 3:
//				System.out.print("책 list 출력 로직 들어갈 예정");
				System.out.print("책 리스트는 다음과 같습니다");
				for (Book book : books) {
					book.printState();
				}
				break;
			}
		} while (fn != 0);
		System.out.println("나가");
//		while(true){
//			System.out.println("기능번호(1 : 대출 | 2:반납| 3:책 list| 0 : 종료");
//			fn = scanner.nextInt();
//			if(fn==0) {
//				break;
//			}
//		}
	}// main
}// class
