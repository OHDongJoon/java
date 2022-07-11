public class VariableExample {
    public static void main(String[] args) {
        String name = "홍길동";
        int age = 50;
        String home ="서울시";

        System.out.println("이름:"+ name);
        System.out.println("나이:" + age +"세");
        System.out.println("사는곳:" + home);

        //윈터는 올해 3살 맥스는 올해 7살 강아지
        // 이 사실을 기반으로 강아지 나이 변수들로 선언 변수들 질문들의 참 또는 거짓 여부 출력

        int Winter = 3 ;
        int max = 7;
        System.out.println("윈터의 나이가 맥스의 나이와 같은가?" + (Winter == max)) ;
        System.out.println("윈터이 나이가 맥스의 나이보다 많은가?" + (Winter > max)) ;

        // "1970/01/23" 이라는 문자열에서 년, 월 , 일을 잘라 1970년 01월 23일 이라는 문자열 출력
        String birthday = "1970/01/23";
        String year = birthday.substring(0,4);
        String mon = birthday.substring(5,7);
        String day = birthday.substring(8);
        System.out.println(year+"년"+mon+"월"+day+"일");





    }
}
