package strategy1.step3;

public class LowRobot extends Robot {
	@Override
	public void actionFly() {
		System.out.println("날 수 없습니다");
	}
	@Override
	public void actionMissile() {
		System.out.println("미사일 없어");

	}
	@Override
	public void actionKnife() {
		System.out.println("검 없어");

	}
}
