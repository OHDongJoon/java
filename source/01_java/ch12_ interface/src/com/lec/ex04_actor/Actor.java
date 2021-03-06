package com.lec.ex04_actor;
// 슬기
// 6개 메소드 - 추상메소드 오버라이드를 강요
public class Actor implements IChef, IPoliceMan, IFireFighter {
	private String name ;
	public Actor(String name) {
		this.name = name ;
	}
	@Override
	public void outFire() {
		System.out.println(name+"는 불을끌수있습니다");
	}

	@Override
	public void saveMan() {
		System.out.println(name+"는 사람을 구할 수 있습니다");

	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name+"는 범인을 잡습니다");

	}

	@Override
	public void canSearch() {
		System.out.println(name+"는 찾을 수 있습니다");

	}

	@Override
	public void makePizza() {
		System.out.println(name+"는 피자를 요리할 수 있습니다");

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name+"은 스파게티를 요리할수 있습니다");

	}
	public String getName() {
		return name;
	}
	
	

}
