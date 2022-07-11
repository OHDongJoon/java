package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;

public class LowRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;

	@Override
	public void actionFly() {
		setFly(new FlyNo());// fly = new FlyNo();
		setMissile(new MissileNo());// missile = new MissileNo();
		setKnife(new KnifeNo());// knife = new KnifeNo();

	}

	@Override
	public void actionMissile() {
		fly.fly();

	}

	@Override
	public void actionKnife() {

		missile.missile();
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

}
