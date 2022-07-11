package com.lec.ex7_timer;

import java.util.TimerTask;

public class TimarTaskEx1 extends TimerTask {//TimerTask는 API 300개중 하나 , 내가따로 만들지 않아도 상속가능

	@Override
	public void run() {
		System.out.println("작업1 : 2초후에 한번 수행될 예정인 작업(TimerTask)@ @ @");
		
	}

}
