package com.lec.ex;
//76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  
//��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�. 
public class Quiz3 {
	public static void main(String[] args) {

	int[] num = {76,45,34,89,100,50,90,92};
	int num1 = 0;
	for(int idx=0 ; idx <num.length ; idx ++) {//num[0,1,2,3,4,5,6,7 for������ idx ������ ����]
		num1 += num[idx];//�ʱ�ȭ �� num1�� += num[idx] ���ϱ� 
	
		
	}
	
	System.out.println("������: " + num1);
	int maxnum = num[0]; // �ִ밪
    int minnum = num[0]; // �ּҰ�
	for(int i = 0 ; i<num.length ; i++) {
		if(num[i]<minnum) {
			minnum = num[i];
			
		}
		if(num[i]>maxnum) {
			maxnum = num[i];
			
		}
	}
	System.out.println("������������:"+minnum);
	System.out.println("���� ū����:"+maxnum);
	
}
}