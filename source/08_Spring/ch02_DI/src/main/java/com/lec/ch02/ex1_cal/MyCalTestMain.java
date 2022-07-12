package com.lec.ch02.ex1_cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyCalTestMain {
	public static void main(String[] args) {
		// applicationCTX1.xml 불러오기 ?
		String resourceLocation = "classpath:applicationCTX1.xml";
		// 불러오기 객체 ?
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		MyCalculator myCalculator = ctx.getBean("myCal", MyCalculator.class);
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
	}
	
}
