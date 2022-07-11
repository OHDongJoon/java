package com.lec.ex2_parking;

import java.util.Scanner;

import com.lec.cons.Constant;

// no, inTime outTime fee

// out(in)

public class ParkingSystem {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	//private final int HOURLYPARKINGRATE=2000;
	public ParkingSystem(){}
	public ParkingSystem(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		inPrint();
		
	}
	private void inPrint() {
		System.out.println("\""+ no +"\"님 어서오세요");
		System.out.println("입차시간: " + inTime+"시");
		System.out.println("************************");
	}
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)*Constant.HOURLYPARKINGRATE;
		System.out.printf("%s님 안녕히가세요\n" ,no);
		System.out.printf("입차시간 :%d시\n", inTime);
		System.out.printf("출차시간:%d시\n", outTime);
		System.out.printf("주차요금 : %d원\n", fee);
		System.out.print("************************");
	}
	public void out() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(inTime+"시에 들어 오셨는는데 몇시에 처나가냐???:");
		outTime = scanner.nextInt();
		out(outTime);
		scanner.close();
	}



}
