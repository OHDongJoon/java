package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHight;
// 5단계 : 기능을 부품화 - > 유지보수를 간편하게 
import strategy1.step4.interfaces.FlyNo;

public class TestMain {
	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = { superR, standardR, lowR };

	//}
	// lowR.setFly(new FlyYes()); 5단계에서
	// SuperRobot 업그레이드 요청 : 날수있습니다 에서 높이 고공비행합니다
	// 고공비행하는 부품 만들어 setFly만 호출 하면 끝
	superR.setFly(new FlyHight());
	for(Robot robot:robots){
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
	}
}}