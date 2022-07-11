package com.lec.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
		}

	private void actionC() throws Exception { //throws 나를 호출 한곳으로 뿌려버려  여기는 위로가야징?
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}
	private void actionB() throws RuntimeException {//throws 있으니 나를 호출한곳으로 위로!
	   System.out.println("actionB  전반부");
	  // try {
		   actionA(); //2. 요기가 호출한 곳이지 actionA 에 예외처리부분 
	//}catch(ArrayIndexOutOfBoundsException e) { //3. 예외처리한 부분 던지고  밑으로 실행 안함
	//	System.out.println("예외 :" + e.getMessage());
	//}
	 //  System.out.println("actionB 후반부");
		}
	private void actionA() throws ArrayIndexOutOfBoundsException {// 1.예외가 되면 나를 호출 한곳으로 뿌려준다
		System.out.println("actionA 전반부");
		int[] arr = {0,1,2,3};
		System.out.println(arr[4]);//Exception
		System.out.println("actionA 후반부");
	}
}
