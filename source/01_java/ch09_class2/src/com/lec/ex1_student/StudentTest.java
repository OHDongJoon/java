package com.lec.ex1_student;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 81, 90, 90);
		Student s3 = new Student("황정민", 91, 90, 90);
		Student s4 = new Student("강동원", 80, 90, 90);
		Student s5 = new Student("유아인", 70, 90, 90);
		Student[] student = { s1, s2, s3, s4, s5 };
		String[] title = { "이름", "국어", "영어", "수학", "총점", "평균" };
		int[] tot = new int[5]; // tot[0] 국어 누적 , tot[1] 영어 누적 ....
		double[] avg = new double[5]; // avg[0] 국어 평균, avg[1]영어평균

		printLine();
		System.out.println("\t\t\t성적표"); //성적표

		printLine('-', 50); // printLine 메소드 호출----------------
		printLine('-', 50);

		for (String t : title) { // string t에 title 배열 넣어줘
			System.out.print('\t' + t); // 이름 국어 영ㅇ ㅓ수학 총점 평균
		}

		System.out.println();
		printLine('-', 50);//-----------------------------
		for (Student s : student) { // 배열에 담은 s1,s2,3 호출
			s.print();
		}
		printLine();
	}

	private static void printLine() { // 프린트라인 메소드 
		for (int i = 0; i < 65; i++) {// i 0이고 i 가 65 보다 작을때 까지 네모 출력
			System.out.print('■');
		}
		System.out.println();
	}

	private static void printLine(char ch, int cnt) { // ch 는 네모 , cnt 숫자
		System.out.print("\t");
		for (int i = 0; i < cnt; i++) {// 
			System.out.print(ch);
		}
		System.out.println();// 개행

	}
}
