package com.lec.ex7_timer;

import java.util.Timer;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true);//���α׷��� ������ ��� timer ����
		TimarTaskEx1 task1 = new TimarTaskEx1();
		TimerTaskEx2 task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);// 2�� �Ŀ� task1���� 
		timer.schedule(task2, 1000, 500); //1���� 0.5����
		//5�ʵ��� ��� ����
		Thread.sleep(5000);
		System.out.println("��");
	}

}
