package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
	public static void main(String[] args) {
	HashSet<Student> students = new HashSet<Student>();
	Student s = new Student(6, "이순신");
	students.add(s);				// s == s 같은 주소 값이여서 튕겨지고 
	students.add(s);				//HashSet은 기본 equals 가지고있어서 
	students.add(new Student(3, "홍길동")); // new를 하면서 해쉬코드가 다르기 때문에 같은 값이여도  다른 값이다
	students.add(new Student(3, "홍길동")); // 
	students.add(new Student(6, "이순신")); //equals 재정의 후로 같은 값이여서  튕긴다
	System.out.println(students);			
	}
	//students.add(s); equals students.add(new Student(3, "홍길동"));
	// 이렇게 재정의 !
}
