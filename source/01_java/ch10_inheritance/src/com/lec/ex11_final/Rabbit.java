package com.lec.ex11_final;
//������ final �� �� ��⶧���� �ٸ����� ��� ������ 
// animal �κ��� ��ӹ��� rabbit Ŭ���� ����
public final class Rabbit extends Animal {
	@Override
	public void running() {
		setSpeed(getSpeed()+30);
		System.out.println("�䳢�� �����پ�� . ����ӵ�:" +getSpeed());
	}
}
