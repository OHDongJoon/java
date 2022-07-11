package com.lec.ex04_actor;

public class TestMain {
	public static void main(String[] args) {
		Actor sle = new Actor("슬기");
		sle.canCatchCriminal();
		sle.canCatchCriminal();
		sle.outFire();
		sle.saveMan();
		sle.makePizza();
		sle.makeSpaghetti();
		System.out.println("--------------------");
		IChef chefSle = new Actor("슬기");
//		chefSle.cnaCatch 불가
		System.out.println("--------요리사------");
		chefSle.makePizza();
		chefSle.makeSpaghetti();
		IFireFighter firSle =new Actor("슬기");
		System.out.println("-----소방관--------");
		firSle.outFire();
		firSle.saveMan();
		IPoliceMan policeSle = new Actor("슬기");
		System.out.println("--------경찰-----------");
		policeSle.canCatchCriminal();
		policeSle.canSearch();
		
		
	}
	
}
