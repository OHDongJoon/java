package com.lec.ex;



//76,45,34,89,100,50,90,92  
//8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� �̵� ������ ũ�� ������ ��Ÿ���� ���α׷��� �ۼ� �Ͻÿ�. 
public class Quiz5 {
	public static void main(String[] args) {
		int [] arr = {76,45,34,89,100,50,90,92}; 
		// ���� ���� ����
		int[] sortArr = new int[arr.length];//arr �迭 ���� ��ŭ sortArr �迭�� ����
		for(int i=0 ; i<arr.length ; i++) {
			sortArr[i] = arr[i];
		}
		// �������� ����
		for(int i=0 ; i<sortArr.length; i++) {// i=0~7����
			for(int j=i+1 ; j<sortArr.length ; j++) {// j= i+1 ~ 7����
				// i��°�� j��° ���ؼ� i��°�� ũ�� ��ȯ
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				}// if - ��ȯ
			}// for
			
		}// for -i
		System.out.print("�� ������:");
		for(int temp : arr){
			System.out.print(temp +" ");
		}
		System.out.println("\n �������� ���ĵ�����:");
		for(int temp : sortArr) {
			System.out.print(temp+" ");
		}
   }
}
