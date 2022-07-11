package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999 kok3443@naver.com (02)565-8888 ¹İ°©½À´Ï´Ù.  Hello 951010-144234";
		//System.out.println("replace => "+ str.replace("0","È«±æµ¿")); //0 ¸¸ È«À¸·Î ¹Ù²ñ 
		/*Á¤±ÔÇ¥Çö½Ä(regex)
		 1. ÂüÁ¶ : https://goo.g1/HLntbd
		Á¤±ÔÇ¥Çö½Ä

		Æ¯Á¤ÇÑ ±ÔÄ¢À» °¡Áø ¹®ÀÚ¿­ÀÇ ÁıÇÕ
		 2. °£·«ÇÑ ¹®¹ı
		        \d(¼ıÀÚ¿Í ¸ÅÄ¡, [0-9] ¿Í µ¿ÀÏ \D(¼ıÀÚ°¡ ¾Æ´Ñ°Í)
				\s (whitespacen : space, ÅÇ , ¿£ÅÍ)
				\W (¿µ¹®ÀÚ³ª ¼ıÀÚ, [a-zA-ZO-9] \W(¿µ¹®ÀÚ³ª ¼ıÀÚ°¡ ¾Æ´Ñ ¹®ÀÚ)
				   .(¹®ÀÚ ÇÏ³ª)
				   +(1¹øÀÌ»ó ¹İº¹)
				   * (0¹øÀÌ»ó ¹İº¹)
				   ?(0~1¹ø ¹İº¹)
				   {2,4} (2~4È¸ ¹İº¹)
		3. Á¤±ÔÇ¥Çö½Ä ¿¬½ÀÀå https://regexr.com/ https://www.regexpal.com
			ex. ÀüÈ­¹øÈ£ : .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		4. Æ¯Á¤ Á¤±ÔÇ¥Çö½Ä : replaceAll("Á¤±ÔÇ¥Çö½Ä", "´ëÃ¼¹®ÀÚ¿­")
		*/ 
		
		// ÀüÈ­¹øÈ£ Áö¿ò
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}","**ÀüÈ­¹øÈ£Áö¿ò**"));
		// ÀÌ¸ŞÀÏ Áö¿ò
		//[0-9a-zA-Z]  == \w + @  °ñ¹ğÀÌ°¡ ¹«Á¶°Ç ³ª¿À°í \w + .\w +
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**ÀÌ¸ŞÀÏÁö¿ò**"));
		//¾ËÆÄºª ´ë½Å *·Î ´ëÃ¼
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//ÇÑ±Û ½Ï ´Ù ¾ø¾Ö
		System.out.println(str.replaceAll("[°¡-ÆR¤¡-¤¾]", ""));
		// ÁÖ¹Î¹øÈ£
		System.out.println(str.replaceAll("[0-9]{7}","*******"));
	}
}







