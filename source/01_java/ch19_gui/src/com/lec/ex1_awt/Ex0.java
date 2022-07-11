package com.lec.ex1_awt;

import java.awt.*;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("�ڹ� ù GUI ����"); // frame�� ���̾ƿ� Ÿ�� : BorderLayout
		Button btn = new Button("��ư");
		frame.add(btn,BorderLayout.NORTH); // ��ư�� NORTH �ʿ� �߰�
		Button btn1 = new Button("�׳� ��ư");
		frame.add(btn1, BorderLayout.CENTER); // �׳� ��ư�� CENTER�� �߰� 
		
		frame.setSize(new Dimension(300,200));
		frame.setVisible(true);
		frame.setLocation(100,50);
		
		//3���� �ڵ� â�ݰ� ��������
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		frame.setVisible(false); //3�������� ȭ�鿡 �� ���̰� ��
		frame.disable(); //�ڿ�����
		System.exit(0); // ��������
	}
}
