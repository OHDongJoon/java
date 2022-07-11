package strategy1.step5.modularization;

import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;

public abstract class Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;

	public void actionWalk() {
		System.out.println("������ �ֽ��ϴ�");
	}

	public void actionRun() {
		System.out.println("�� �ֽ��ϴ�");

	}

	public void shape() {
		String className = getClass().getName(); // strategy1.step2.Super Robot
		//
		int idx = className.lastIndexOf('.'); // idx Ŭ������ ���ӿ� �� ������'.'�� �ִ� ��ġ
		String name = className.substring(idx + 1); // idx + 1��° �۾����� ������
		System.out.println(name + "������ ��, �ٸ�, ����, �Ӹ��� �ֽ���");

	}

	
	public void actionMissile() {
		missile.missile();

	}


	public void actionKnife() {

		knife.knife();
	}

	public void actionFly() {
		fly.fly();
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