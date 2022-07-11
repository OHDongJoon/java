// Scanner 클래스
// 자바에서 입력을 처리할 때에는
// 우리가 Scanner 클래스 변수를 만들어서
// 그 변수의 메소드를 싱행시켜서 입력을 처리하게 된다.
// 단, Scanner 클래스는 외부에 존재하는 클래스이기 때문에
// 우리가 사용하기 위해서는 반드시 "수입"해와야 한다.

// 외부 클래스를 수입하는 방법
// import 패키지이름.클래스이름;
// 을 public class ~~~ 이전에 적어주면 된다.

import java.util.Scanner;
public class Vx06Scanner {
    public static void main(String[] args) {
        // Scanner 클래수 변수를 초기화할 때에는
        // 해당 클래스 변수가 어디에서 입력값을 읽어올지를
        // 지정해주어야 한다.
        // 키보드 입력은 System.in 이라는 곳에서 읽어오므로
        // Scanner scanner = new Scanner(System.in)
        // 으로 Scanner 클래스 변수의 선언과 초기화를 해주어야 한다.
        Scanner scanner = new Scanner(System.in);

        // 1. 정수 입력받기
        //    정수(int=)는 Scanner 클래스 변수의 nextInt() 메소드를 사용하면 된다.
        System.out.print("점수를 입력해주세요:");
        int score = scanner.nextInt();
        System.out.println("사용자가 입력한 점수:" + score);
        // 2. 실수 입력받기
        //      nextDouble()
        System.out.print("실수를 입력해주세요 : ");
        double myDouble = scanner.nextDouble();
        System.out.println("사용자가 입력한 실수:" + myDouble);
        // 3. String 입력받기
        //    nextLine()
        // Scanner 클래스의 nextLine() 버그를 해결할 때에는
        // 엔터키 제거용 nextLine()을 한번 실행시켜주고
        // 그 다음에 실제 갑 입력을 담당할 nextLine()을 실행시키면 된다.
        System.out.print("이름을 입력햊세요");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("사용자의 이름: [" + name + "]");
    }
}
