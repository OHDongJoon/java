package com.lec.ex04_actor;

public class TestMain {
	public static void main(String[] args) {
		Actor sle = new Actor("����");
		sle.canCatchCriminal();
		sle.canCatchCriminal();
		sle.outFire();
		sle.saveMan();
		sle.makePizza();
		sle.makeSpaghetti();
		System.out.println("--------------------");
		IChef chefSle = new Actor("����");
//		chefSle.cnaCatch �Ұ�
		System.out.println("--------�丮��------");
		chefSle.makePizza();
		chefSle.makeSpaghetti();
		IFireFighter firSle =new Actor("����");
		System.out.println("-----�ҹ��--------");
		firSle.outFire();
		firSle.saveMan();
		IPoliceMan policeSle = new Actor("����");
		System.out.println("--------����-----------");
		policeSle.canCatchCriminal();
		policeSle.canSearch();
		
		
	}
	
}
