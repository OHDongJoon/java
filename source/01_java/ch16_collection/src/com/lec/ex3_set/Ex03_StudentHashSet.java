package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
	public static void main(String[] args) {
	HashSet<Student> students = new HashSet<Student>();
	Student s = new Student(6, "�̼���");
	students.add(s);				// s == s ���� �ּ� ���̿��� ƨ������ 
	students.add(s);				//HashSet�� �⺻ equals �������־ 
	students.add(new Student(3, "ȫ�浿")); // new�� �ϸ鼭 �ؽ��ڵ尡 �ٸ��� ������ ���� ���̿���  �ٸ� ���̴�
	students.add(new Student(3, "ȫ�浿")); // 
	students.add(new Student(6, "�̼���")); //equals ������ �ķ� ���� ���̿���  ƨ���
	System.out.println(students);			
	}
	//students.add(s); equals students.add(new Student(3, "ȫ�浿"));
	// �̷��� ������ !
}
