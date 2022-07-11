package com.lec.ex;

// 배열은 1차원 배열 을 주로 쓴다
public class Ex06_multi {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 }; // 1차원 배열
		int[][] test = { { 1, 2, 3, }, 
						{ 4, 5, 6 } };
		System.out.println(arr[2]); // 0~2번 index
		System.out.println(test[0][2]);// 0~1 행 0~2열
		System.out.println("--------------------------");
		for (int i = 0; i < test.length; i++) { // i = 0~1행
			for (int j = 0; j < test[i].length ; j++) {
				System.out.printf("test[%d][%d] %d\n", i, j, test[i][j]);
			}//for - j
		}//for -i
	}
}
