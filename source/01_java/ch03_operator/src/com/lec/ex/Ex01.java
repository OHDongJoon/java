package com.lec.ex;
// 산술 연산자 : + - * / %(나머지)
public class Ex01 {
	public static void main(String[] args) {
		int n1 = 33, n2=10;
		int result; // + - * %의 결과
		double resultDouble; // /의 결과(나머지)
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+' , n2, result); //33+10=43
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-' , n2, result); 
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*' , n2, result); 
		result = n1 % n2; // 나머지
		System.out.printf("%d %c %d = %d\n", n1, '%' , n2, result); 
		resultDouble = (double)n1/n2;
		System.out.printf("%d %c %d = %.1f\n", n1, '/' , n2, resultDouble);
		if (n1%2 == 0) {
			System.out.println("n1은 짝수");
			System.out.println("n1이 짝수라 좋아");
		}else {
			System.out.println("n1은 홀수");
		}//if문
		if (n1 % 5 == 0)
			System.out.println("n1은 5의 배수");
		else
			System.out.println("n1은 5의 배수 아님");
	}
}
