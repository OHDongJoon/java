package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass seconObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("Main ÇÔ¼ö¿¡¼­ ½Ì¤·±ÛÅæ °´Ã¼ ÀÇ i°ª" + singObj.getI());
	}
}
