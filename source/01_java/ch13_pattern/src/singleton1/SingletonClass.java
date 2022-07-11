package singleton1;

public class SingletonClass {
	private int i ;
	//public 에서 private 로 바꿔 그래야 못써 그래서 객체 생성은 여기서 밖에 못해 
	// 객체 만들었어 ? 그럼 그거 써  객체생성했으면 그 객체 주소를 return 하고 
	// 객체 없어? 만들어 객체생성을 안했으면 객체 생성하고 그 주소를 return
	
	// 객체 주소를 갖고 잇어야됭 private static 클래스이름 
	private static SingletonClass INSTANCE = new SingletonClass(); 
	public static SingletonClass getInstane() {
			return INSTANCE;
		}
		
	private SingletonClass() {}

	public int getI() {return i;}

	public void setI(int i) {this.i = i;}
	
}
