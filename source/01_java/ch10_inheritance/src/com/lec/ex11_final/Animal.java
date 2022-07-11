package com.lec.ex11_final;

public class Animal {
	private int speed;
	public void running() {
		speed += 5;
		System.out.println("뛰고 있어요 . 현재속도 : "+ speed);
	}
	public final void stop() { // override 금지 메소드 final 들어갔으니가  메소드 앞에 final 들어가면 다른데서 금지
		speed = 0 ;
		System.out.println("멈춤" + speed);
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
