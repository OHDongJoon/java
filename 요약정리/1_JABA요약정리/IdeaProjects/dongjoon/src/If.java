import java.util.Scanner;
//달걀 30개당 하나의 계란판이 필요하다 할 때
//계란판이 필요하지 않을땐 "계란판이 필요하지 않습니당"
//필요한 경우에는"총 x개의 계란판이 필요합니다
public class If {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("총 달걀의 수를 입력하세요");
        int eggSize = 30; // 계란판 하나당 포장되는 달걀 수
        int totalEggs = 0; // 총 달걀 수를 입력받기 위해 0으로 초기화 합당
        String input = scanner.nextLine(); //사용자로부터 입력받음
        try {
            //사용자가 입력한 문자열을 정수로 변환
            totalEggs = Integer.parseInt(input);
            if (totalEggs < 30) {
                System.out.println("계란 노필요");
            } else {
                int totalEggCartons = totalEggs / eggSize;
                System.out.println(
                        "총" + totalEggCartons + "개의 계란판이 필요합니다.");
            }
        }catch (NumberFormatException e){
            System.out.println("잘못된 입력입니다");
        }
        //사용자로부터 문자열을 입력받습니다.







         }
}
