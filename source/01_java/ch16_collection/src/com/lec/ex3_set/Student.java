package com.lec.ex3_set;
//�ߺ��� ��������� equals������ 
//toString�� hashCode�� ������ ����
public class Student {
	private int grade;
	private String name;
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	@Override
	public String toString() {
		return grade + " �г� " + name;
	}
	@Override
	public boolean equals(Object obj) { //obj���� toString �� �����ϱ� 
		if(obj!=null && obj instanceof Student ) {
			
//			boolean gradeChk = grade ==((Student)obj).grade;
//			boolean nameChk = name.equals( ((Student)obj).name);
//			return gradeChk && nameChk;
			return toString().equals(obj.toString()); // toString�� obj.toStirng �� ������ ����
					
		}
		return false;
		 
	}
	@Override
	public int hashCode() {
		return toString().hashCode(); //toString�� ������ ���� �ּ�ó�� ���̰� 
	}
}
