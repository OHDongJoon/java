package com.lec.ex1_student;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student("���켺", 90, 90, 90);
		Student s2 = new Student("���ϴ�", 81, 90, 90);
		Student s3 = new Student("Ȳ����", 91, 90, 90);
		Student s4 = new Student("������", 80, 90, 90);
		Student s5 = new Student("������", 70, 90, 90);
		Student[] student = { s1, s2, s3, s4, s5 };
		String[] title = { "�̸�", "����", "����", "����", "����", "���" };
		int[] tot = new int[5]; // tot[0] ���� ���� , tot[1] ���� ���� ....
		double[] avg = new double[5]; // avg[0] ���� ���, avg[1]�������

		printLine();
		System.out.println("\t\t\t����ǥ"); //����ǥ

		printLine('-', 50); // printLine �޼ҵ� ȣ��----------------
		printLine('-', 50);

		for (String t : title) { // string t�� title �迭 �־���
			System.out.print('\t' + t); // �̸� ���� ���� �ü��� ���� ���
		}

		System.out.println();
		printLine('-', 50);//-----------------------------
		for (Student s : student) { // �迭�� ���� s1,s2,3 ȣ��
			s.print();
		}
		printLine();
	}

	private static void printLine() { // ����Ʈ���� �޼ҵ� 
		for (int i = 0; i < 65; i++) {// i 0�̰� i �� 65 ���� ������ ���� �׸� ���
			System.out.print('��');
		}
		System.out.println();
	}

	private static void printLine(char ch, int cnt) { // ch �� �׸� , cnt ����
		System.out.print("\t");
		for (int i = 0; i < cnt; i++) {// 
			System.out.print(ch);
		}
		System.out.println();// ����

	}
}
