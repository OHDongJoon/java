package com.lec.ex8_staticstudent;

public class Student1 {
	private int serialNo; // 객체 고유의 번호 101, 102 103 .........
	private static int count = 00;
	public Student1() {}
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	public Student1(String name, int kor, int mat, int engl) {
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = engl;
		tot = kor + engl + mat;
		avg = tot / 3.0;
		serialNo = ++ count;
	}
	public void print1() {
		
		System.out.println("\t"+serialNo+"\t"+"\t" + name +"\t"+kor+"\t"+ eng +"\t" + mat + "\t" + tot +"\t" + avg);
	}
	public String infoStrig() {
		return String.format("\t %d \t %s \t %d \t %d \t %d \t %d \t %.1f\n",count,name, kor, eng, mat, tot, avg);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Student1.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}