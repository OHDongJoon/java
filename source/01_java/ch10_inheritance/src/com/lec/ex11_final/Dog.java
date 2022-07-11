package com.lec.ex11_final;
//Animal로 부터 speed , running() , stop() 상속 받음
public class Dog extends Animal {
	@Override
	public void running() {
		//speed += 10; 이거 놉
		setSpeed(getSpeed()+10);
		System.out.println("강아지가 꼬리를 흔들며 뛰어요. 현재속도 :"+getSpeed());
 	} 
	
}
