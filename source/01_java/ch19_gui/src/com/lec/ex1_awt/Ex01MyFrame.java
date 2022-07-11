package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex01MyFrame extends Frame{ 
	private Button btn;
	private Button btn1;
	public  Ex01MyFrame(String title) {
		super(title);
		// 버튼 2개를 추가한 프레임
		btn = new Button("버튼");
		btn1 = new Button("그냥버튼");
		add(btn,BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);
		setSize(new Dimension(300,200));
		setVisible(true);
		setLocation(100,50);
		//3초후 자동 창닫고 실행종료
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				setVisible(false); //3초지나면 화면에 안 보이게 됨
				disable(); //자원해제
				System.exit(0); // 강제종료
			}
	public static void main(String[] args) {
		new Ex01MyFrame("first GUI");
	}
	
}
