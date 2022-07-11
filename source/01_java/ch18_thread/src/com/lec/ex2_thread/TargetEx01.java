package com.lec.ex2_thread;

//Runnable 사용하지 않음
// 그전꺼는 Thread t1 = new Thread(targget1,"A)
// Thread t1 = new ThreadEx01("A) 매개변수 잇는 
public class TargetEx01 extends Thread { //Thread에서 상속받은 클래쑤
	public TargetEx01(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("안녕하세요 - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}