// 1. int 변수 number를 만들고
// 5를 저장하세요
// 문제1. number가 10보다 작으면 " 한자리 숫자입니다" 가 출력되게 코드를 작성하세요
// 문제2. number가 홀수이면 "홀수입니다" 가 출력되게 코드를 작성하세요
// 문제3. number가 3의 배수가 아닐 경우에는 "3의 배수가 아닙니다" 가 출력되게 코드를 작성하세요
// 문제4. 사용자로부터 나이를 입력받아서 미성년자이면 "미성년자입니다." 가 출력되
// 문제5. 사용자로부터 숫자를 입력받아서 두자리 양의 정수이면 " 두자리 양의 정수입니다."
import java.util.Scanner;
public class Vx09If02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 300;
        // 10보다 작으면
        if(number<10){
            System.out.println("한자리수입니다.");
        }
        // 홀수
        if(number%2 == 1){
            System.out.println("홀수입니다.");
        }
        //3의배수
        if(number % 3 !=0){
            System.out.println("3배수가 아닙니다.");
        }

        // 미성년자
        System.out.print("나이를 입력해주세요:");
        int age = scanner.nextInt();
        if(age < 19){
            System.out.println("미성년자입니다");

        }
        // 두자리 양의 정수수
        System.out.print("숫자 입력:");
        int number2 = scanner.nextInt();
        if(number2>=10 && number2 <= 99){
            System.out.println("두자리 양의 정수입니다.");
        }

    }
}
