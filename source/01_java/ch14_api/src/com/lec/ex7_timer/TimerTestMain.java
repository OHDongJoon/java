package com.lec.ex7_timer;

import java.util.Timer;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true);//프로그램이 끝나고 계속 timer 상주
		TimarTaskEx1 task1 = new TimarTaskEx1();
		TimerTaskEx2 task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);// 2초 후에 task1수행 
		timer.schedule(task2, 1000, 500); //1초후 0.5초후
		//5초동안 잠깐 멈춤
		Thread.sleep(5000);
		System.out.println("끝");
	}

}
