package com.lec.ch02.ex1_cal;

import lombok.Data;

@Data
public class MyCalculator {

		private Calculator calculator;
		private int num1;
		private int num2;
		public void add() {  // 더하기
			calculator.addition(num1, num2);
		}
		public void sub() { // 빼기
			calculator.subtraction(num1, num2);
		}
		public void mul() { // 곱하기
			calculator.multiplication(num1, num2);
		}
		public void div() { // 나누기
			calculator.division(num1, num2);
		}
}
