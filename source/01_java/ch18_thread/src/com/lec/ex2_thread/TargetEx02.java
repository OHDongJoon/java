package com.lec.ex2_thread;
// TargetEx02 t2 = new TargetEx02() �Ű����� ���� �� ������̽ô�
public class TargetEx02 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(i + "��°, �ݰ����ϴ�");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}