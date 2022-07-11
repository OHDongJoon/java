import java.util.Scanner;
//강이지 몸무게 1키로당 10g
public class Day01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("강아지몸무게를 입력하세요:");
        String 강아지몸무게 = scanner.nextLine();
        try {
            double 강아지몸무게2 = Double.parseDouble(강아지몸무게);
            double 권장량 = 강아지몸무게2 * 10;
            System.out.println("강아지 권장량은 " + 권장량 + "입니다.");
        }catch (Exception e){
            System.out.println("숫자입력 오류");
        }
    }




}
