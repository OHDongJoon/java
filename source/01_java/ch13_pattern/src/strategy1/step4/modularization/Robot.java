package strategy1.step4.modularization;

public abstract class Robot {
	public void actionWalk() {
		System.out.println("걸을수 있습니다");
	}
	public void actionRun() {
		System.out.println("뛸 있습니다");

	}
	public void shape() {
		String className = getClass().getName(); // strategy1.step2.Super Robot
		//
		int idx = className.lastIndexOf('.'); // idx 클래스에 네임에  맨 마지막'.'이 있는 위치
		String name = className.substring(idx+1); // idx + 1번째 글씨부터 끝까지 
		System.out.println(name + "외형은 팔, 다리, 몸통, 머리가 있슴다");

	}
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
