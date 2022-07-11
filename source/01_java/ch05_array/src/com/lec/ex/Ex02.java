package com.lec.ex;
//일반 for문 vs. 확장 for문 (배열  출력)
// 일반 for문은 배열 변경가능
// 확장for문은 배열 변경 불가
public class Ex02 {

	public static void main(String[] args) {
		int[] arr =new int[3]; //{0,0,0}  0 0 0 으로 초기화 됬어용 (배열)
		// idx 변수 = 0 , 0이 arr보다작을때가지 돌려
		for(int idx=0 ; idx<arr.length; idx++ ) {
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for(int temp : arr) {//확장 for 문을 이용한 출력
			System.out.println(temp);
		}
		for (int i=0 ; i<arr.length ; i++) { //일반 for문을 이용한 배열 변경 가능
			arr[i] = 5;
		
		}
		for(int temp : arr) {//확장 for문을 배열 변경 불가
			temp = 9;
	}
	System.out.println("수정후");
		for(int temp : arr) {//확장 for 문을 이용한 출력
		System.out.println(temp);

    }
  }
}
