package com.lec.ex1_student;

// ÀÌ¸§ ±¹¾î ¿µ¾î ¼öÇÐ ÃÑÁ¡ Æò±Õ
public class Student {
	private String name;

	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;

	// new Student("È«",90,90,90)
	public Student(String name, int kor, int mat, int engl) {
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = engl;
		tot = kor + engl + mat;
		avg = tot / 3.0;

	}

	public void print() {
		System.out.printf("\t %s \t %d \t %d \t %d \t %d \t %.1f\n", name, kor, mat, eng, tot, avg);
	}

	public String infoString() {
		return String.format("\t %s \t %d \t %d \t %d \t %d \t %.1f\n", name, kor, eng, mat, tot, avg);
	}

	public String getName() {
		return name;
	}

	public int getkor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

}
