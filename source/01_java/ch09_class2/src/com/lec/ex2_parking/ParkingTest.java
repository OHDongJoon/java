package com.lec.ex2_parking;

public class ParkingTest {

	public static void main(String[] args) {
	ParkingSystem car1 = new ParkingSystem("111라1111",9);
	ParkingSystem car2 = new ParkingSystem("212라222",9);
	car1.out();// 사용자에게 outTime 받기
	car2.out(16);
	}

}
