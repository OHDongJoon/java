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
		printLine('��',50);
		System.out.println("Hello, World!");
		printLine(40);
		System.out.println("Hello, java!");
		printLine('~');
		System.out.println("Hello, Hong!");
		printLine();
	}
	private static void printLine(char c, int cnt) {
		// i=0 i�� cnt 50 ���� ������ ���� c �� ���
		for (int i = 0; i < cnt; i++) {
			System.out.print(c);
		}
		System.out.println();// c = �� , cnt = 50�� 

		
	}
	private static void printLine(int cnt) { //printLine(40)
		for (int i = 0; i < cnt; i++) {
			System.out.print('*');
		}
		System.out.println();// '*' 30�� ����ϰ� ����

	}

	private static void printLine(char c) {// �Լ� �����ε�(
		for (int i = 0; i < 30; i++) {
			System.out.print(c);
		}
		System.out.println();// �ŰԺ����� ���� c���� 30�� ����ϰ� ����
	}

	private static void printLine() {// ����Ÿ���� ���� �Ű����� ���� �޼ҵ�(�Լ�)
		for (int i = 0; i < 30; i++) {
			System.out.print('-');
		}
		System.out.println();// ���� '-' 30�� ����ϰ� ����

	}

}
