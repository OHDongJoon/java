package com.lec.ch04.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileTestMain {
	public static void main(String[] args) {
		String config = null; //너어떤환경이냐 !
		Scanner sc = new Scanner(System.in);
		System.out.print("dev중허냐? run이 중허냐?");
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
		ctx.getEnvironment().setActiveProfiles(config); //둘중에 하나만 입력받은 애만 가져온다
		ctx.load("META-INF/ex3/CTX_dev.xml" , "META-INF/ex3/CTX_run.xml");
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP :" + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
	}
}
