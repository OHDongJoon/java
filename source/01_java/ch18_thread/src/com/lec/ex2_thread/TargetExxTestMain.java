package com.lec.ex2_thread;

public class TargetExxTestMain {
	public static void main(String[] args) {
		TargetEx01 threadA = new TargetEx01("A");
		TargetEx02 threadB = new TargetEx02(); //매개변수 없어서 뭘 넣을수가 없다
		threadB.setName("B"); // 그래서 이렇게 ?
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main 함수 끝");
	}
}
