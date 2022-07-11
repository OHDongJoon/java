import java.util.Scanner;
//강아지 몸무게에 따른 사료 권장
// 하루에 강아지 1kg 당 10g의 사료를 급여 권장 1일 권장량
public class DogFood {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // 스캐너 변수 설정

    System.out.println("강아지 몸무게 입력:"); // 몸무게 입력 출력
    String weightInString = scanner.nextLine(); // 문자열로 몸무게 입력 받은거 변수설정 스캐너
    try{
        double weight = Double.parseDouble(weightInString); // 몸무게 입력받은 문자열 Double로 변환 후  weight 변수에 저장
        double amount = weight * 10;                        // weight 몸무게 저장한 값 1kg당 10g 이니 곱하기 10 한 수를 amount 변수에 에 저장
        System.out.println("권장 급여량은" + amount + "g입니다.");
    }catch (Exception e){
        System.out.println("숫자를 적으라고 시팔");
    }
    }
}
