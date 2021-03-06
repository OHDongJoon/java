package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;


public class StandardRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public StandardRobot() {
		setFly(new FlyNo());  // fly = new FlyNO();
		setMissile(new MissileYes());
		setKnife(new KnifeWood()); //= new KnifeWood();
	}


}
