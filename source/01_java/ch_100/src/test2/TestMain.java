package test2;

public class TestMain {
	public static void main(String[] args) {
		Person2 st1 = new Student("A01", "나학생", "JAVA반");
		Person2 st2 = new Student("A02","홍길동","C++반");
		Person2 sf1 = new Staff("S01","나직원","교무팀");
		Person2 sf2 = new Staff("S02","나도요","취업지원팀");
		Person2 ga1 = new Gangsa("G01","나선생","프로그래밍");
		Person2[] p = {st1,st2,sf1,sf2,ga1};
		for(Person2 pp : p)
			pp.print();
		
	}
}
