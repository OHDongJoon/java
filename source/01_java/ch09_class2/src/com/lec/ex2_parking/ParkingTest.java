package com.lec.ex2_parking;

public class ParkingTest {

	public static void main(String[] args) {
	ParkingSystem car1 = new ParkingSystem("111��1111",9);
	ParkingSystem car2 = new ParkingSystem("212��222",9);
	car1.out();// ����ڿ��� outTime �ޱ�
	car2.out(16);
	}

}
