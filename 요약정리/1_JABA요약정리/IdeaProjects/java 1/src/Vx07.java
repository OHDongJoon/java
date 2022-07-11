// 사용자로부터
// 번호, 이름, 국어, 영어, 수학순으로 입력을 받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성하시오.
// 단, 실수를 6자리에 맞추어 왼쪽 정렬하고 왼쪽 빈공 간이 있으면 0으로 채우고
// 소숫점은 2번째 자리까지 표시할 때에는
// %06.2ㄹ f를 사용하면 됩니다.
// 또한 String 값은 %s가 담당하게 됩니다.


// 결과))))))))
// 번호: 0##번 이름 :###
// 국어: 0##점 영어 : 0##점 수학 : 0##점
// 총점: 0##점 평균: 0##.##점

// 1. Scanner 임포트
// 2. Scanner 변수 선언 및 초기화
// 3. 번호 입력
// 4. 이름 입력
// 5. 국어 입력
// 6. 영어 입력
// 7. 수학 입력
// 8. 총점 계산
// 9. 평균 계산
//10. 번호 이름 출력
//11. 국어 영어 수학 출력
//12. 총점 평균 출력

import java.util.Scanner;

public class Vx07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("번호:");
        int bunho = scanner.nextInt();


        System.out.print("이름:");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("국어:");
        int korean = scanner.nextInt();

        System.out.print("영어 :");
        int english = scanner.nextInt();

        System.out.print("수학:");
        int math = scanner.nextInt();

        int sum = korean + english + math;

        double average = (double) sum / 3;

        System.out.printf("번호: %03d번 이름: %s\n", bunho, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);



    }
}
