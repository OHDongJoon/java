package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {
	  // CalTestMain   - > Calculation 의존 
	public static void main(String[] args) {
	 //   Calculation cal = new Calculation();
	   // cal.setNum1(50);
	 //   cal.setNum2(10);
		AbstractApplicationContext ctx 
		  				= new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Calculation cal = ctx.getBean("calculation" , Calculation.class);
	    cal.add();
	    cal.sub();
	    cal.mul();
	    cal.div();
	    System.out.println(cal);
	    
	}
}
