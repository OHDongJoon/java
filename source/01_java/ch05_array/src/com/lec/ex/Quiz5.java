package com.lec.ex;



//76,45,34,89,100,50,90,92  
//8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시요. 
public class Quiz5 {
	public static void main(String[] args) {
		int [] arr = {76,45,34,89,100,50,90,92}; 
		// 복사 파일 생성
		int[] sortArr = new int[arr.length];//arr 배열 개수 만큼 sortArr 배열에 저장
		for(int i=0 ; i<arr.length ; i++) {
			sortArr[i] = arr[i];
		}
		// 오름차순 정렬
		for(int i=0 ; i<sortArr.length; i++) {// i=0~7까지
			for(int j=i+1 ; j<sortArr.length ; j++) {// j= i+1 ~ 7까지
				// i번째와 j번째 비교해서 i번째가 크면 교환
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				}// if - 교환
			}// for
			
		}// for -i
		System.out.print("원 데이터:");
		for(int temp : arr){
			System.out.print(temp +" ");
		}
		System.out.println("\n 오름차순 정렬데이터:");
		for(int temp : sortArr) {
			System.out.print(temp+" ");
		}
   }
}
