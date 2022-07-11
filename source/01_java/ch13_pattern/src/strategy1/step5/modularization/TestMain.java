package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHight;
// 5�ܰ� : ����� ��ǰȭ - > ���������� �����ϰ� 
import strategy1.step4.interfaces.FlyNo;

public class TestMain {
	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = { superR, standardR, lowR };

	//}
	// lowR.setFly(new FlyYes()); 5�ܰ迡��
	// SuperRobot ���׷��̵� ��û : �����ֽ��ϴ� ���� ���� ��������մϴ�
	// ��������ϴ� ��ǰ ����� setFly�� ȣ�� �ϸ� ��
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