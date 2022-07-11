package com.lec.ex1_runnable;

public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable target1 = new TargetEx01();//Runnable == TargetEx01
		Runnable target2 = new TargetEx02();//RunnableŸ��
		//TargetEx02 target2 = new TargetEx02();
//		target1.run()
//		target2.run(); �̷����ϸ� ���ÿ� �ϴ°Ծƴ�
		// "A" ��� �̸��� ������ ���� - target1.run() ����
		Thread threadA = new Thread(target1, "A");
		// " B" ��� �̸��� ������ ���� - target2.run() ����
		Thread threadB = new Thread(target2, "B");
		//
		threadA.start(); // �� ��~ �Ѵ�
		threadB.start(); //
		for(int i=0 ; i < 10; i++) {
			System.out.println("���� main"+Thread.currentThread().getName() + i);
			// Thread.currentThread().getName() : ���� ������ �̸�
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}