package com.lec.condition;

import java.util.Scanner;

//0 <= Math.random() <1
// 0 <= Math.random()*3 < 3
//0 <= (int)(Math.random()*3) < 3 : 0,1,2, ���� �ϳ�
public class Ouiz5_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com = (int) (Math.random() * 3);
		System.out.print("����(0) ����1 ��2 �� ����");
		you = sc.nextInt();// ������ �Է� ����
		if (you == 0) {
			System.out.println("����� ����\t");
		} else if (you == 1) {
			System.out.println("����� ����\t");
		} else if (you == 2) {
			System.out.println("����� ���ڱ�\t");
		} else {
			System.out.println("����� �߸����̽��ϴ�.����");
			you = 3; // ������ ���� ����
		}
		if (you != 3) {// ��ǻ�Ͱ� �� �Ͱ� ���� ���
			// ��Ʈ�� msg ���� = ���� 0�̳�? ������ ���Ͱ��� : ���� 1�̳� ? ������ ���� �ƴϸ� ���ڱ�
			String msg = (com == 0) ? "��ǻ�ʹ� ����" : (com == 1) ? "���� ����" : "���� ���ڱ�";
			System.out.println(msg);// ��ǻ�Ͱ� ���� ���
			// ����� ���� 3���� : ����, �̰��, ����
			if((you + 1)%3== com) {
				System.out.println("����� ����.");
			}else if(you==com) {
				System.out.println("����.");
			}else {
				System.out.println("����� �̰���");
			}// if - ���� ���
			
			}//if
		}//main

	}// class
