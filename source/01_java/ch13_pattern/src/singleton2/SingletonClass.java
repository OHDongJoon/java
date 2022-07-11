package singleton2;

public class SingletonClass {
	private int i =10;		
							//�ٷ� instance �� ��ü �־���� 
	private static SingletonClass INSTANCE ;

	public static SingletonClass getInstance() {
		//INST����  null �̸� 
				if(INSTANCE == null) { // �ּ� ����� ���� ? �׷� null �̾� ?
					INSTANCE = new SingletonClass(); // �׷� ����� �� �ν��Ͻ����־� 
	}
				return INSTANCE;

	}
	private SingletonClass() {}

	public int getI() {return i;}

	public void setI(int i) {this.i = i;}

	
}
