package com.lec.ex6_wrapper;

import java.util.Scanner;

//»ç¿ëÀÚ·ÎºÎÅÍ Á¤¼ö¹®ÀÚ¿­À»("100 ") ÀÔ·Â¹Ş¾Æ  Á¤¼ö·Î ¼öÁ¤ÇØ¼­ Ãâ·ÂÇÏ´Â ÇÁ·Î±×·¥
public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
		String numStr = scanner.nextLine();
		System.out.println("ÀÔ·ÂÇÏ½Å ¹®ÀÚ¿­Àº "+ numStr);
		numStr = numStr.trim();// ÁÂ¿ì space°¡ »ı·«µÈ´Ù
		numStr = numStr.replaceAll("[a-zA-Z°¡-ÆR]", "");//¹®ÀÚ Á¦°Å
		int num = Integer.parseInt(numStr);
		System.out.println("º¯ÇüµÈ Á¤¼ö´Â" + num);
		
	}
}
