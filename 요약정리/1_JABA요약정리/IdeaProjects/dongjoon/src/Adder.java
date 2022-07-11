import java.util.Scanner;
//두정수를 입력받아 더한 결과 출력
public class Adder {
    public static void main(String[] args) {
        //입력받을 스캐너 변수 선언
    Scanner scanner = new Scanner(System.in);
    // 첫번째 수 입력 화면 출력
    System.out.println("첫번째 수를 입력해주세요");
    String numberString1 = scanner.nextLine();
    //두번째수
    System.out.println("두번째 수를 입력해주세요");
    String numberString2 = scanner.nextLine();
    try{
        int number1 = Integer.parseInt(numberString1);
        int number2 = Integer.parseInt(numberString2);
        int sum = number1 + number2;
        System.out.println("두 수를 더한 값은 : "+ sum + "입니다");
    }catch(Exception e){
        System.out.println("숫자를 변환하는 동안 오류가 생겼습니다.");
    }
    }
}
