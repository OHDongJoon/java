package com.lec.ex;
//�Ϲ� for�� vs. Ȯ�� for�� (�迭  ���)
// �Ϲ� for���� �迭 ���氡��
// Ȯ��for���� �迭 ���� �Ұ�
public class Ex02 {

	public static void main(String[] args) {
		int[] arr =new int[3]; //{0,0,0}  0 0 0 ���� �ʱ�ȭ ���� (�迭)
		// idx ���� = 0 , 0�� arr�������������� ����
		for(int idx=0 ; idx<arr.length; idx++ ) {
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for(int temp : arr) {//Ȯ�� for ���� �̿��� ���
			System.out.println(temp);
		}
		for (int i=0 ; i<arr.length ; i++) { //�Ϲ� for���� �̿��� �迭 ���� ����
			arr[i] = 5;
		
		}
		for(int temp : arr) {//Ȯ�� for���� �迭 ���� �Ұ�
			temp = 9;
	}
	System.out.println("������");
		for(int temp : arr) {//Ȯ�� for ���� �̿��� ���
		System.out.println(temp);

    }
  }
}
