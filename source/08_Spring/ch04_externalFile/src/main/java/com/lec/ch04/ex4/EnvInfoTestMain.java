package com.lec.ch04.ex4;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EnvInfoTestMain {
	public static void main(String[] args) {
		String config = null; 
		Scanner sc = new Scanner(System.in);
		System.out.print("dev? run?");
		String answer = sc.next();
		if(answer.equals("dev")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.");
			System.exit(0); // 시스템 종료 
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:META-INF/ex4/dev.xml","classpath:META-INF/ex4/run.xml");
		ctx.refresh();
		EnvInfo info = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ipNum : " + info.getIpNum());
		System.out.println("portNum " + info.getPortNum());
		System.out.println("userId :" + info.getUserId());
		System.out.println("userPw :" + info.getUserPw());
	}
}
