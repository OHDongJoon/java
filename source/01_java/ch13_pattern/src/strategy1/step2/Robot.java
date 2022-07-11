package strategy1.step2;
// Robot�� ��ӹ��� Ŭ���� : SuperRobot, StandardRobot, LowRobot
public class Robot {
	public void actionWalk() {
		System.out.println("������ �ֽ��ϴ�");
	}
	public void actionRun() {
		System.out.println("�� �ֽ��ϴ�");

	}
	public void shape() {
		String className = getClass().getName(); // strategy1.step2.Super Robot
		//
		int idx = className.lastIndexOf('.'); // idx Ŭ������ ���ӿ�  �� ������'.'�� �ִ� ��ġ
		String name = className.substring(idx+1); // idx + 1��° �۾����� ������ 
		System.out.println(name + "������ ��, �ٸ�, ����, �Ӹ��� �ֽ���");

	}
}
