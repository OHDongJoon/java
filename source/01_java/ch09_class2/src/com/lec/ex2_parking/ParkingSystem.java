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
		System.out.println("\""+ no +"\"�� �������");
		System.out.println("�����ð�: " + inTime+"��");
		System.out.println("************************");
	}
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)*Constant.HOURLYPARKINGRATE;
		System.out.printf("%s�� �ȳ���������\n" ,no);
		System.out.printf("�����ð� :%d��\n", inTime);
		System.out.printf("�����ð�:%d��\n", outTime);
		System.out.printf("������� : %d��\n", fee);
		System.out.print("************************");
	}
	public void out() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(inTime+"�ÿ� ��� ���̴´µ� ��ÿ� ó������???:");
		outTime = scanner.nextInt();
		out(outTime);
		scanner.close();
	}



}
