import java.util.Scanner;
//bmi 지수 = kg / (키 * 키)
//bmi 계산해 저체중 과체중 정상체중 출력
//bmi 18.5 미만이면 저체중
//bmi 23이상이면 과체중
public class BMI {
    public static void main(String[] args) {
       double ke = 1.74;
       double mom = 74.0;
       double bmi = mom /(ke*ke);
       System.out.println(bmi);
       if(bmi < 18.5){
           System.out.println("저체중입니다");
       }else if(bmi >= 23){
           System.out.println("과체중입니다");
       }else{
           System.out.println("정상체중입니다");
       }



        }



    }

