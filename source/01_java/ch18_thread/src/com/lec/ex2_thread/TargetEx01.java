package com.lec.ex2_thread;

//Runnable ������� ����
// �������� Thread t1 = new Thread(targget1,"A)
// Thread t1 = new ThreadEx01("A) �Ű����� �մ� 
public class TargetEx01 extends Thread { //Thread���� ��ӹ��� Ŭ����
	public TargetEx01(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("�ȳ��ϼ��� - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}