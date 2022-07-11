// 할당연산자
// 할당 연산자는 오른쪽의 값을 왼쪽 공간에 저장할 때 사용되는 연산자이다.
// =, +=, -=, *=, /=, %=, ++, -- 이 존재한다.


public class Vx02 {
    public static void main(String[] args) {
        // int 변수 number 선언
        int number;

        // number에 20을 저장해라
        number = 20;
        System.out.println("number의 현재 값: " + number);

        // +=
        // +=은 왼쪽 공간의 현재 값에 오른쪽 값을 더한 결과값을
        // 다시 왼쪽 공간에 저장하는 연산자이다.

        // number의 현재 값에 5를 더한 결과값을 다시 number에 저장해라
        number += 5;
        System.out.println("number의 현재 값 : " + number);

        // -=
        // -= 은 왼쪽 공간의 현재 값에 오른쪽 값을 뺀 결과값을
        // 다시 왼쪽 공간에 저장하는 연산자이다.

        // number의 현재 값에 6을 뺀 결과값을 다시 number에 저장해라
        number -= 6;
        System.out.println("number의 현재값:" + number);

        // *=
        // *=은 왼쪽 공간의 현재 값에 오른쪽 값을 곱한 결과값을
        // 다시 왼쪽 공간에 저장하는 연산자이다.

        //number의 현재 값에 4를 곱한 결과값을 다시 넘버에 저장해라
        number *= 4;
        System.out.println("number의 현재 값 : " + number);

        // /=
        // /= 은 왼쪽 공간의 현재 값에 오른쪽 값을 나누 몫을
        // 다시 왼쪽 공간에 저장하는 연산자이다.

        // number의 현재 값에 3을 나눈 몫을 다시 number에 저장해라
        number /= 3;
        System.out.println("number의 현재 값: " + number);

        number %= 6;
        System.out.println("number의 현재값" + number);


        // ++, --
        // ++과 --는 좀 특수한 연산자로써,
        // 특정 공간의 값을 정확히 1씩 변화시킨다.
        // ++은 해당 공간의 값을 1 증가시키고
        // --는 1 감소시킨다.

        // 단, 앞에 붙야 뒤에 붙냐에 따라서
        // 실행되는 순서가 바뀌게 된다.
        System.out.println("++number:"+ ++number);
        System.out.println("number의 현재값:"+number);
        // ++ 혹은 --가 변수의 앞에 붙을 때에는
        // 전위 증가(감소)연산자라고 하며
        // 해당 줄에서 가장 먼저 실행되는 코드 그룹에 속하게 된다.
        //즉 위의 System.out.println("++number: "+ ++ number)
        // 1. ++number가 실행되서 number의 현재값이 1에서 2로 증가
        // 2. "++number: "이라는 String 값 뒤에 number의 현재 값이 연결되서
        // "++number: 2" 가 만들어짐
        // 3. System.out.println()이 "++number:2"을 출력.

        System.out.println("number++:" + number ++);
        System.out.println("number의 현재 값:" + number);

        //++, --가 변수의 뒤에 붙을 때에는
        //후위 증가(감소)연산자라고 하며
        // 해당 줄에서가장 마지막에 실행되는 코드 그룹에 속하게 된다.
        // 즉 위의 System.out.println("number++:" + number++) 의 경우
        // 1. "number++: " 이라는 String 값 뒤에 number 의 현재 값이 연결되서
        //      "number++: 2: 가 만들어짐
        // 2. System.out.println()이 "number++: 2" 를 출력.
        // 3. number++이 실행되서 number의 현재 값이 2에서 3으로 1증가 된다.



    }
}
