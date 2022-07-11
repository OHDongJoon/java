import java.util.Scanner;

public class HelloJava {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
        System.out.println("강아지 몸무게 입력 하세여:");
        String mom = scanner.nextLine();
        try{
            double weight = Double.parseDouble(mom);
            double 권장량 = weight * 10;
            System.out.println("강아지 권장량은"+ 권장량+"g입니다");
            }catch (Exception e){
            System.out.println("똑바로 입력해 시발");
        }
        }
    }

