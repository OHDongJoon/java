package com.lec.ex;

//------------
//Hello, World!
//------------- printLine()
// Hello, Java!
// ~~~~~~~~~~~~ printLine('~')
// Hello, Hong!
//
//
public class Ex05 {
	public static void main(String[] args) {
		printLine('■',50);
		System.out.println("Hello, World!");
		printLine(40);
		System.out.println("Hello, java!");
		printLine('~');
		System.out.println("Hello, Hong!");
		printLine();
	}
	private static void printLine(char c, int cnt) {
		// i=0 i가 cnt 50 보다 작을ㄸ 까지 c 를 출력
		for (int i = 0; i < cnt; i++) {
			System.out.print(c);
		}
		System.out.println();// c = ■ , cnt = 50번 

		
	}
	private static void printLine(int cnt) { //printLine(40)
		for (int i = 0; i < cnt; i++) {
			System.out.print('*');
		}
		System.out.println();// '*' 30개 출력하고 개행

	}

	private static void printLine(char c) {// 함수 오버로딩(
		for (int i = 0; i < 30; i++) {
			System.out.print(c);
		}
		System.out.println();// 매게변수로 받은 c문자 30개 출력하고 개행
	}

	private static void printLine() {// 리턴타입이 없고 매개변수 없는 메소드(함수)
		for (int i = 0; i < 30; i++) {
			System.out.print('-');
		}
		System.out.println();// 얇은 '-' 30개 출력하고 개행

	}

}
