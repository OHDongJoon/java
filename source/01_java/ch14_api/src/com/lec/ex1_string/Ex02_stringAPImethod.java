package com.lec.ex1_string;
//concat : ¹®ÀÚ¿­ °áÇÕ
//substring (3) 3¹øÀç ºÎÅÍ ³¡±îÁö
public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc"; // ³ë»ı¼º
		String str2 = new String("ABCXabc"); //°´Ã¼¸¦»ı¼º
		String str3 = "            ja       va        ";	
		System.out.println("1."+ str1.concat(str2)); // ¹®ÀÚ¿­ °áÇÕ abc Xabc + ABCXabc // concat : Strig Å¸ÀÔ +
		                                               
										//substring :		//  0 1 2 3~~~~ 
		System.out.println("2."+str1.substring(3)); // str1 :   a b c X a b c   // XabcÃâ·Â
		System.out.println("3."+str1.substring(3,5)); // 3¹øÀç ºÎÅÍ 5¹øÀç ¾Õ±îÁö     X , a
		System.out.println("4."+str1.length()); // ±ÛÀÚ±æÀÌ
		System.out.println("5."+str1.toUpperCase()); // ´ë¹®ÀÚ·Î º¯°æABC
		System.out.println("6."+str1.toLowerCase()); // ´ë¹®ÀÚ¿¡¼­ ¼Ò¹®ÀÚ º¯°æ ¼Ò¹®ÀÚ´Â ±×´ë·Î 
		System.out.println("7."+str1.charAt(3)); // 3¹øÂ° ¹®ÀÚ 'x'
		System.out.println("8."+str1.indexOf('b')); // Ã¹¹øÂ° 'b'°¡ ³ª¿À´Â À§Ä¡
		System.out.println("9."+str1.indexOf('c', 3));// 3¹øÀçºÎÅÍ °Ë»öÇØ¼­ Ã¹¹øÂ° bÀ§Ä¡
		System.out.println("10."+str1.indexOf("abc"));// Ã¹¹øÂ° "abc" ³ª¿À´Â À§Ä¡ 0
		System.out.println("11."+str1.indexOf("abc",3));// 3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ "abc" À§Ä¡ 4
		System.out.println("12."+str1.indexOf('z'));// ¾øÀ¸¸é -1
		System.out.println("13."+str1.lastIndexOf('b'));// ¸¶Áö¸·¿¡ ÀÖ´Â  'b' À§Ä¡ 4 
		System.out.println("14."+str1.lastIndexOf('b',3)); //3¹øÀçºÎÅÍ ¸Ç ¸¶Áö¸· b ¸¦ ----------------------------------- ?
		System.out.println("---------------------------");
		System.out.println("15."+str1.equals(str2)); // str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö false
		System.out.println("16."+str1.equalsIgnoreCase(str2));// ´ë¼Ò¹®ÀÚ±¸ºĞ¾øÀÌ ºñ±³ true----------------------------??
		System.out.println("17."+str3.trim()); //¾ÕµÚ°ø¹éÁ¦°Å // Áß°£ °ø¹éÁ¦°Å´Â ¸øÇÔ
		System.out.println("18."+str1.replace('a', '9')); //a¸¦ 9·Î ¼öÁ¤
		System.out.println("19."+str1.replace("abc", "¤±"));// abc¸¦ ¤±À¸·Î ¼öÁ¤
		System.out.println("str3ÀÇ space¸¦ ¾ø¾Ö±â:"+str3.replace(" ", ""));
		System.out.println("20."+str1.replaceAll("abc", "¤±")); // abc¸¦ "z"
		/* Á¤±ÔÇ¥Çö½Ä http://goo.gl/HLntbd
		 * 				¿¬½ÀÀå : http://www.nextree.co.kr/p4327
		 */
		// replaceAll ¿µ¾î¸¸ Áö¿ö ÇÑ±Û¸¸Áö¿ö   ÀÏ¹İ rplace´Â ¿µ¾î¸¹À¸¸é ¾ğÁ¦ ´ÙÃ£¾Æ
		String str = "¾È³çHello"; // ¿µ¹®ÀÚ ´Ù *·Î ½á 
		System.out.println(str.replaceAll("[a-zA-Z]", "" ));// ¾ËÆÄºªÀ» ""·Î ¼öÁ¤
		System.out.println(str.replaceAll("[°¡-ÆR]", ""));// ÇÑ±Û¹®ÀÚ¸¦ "" ·Î ¼öÁ¤
		//¹®ÀÚ¿­ ¸Ş¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤ ¾ÈÇÔ 
		// ±×´ë·Î ÀÖÀ½ 
		System.out.println("str1 = "+ str1);
		System.out.println("str2 = "+ str2);
		System.out.println("str3 = "+ str3);
		
 	}
}
