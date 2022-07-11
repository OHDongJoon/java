package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		//TreeSet<Integer> lotto = new TreeSet<Integer>();  //중복값을 어쩔수 없이 걸러야 될때 사용한다 
		Random random = new Random();
		int cnt = 0;
		while (lotto.size() < 6) {
			cnt ++;
			lotto.add(random.nextInt(45) + 1); // 1~45 사이의 정수 난수 add 중복된 번호 나오면 반복
		}
		System.out.println(cnt + "번 숫자 뽑아 나온" +lotto);
	}
}
