package com.lec.ch03.ex2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor   //모든 생성자함수
public class Person implements InitializingBean , DisposableBean, EnvironmentAware{  //InitializingBean 추상 메소드
	private String name;
	private String tel;
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("Person 형 빈 객체 생성하자마자 실행 1  : setEnvironment()");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception { // afterPropertiesSet : 빈을 생성하마자 실행 하는 아이 
		System.out.println("Person 형 빈 객체 생성하자마자 실행  2 : afterPropertlisSet()");
		
		
	}
	@Override
	public void destroy() throws Exception { // destroy :
		System.out.println("Person 형 빈 소멸 바로 전 실행 :  destroy() 호출" );
		
	}
}
