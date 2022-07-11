package singleton1;

public class SingletonClass {
	private int i ;
	//public ���� private �� �ٲ� �׷��� ���� �׷��� ��ü ������ ���⼭ �ۿ� ���� 
	// ��ü ������� ? �׷� �װ� ��  ��ü���������� �� ��ü �ּҸ� return �ϰ� 
	// ��ü ����? ����� ��ü������ �������� ��ü �����ϰ� �� �ּҸ� return
	
	// ��ü �ּҸ� ���� �վ�߉� private static Ŭ�����̸� 
	private static SingletonClass INSTANCE = new SingletonClass(); 
	public static SingletonClass getInstane() {
			return INSTANCE;
		}
		
	private SingletonClass() {}

	public int getI() {return i;}

	public void setI(int i) {this.i = i;}
	
}
