package com.lec.ch03.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TextMain {
	public static void main(String[] args) {
		
	
	//IOC 컨테이너 생성 (환경설정)
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	// 파싱
	ctx.load("classpath:META-INF/ex2/applicationCTX.xml");
	ctx.refresh(); // 빈생성
	System.out.println("------------------------------------");
	Person person = ctx.getBean("person", Person.class);
	System.out.println(person);
	OtherPerson otherPerson = ctx.getBean("otherPerson" , OtherPerson.class);
	System.out.println(otherPerson);
	System.out.println("------------------------------------------");
	ctx.close();
	System.out.println("빈 소멸 ! ");
	}
}
