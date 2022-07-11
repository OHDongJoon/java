package com.lec.ex;
//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  
//평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요. 
public class Quiz3 {
	public static void main(String[] args) {

	int[] num = {76,45,34,89,100,50,90,92};
	int num1 = 0;
	for(int idx=0 ; idx <num.length ; idx ++) {//num[0,1,2,3,4,5,6,7 for문으로 idx 변수에 저장]
		num1 += num[idx];//초기화 된 num1에 += num[idx] 더하기 
	
		
	}
	
	System.out.println("총합은: " + num1);
	int maxnum = num[0]; // 최대값
    int minnum = num[0]; // 최소값
	for(int i = 0 ; i<num.length ; i++) {
		if(num[i]<minnum) {
			minnum = num[i];
			
		}
		if(num[i]>maxnum) {
			maxnum = num[i];
			
		}
	}
	System.out.println("제일작은수는:"+minnum);
	System.out.println("제일 큰수는:"+maxnum);
	
}
}