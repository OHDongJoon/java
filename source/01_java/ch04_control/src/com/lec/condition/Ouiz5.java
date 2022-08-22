package com.lec.condition;

import java.util.Scanner;

//0 <= Math.random() <1
// 0 <= Math.random()*3 < 3
//0 <= (int)(Math.random()*3) < 3 : 0,1,2, 중의 하나
public class Ouiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com = (int) (Math.random() * 3);
		System.out.print("가위(0) 바위1 보2 중 선택");
		you = sc.nextInt();// 정수를 입력 받음
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
			if (you == 0) { // 너가 0을 냈으면
				if (com == 0) { // 0하고 컴터랑 같으면
					System.out.println("비겼다");
				} else if (com == 1) {// 컴이 1(바위)
					System.out.println("컴퓨터가 이겼다");
				} else {// 컴터가 보를 냈으면
					System.out.println("당신이 이겼다.");
				}

			} else if (you == 1) {
				if (com == 0) {
					System.out.println("당신이 이겼다");
				} else if (com == 1) {
					System.out.println("비겼다");
				} else {
					System.out.println("컴퓨터가 이겼다.");
				}

			} else if (you == 2) {
				if (com == 0) {
					System.out.println("컴퓨터가 이겻다.");
				} else if (com == 1) {
					System.out.println("당신이 이겼다");
				} else {
					System.out.println("비겼다");
				}
			}
		}

	}
}