package com.lec.personlnfo;

public class PersonlnfoTestMain {
	public static void main(String[] args) {
	
		Personlnfo p1 = new Personlnfo("È«±æµ¿", 20, 'm');
		Personlnfo p2 = new Personlnfo("È«±æ¼ø", 19, 'f');

		
//		p1.vPrint();
//		p2.vPrint();
//		Personlnfo[] person = { p1, p2 };
//		System.out.println(person);
		
		int[] arr = new int[2];
		Personlnfo[] person1 = new Personlnfo[2];
		person1[0] = new Personlnfo("È«±æµ¿", 20, 'm');
		person1[1] = new Personlnfo("È«±æ¼ø", 19, 'f');
		for (int idx = 0; idx < person1.length; idx++) {
			person1[idx].vPrint();
		}
		for(Personlnfo p : person1) {
			p.vPrint();
		}
			

	}

}
