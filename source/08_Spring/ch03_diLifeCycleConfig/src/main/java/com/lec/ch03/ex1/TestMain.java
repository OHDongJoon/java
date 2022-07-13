package com.lec.ch03.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class TestMain { // 파싱 두개 
	public static void main(String[] args) {
		String resourceLocation1 = "classpath:META-INF/ex1/applicationCTX1.xml";
		String resourceLocation2 = "classpath:META-INF/ex1/applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation1,resourceLocation2);
		
		Student student = ctx.getBean("student" , Student.class); // Bean 가져오기  "student"는 ctx1.xml에 있는 8번줄
		System.out.println("student :" + student);
		StudentInfo studentInfo = ctx.getBean("studentInfo" , StudentInfo.class); // "studentInfo" 는 ctx1.xml 19번줄
		System.out.println("studentInfo의 student : " + studentInfo.getStudent());
		if(student.equals(studentInfo.getStudent())) {
			System.out.println("두  객체가 같다 ");
		}
		Family family = ctx.getBean("family" , Family.class);
		System.out.println(family);
		ctx.close(); // 컨테이너 소멸 = 컨테이너 안의 빈 자동 소멸 
	}
	

}
