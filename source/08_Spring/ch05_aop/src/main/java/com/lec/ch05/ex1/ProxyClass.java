package com.lec.ch05.ex1;

import org.aspectj.lang.ProceedingJoinPoint;


public class ProxyClass {
	// aroundAdvice 공통 기능 throws 하지만 finally 하는 이유는 핵심기능을 수행한후 return 해준 뒤에도 수행해야할 일들이 있을수도 있어서 
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
	public void beforeAdvice() {
		System.out.println("핵심기능 수행하기 전 알아서 beforeAdvice(공통기능) 수행");
	}
	// afterAdvice
	public void afterAdvice() {
		System.out.println("핵심기능 수행하고 알아서 afterAdvice(핵심기능) 수행");
	}
	// after-returning Advice
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외발생되지 않고) 핵심기능이 수행된 후 이  afterReturningAdvice  수행 ");
	}
	// after-thrwing Advice
	public void afterThrowingAdvice() {
		System.out.println("★ 예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice 수행");
	}
}
