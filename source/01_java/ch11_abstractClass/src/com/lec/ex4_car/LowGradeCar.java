package com.lec.ex4_car;
// Car ��� �ٿͶ�~   getSpec(�߻�޼ҵ�)  Car���� �߰��� ������ : tax �߰���
// Car c = new LowGrandeCar("����","����",1490(cc),"�Ŀ�")
public class LowGradeCar extends Car {
	private int tax;
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000; // �����ڿ��� ������ �ʱ�ȭ�ϴ¹�
	}

	@Override
	public void getSpec() { // spec(���� , Ÿ�̾�, ��ⷮ, �ڵ�, ����)�� ���  
		if(getDisplacement() > 1000) {
			tax += (getDisplacement()-1000)*100;
		}
		System.out.println("�� �� : "+ getColor());
		System.out.println("Ÿ�̾� : "+ getTire());
		System.out.println("��ⷮ: "+ getDisplacement());
		System.out.println("�ڵ� : "+ getHandle());
		System.out.println("���� : "+ tax);
		System.out.println("--------------------------------");
	}

}
