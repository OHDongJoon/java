//  연산자(Operator)
//  연산자란, 수학 기호에 프로그래밍 기능이 정의되어있어서
// 해당 기호가 코드에 적혀있으면 그 기호에 정의된 기능이 실행된다.

// 연산자에는 크게
// 산술, 할당, 비교, 논리, 비트 연산자 5가지가 있다.
// 하지만 그 중 비트 연산자는 우리가 배우지 않는다.

// 산술연산자
// + - * / %
// +: 연산자 앞의 값과 뒤의 값을 더한 결과값을 구한다.
// -: 뺴기
// /: 나눈 "몫"을 구한다.
// % : 연산자 앞의 값을 뒤의 값으로 나눈 "나머지:를 구한다.

// 산술연산자의 경우,
// 같은종류(정수와 정수 혹은 실수와 실수)의 데이터 타입을 연산하면 해당 데이터타입이 결과로 나오지만
// 다른 종류(정수와 실수)의 데이터타입을 연산하면 데이터손실이 발생되지 않는 데이터입이 결과로 나온다.

// 또한 수학에서의 우선순위가 그대로 적용됨로 *, /, %가 + - 보다 먼저 실행이 된다.

// 다른 연산자들도 마찬가지지만, 같은 우선순위의 연산자가 여러개가 나올 경우,
// 왼쪽부터 차례대로 실행이 된다.
// 예를 들어 1 + 2 + 3이 있을 경우
// 먼저 1+2 가 실행되서 3이라는 결과값이 나오고
// 그 후에 3이라는 결과값에 3을 더하여 6이 결과값으로 나온다는 의미가 된다.

public class Ex12Operator {
    public static void main(String[] args) {
        // 1. int 끼리의 연산
        /*System.out.println("1. int 끼리의 연산");
        // int number1, number2 선언
        int number1 = 13;
        int number2 = 4;
        System.out.println("A. number 1 + number2");
        System.out.println(number1 + number2);

        System.out.println("B. number 1 - number2");
        System.out.println(number1 - number2);

        System.out.println("C. number 1 * number2");
        System.out.println(number1 * number2);

        System.out.println("D. number 1 / number2");
        System.out.println(number1 / number2);

        System.out.println("E. number 1 % number2");
        System.out.println(number1 % number2);*/

        /*System.out.println("2. double끼리의 연산");
        double d1 = 13.0;
        double d2 = 4.0;

        System.out.println("A . d1 + d2");
        System.out.println(d1 + d2);

        System.out.println("B . d1 - d2");
        System.out.println(d1 - d2);

        System.out.println("C . d1 * d2");
        System.out.println(d1 * d2);

        System.out.println("D . d1 / d2");
        System.out.println(d1 / d2);

        System.out.println("E . d1 % d2");
        System.out.println(d1 % d2);*/

        // 3. 정수와 실수의 산술 연산
        System.out.println("3. int와 double의 산술연산");


        // String의 경우, +  연산이 가능한데
        // 이때에는 앞에 String 값에 뒤의 String 값을 이어붙여서
        // 새로운 String 값을 만들라는 의미가 된다.
        System.out.println("a"+"b");
        System.out.println("12"+ 34);
        System.out.println(12+"34");



    }
}
