package com.lec.loop;
// 사용자로부터 입력받은 단을 구구단으로 출력

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com;
		do {
			com = (int) (Math.random() * 3);
			System.out.print("0가위,1바위,2보");
			you = sc.nextInt();
			if (you == 0) {
				System.out.println("당신은 가위\t");
			} else if (you == 1) {
				System.out.println("당신은 바위\t");
			} else if (you == 2) {
				System.out.println("당신은 보자기\t");
			} else {
				System.out.println("당신은 잘못내셨습니다.바이");
				you = 3; // 끝내기 위한 조건
			}
			if (you != 3) {// 컴퓨터가 낸 것과 승패 출력
				// 스트링 msg 변수 = 컴이 0이냐? 맞으면 컴터가위 : 컴이 1이냐 ? 맞으면 바위 아니면 보자기
				String msg = (com == 0) ? "컴퓨터는 가위" : (com == 1) ? "컴터 바위" : "컴터 보자기";
				System.out.println(msg);// 컴퓨터가 낸거 출력
				// 경우의 수가 3가지 : 졌다, 이겼다, 비겼다
				if((you + 1)%3== com) {
					System.out.println("당신이 졌다.");
					break;// 빠져나가는
				}else if(you==com) {
					System.out.println("비겼다.");
				}else {
					System.out.println("당신이 이겼어요");
				}// if - 승패 출력
				
				}//if
		}while(true);
		System.out.println("안녕");
}
}
