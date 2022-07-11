package com.lec.ex11_robot;
// RobotOrder order = new RobotOrder();
// order.action(drawRobot형 객체);
public class RobotOrder {
	public void action(Robot robot) {
		// 이거 못해  로봇에 아무것도 없자나 robot.sing();
		if(robot instanceof SingRobot) {
			((SingRobot) robot).sing();
		}else if(robot instanceof DanceRobot) {
			((DanceRobot) robot).dance();
			
		}else if(robot instanceof DrawRobot) {
			((DrawRobot) robot).draw();
		}else {
			System.out.println("확장된 로봇이면 이곳에 구현하세요 ");
		}
	}
}
