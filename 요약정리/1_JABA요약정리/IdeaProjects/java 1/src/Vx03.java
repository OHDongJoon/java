// 비교 연산자
// 비교연산자는 왼쪽 값과 오른쪽 값을 비교하되
// 어느쪽이 더 크다 혹은 더 작다가 결과값으로 나오는 것이 아니라
// "왼쪽이 현재 값이 오른쪽의 현재 값보다 작습니까?" true/false
// 의 개념으로 이해하면 더 쉽다.


public class Vx03 {
    public static void main(String[] args) {
        // int 변수 number1과 number2를 선언하고 각각 5와 6을 저장
        int number1 = 5;
        int number2 = 6;
        // 1. >
        System.out.println("1. >");
        System.out.println("number1 > 0 :" + (number1 > 0));
        System.out.println("number1 > number2:" + (number1 > number2));
        System.out.println("number 1 > 5: " + (number1 > 5));

        //2. >=
        System.out.println("2. >=");
        System.out.println("number1 >= 0:" + (number1 >= 0));
        System.out.println("number1 > number2:" + (number1 >= number2));
        System.out.println("number 1 > 5: " + (number1 >= 5));

        //3. ==
        // 왼쪽의 현재 값과 오른쪽의 현재 값이 같으면 true, 다르면 false 가 나온다.
        System.out.println("3. == ");
        System.out.println("number1 == 5:" +(number1 == 5));
        System.out.println("number 1 == number 2:" + (number1 == number2));

        // 4. !=
        // 왼쪽의 현재 값과 오른쪽의 현재 값이 다르면 true 같으면 false 가 나온다

        System.out.println("4. !=");
        System.out.println("number1 != 5: "+(number1 != 5));
        System.out.println("number1 != number2: " + (number1 != number2));

        // 단, 2개의 값이 같은지 비교할 때에
        // 참조형 데이터타입일 경우에는
        // ==이 아닌 equals() 라는 메소드를 사용하여 비교해아한다.
        // 왜냐하면, 비교연산자는 별개의 공간에 저장된 실제 값을 비교해주는 것이 아니라
        // 해당 변수에 직접 저장되어있는 주소값을 비교하기 때문이다.

        // String 변수 2개를 만들어서 비교하되
        // 저장하는 방법을 다르게 해보자
        String str1 ="abc";
        String str2 = new String("abc");

        // str1과 str2에 들어있는 값을 출력해보자
        System.out.println("str1: [" + str1 + "]");
        System.out.println("str2: [" + str2 + "]");

        System.out.println("str1 == str2:" + (str1 == str2));
        System.out.println("str1.equals(str2):" + str1.equals(str2));
    }
}
