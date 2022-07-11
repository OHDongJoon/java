package com.lec.ex2_human.main;

// * (모든걸임폴트해랏ㅂ): com.lec.ex2_human 패키지 모든 class를 import한다
// 불필요한 package import 삭제 : 클릭한거만 임폴트하는법 컨+ 쉬+ o 임폴트해줌
import com.lec.ex2_human.*;// 항상 끝나기전에  컨 쉬 o

//우먼 임폴트 100개면 100개 다 임폴트됨 * 으로 
public class TestMain {

	public static void main(String[] args) {
		int i = 10; // 기본 데이터
		int j = 10;

		if (i == j) {// 기초 데이터 타입에서의 같은지 비교
			System.out.println("i와j같다");
		}

		String name = "홍길동";
		String name2 = "홍길동"; // 같은 홍길동(주소) 들어 있으면 name2 값은 name 들어간다 String만
		if (name.equals(name2)) {// 객체변수가 같은지 비교식
			System.out.println("name과 name2 같다");
		}
		Woman hee1 = new Woman(); // 클릭한거만 임폴트하는법 컨+ 쉬+ o 임폴트해줌
		Woman hee2 = new Woman();
		// hee1.method();
		// 객체 객체 같은지 : equals
		if (hee1.equals(hee2)) {
			System.out.println("hee 와 hee2같다");
		}
		Man kang = new Man(22,165,60.2);
		Man kim = new Man(22,180,65.6);
		Man kim1;
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6);
		if(kim.equals(kim1)) {
			System.out.println("kim과kim1은 같다(같은 주소를 가르킨다)");
		}
		if(!kim.equals(kim2)) {
			System.out.println("kim과 kim2는 다른 객체다(다른 주소 값이 있다)");
	}	
		
		kang.setHeight(160);
		kang.setWeight(50.9); //51은 묵시적인 형변환(double형으로)
		if(kang.calculateBMI() > 30) {
		// bmi 출력하는법	System.out.print(kang.calculateBMI());
			System.out.println("건강하세요");
		}else {
			System.out.println("건강하겠네요");
		}
		
		
	}

}
