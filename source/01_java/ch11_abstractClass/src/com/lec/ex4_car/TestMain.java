package com.lec.ex4_car;import com.lec.cons.CarSpec;

public class TestMain {
	public static void main(String[] args) {
	//	Car car = new LowGradeCar("ȸ��", "�Ϲ�", 1000, "�Ŀ�");
//		Car car = new LowGradeCar(CarSpec.GRAY_CAR , CarSpec.TIRE_NORMAL,
//					CarSpec.DISPLACEMENT_1000, CarSpec.HANDDLE_POWER);
//		car.getSpec();
		Car car = new HighGradeCar(CarSpec.WHITE_CAR,CarSpec.TIRE_WIDE,
				CarSpec.DISPLACEMENT_2200, CarSpec.HANDDLE_POWER);
		car.getSpec();
	}
}	
