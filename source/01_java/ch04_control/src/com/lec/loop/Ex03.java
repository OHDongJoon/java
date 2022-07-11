package com.lec.loop;
//중첩 for 문
//*
//**
//***
//****
//*****
public class Ex03 {

	public static void main(String[] args) {
		for(int j=1; j<=5 ; j++) { // 5회 반복 (j가 1부터 5까지 반복)
			for(int i = 1; i <=j; i++) {// j회 반복(i 가 1부터 j까지 반복)
				System.out.print('*');
			}//for - i
			System.out.println(); // 개행
			
		} // for - j

	}// main

}
