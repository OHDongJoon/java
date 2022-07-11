package com.lec.ex11_final;
//레빗은 final 이 들 어갔기때무에 다른데서 상속 못받음 
// animal 로부터 상속받은 rabbit 클래스 생성
public final class Rabbit extends Animal {
	@Override
	public void running() {
		setSpeed(getSpeed()+30);
		System.out.println("토끼가 마구뛰어요 . 현재속도:" +getSpeed());
	}
}
