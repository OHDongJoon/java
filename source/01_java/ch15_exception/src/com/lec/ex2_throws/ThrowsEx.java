package com.lec.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
		}

	private void actionC() throws Exception { //throws ���� ȣ�� �Ѱ����� �ѷ�����  ����� ���ΰ���¡?
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws RuntimeException {//throws ������ ���� ȣ���Ѱ����� ����!
	   System.out.println("actionB  ���ݺ�");
	  // try {
		   actionA(); //2. ��Ⱑ ȣ���� ������ actionA �� ����ó���κ� 
	//}catch(ArrayIndexOutOfBoundsException e) { //3. ����ó���� �κ� ������  ������ ���� ����
	//	System.out.println("���� :" + e.getMessage());
	//}
	 //  System.out.println("actionB �Ĺݺ�");
		}
	private void actionA() throws ArrayIndexOutOfBoundsException {// 1.���ܰ� �Ǹ� ���� ȣ�� �Ѱ����� �ѷ��ش�
		System.out.println("actionA ���ݺ�");
		int[] arr = {0,1,2,3};
		System.out.println(arr[4]);//Exception
		System.out.println("actionA �Ĺݺ�");
	}
}
