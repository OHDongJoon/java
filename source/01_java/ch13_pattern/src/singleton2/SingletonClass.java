package singleton2;

public class SingletonClass {
	private int i =10;		
							//바로 instance 에 객체 넣어버려 
	private static SingletonClass INSTANCE ;

	public static SingletonClass getInstance() {
		//INST스가  null 이면 
				if(INSTANCE == null) { // 주소 만든거 없어 ? 그럼 null 이야 ?
					INSTANCE = new SingletonClass(); // 그럼 만들어 서 인스턴스에넣어 
	}
				return INSTANCE;

	}
	private SingletonClass() {}

	public int getI() {return i;}

	public void setI(int i) {this.i = i;}

	
}
