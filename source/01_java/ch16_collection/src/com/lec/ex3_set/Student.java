package com.lec.ex3_set;
//중복값 빼고싶을때 equals재정의 
//toString과 hashCode가 같으면 같게
public class Student {
	private int grade;
	private String name;
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	@Override
	public String toString() {
		return grade + " 학년 " + name;
	}
	@Override
	public boolean equals(Object obj) { //obj에는 toString 이 있으니까 
		if(obj!=null && obj instanceof Student ) {
			
//			boolean gradeChk = grade ==((Student)obj).grade;
//			boolean nameChk = name.equals( ((Student)obj).name);
//			return gradeChk && nameChk;
			return toString().equals(obj.toString()); // toString과 obj.toStirng 과 같으면 리턴
					
		}
		return false;
		 
	}
	@Override
	public int hashCode() {
		return toString().hashCode(); //toString이 같으면 같은 주소처럼 보이게 
	}
}
