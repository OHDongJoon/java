package com.lec.ch05.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //쫘아악 파싱?
public class ProxyClass2 {
	// aroundAdvice 공통 기능 throws 하지만 finally 하는 이유는 핵심기능을 수행한후 return 해준 뒤에도 수행해야할 일들이 있을수도 있어서 
	/*
	 * @Pointcut("within(com.lec.ch05.ex2.*)") //객체니가 within private void aroundM()
	 * {} // 아이디 지정
	 * 
	 * @Around("aroundM()") // 이건 aroundAdvice를 aroundM() 으로 지정하겠다.
	 */ 
		@Around("within(com.lec.ch05.ex2.*)")
	 	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable { //ProceedingJoinPoint   : joinPoin 가르키는아이
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toString(); // 핵심기능 메소드명
		System.out.println(signatureName + "가 시작되었습니다");
		long startTime = System.currentTimeMillis(); // 시작 시점 
		try {
			Object obj = joinPoint.proceed(); // 핵심기능  실행
			return obj;
		} finally {
			long endTime = System.currentTimeMillis(); // 핵심기능 수행 후 시점
			System.out.println(signatureName + "가 수행되는 경과 시간" + (endTime-startTime));
		}
		
	}
	// befoereAdvice
		@Before("execution(* com.lec.ch05.ex2.Student2.*())")
	public void beforeAdvice() {
		System.out.println("핵심기능 수행하기 전 알아서 beforeAdvice(공통기능) 수행");
	}
	// afterAdvice
		@After("bean(stud*)")
	public void afterAdvice() {
		System.out.println("핵심기능 수행하고 알아서 afterAdvice(핵심기능) 수행");
	}
	// after-returning Advice
		@AfterReturning("within(com.lec.ch05.ex2.Worker2)")
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외발생되지 않고) 핵심기능이 수행된 후 이  afterReturningAdvice  수행 ");
	}
	// after-thrwing Advice
		@AfterThrowing("execution(void com.lec.ch05.ex2.Worker2.get*())")
	public void afterThrowingAdvice() {
		System.out.println("★ 예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice 수행");
	}
}
