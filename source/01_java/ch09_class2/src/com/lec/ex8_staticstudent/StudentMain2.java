package com.lec.ex8_staticstudent;

import com.lec.ex1_student.Student;

public class StudentMain2 {
	public static void main(String[] args) {

		Student1 s1 = new Student1("���켺", 90, 90, 90);
		Student1 s2 = new Student1("���ϴ�", 81, 90, 90);
		Student1 s3 = new Student1("Ȳ����", 91, 90, 90);
		Student1 s4 = new Student1("������", 80, 90, 90);
		Student1 s5 = new Student1("������", 70, 90, 90);
		Student1[] student = { s1, s2, s3, s4, s5 };
		String[] title = { "��ȣ", "�̸�", "����", "����", "����", "����", "���" };
		int[] tot = new int[5];
		double[] avg = new double[5];

		printLine();
		System.out.println("\t\t\t����ǥ");
		
		printLine('-', 50);
		printLine('-', 50);
		
		for (String t : title) {
			System.out.print('\t' + t);
		}
		System.out.println();
		printLine('-', 50);
		for (Student1 s : student) {
			s.print1();
		}
		printLine();
	}
	private static void printLine() {
		for(int i = 0; i < 65; i++) {
			System.out.print('��');
		}
		System.out.println();
	}
	private static void printLine(char ch, int cnt) {
		System.out.print("\t");
		for (int i = 0; i < cnt; i++) {// 
			System.out.print(ch);
	}
		System.out.println();
	
	
 }	
}
	
	
	
	
	

