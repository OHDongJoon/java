package test2;

public class TestMain {
	public static void main(String[] args) {
		Person2 st1 = new Student("A01", "���л�", "JAVA��");
		Person2 st2 = new Student("A02","ȫ�浿","C++��");
		Person2 sf1 = new Staff("S01","������","������");
		Person2 sf2 = new Staff("S02","������","���������");
		Person2 ga1 = new Gangsa("G01","������","���α׷���");
		Person2[] p = {st1,st2,sf1,sf2,ga1};
		for(Person2 pp : p)
			pp.print();
		
	}
}
