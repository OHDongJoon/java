package com.lec.ch02.ex2_bmi;

import java.util.ArrayList;

import lombok.Data;
@Data  
public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobby;
	private BMICalculator bmiCalculator;   // BMICalculator.java 를 의존 받음
	private void bmiCal() {
		bmiCalculator.bmiCalculation(weight, height);
	}
	public void getInfo() {
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("취미 : " + hobby); // 한개 앤 여러개 입력 할 수도 있으
		bmiCal();

		
	}
}
