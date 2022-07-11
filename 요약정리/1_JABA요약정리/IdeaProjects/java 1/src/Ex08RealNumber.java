// 기본형 데이터타입 02
// 실수형 데이터타입

// 프로그래밍에서 실수형 데이터타입은 2종류가 존재한다.
// float: 32비트
// double: 64비트

// 자바에서 코드 안에 숫자가 존재할 경우,
// 정수이면 int, 실수이면 double로 인식한다.
// 따라서 우리가 float을 사용하자고 하면?
// 별도의 코드를 적어주지 않는 이상 에러가 발생한다.

import java.util.function.DoubleToIntFunction;

//따라서 편하게 double을 쓰면 된다.
public class Ex08RealNumber {
    public static void main(String[] args) {
        // double 변수 myDouble 선언
        double myDouble;
        // myDouble 에 3.14 저장
        myDouble = 3.14;
        // myDouble의 현재 값 출력
        System.out.println("myDouble의 현재 값");
        System.out.println(myDouble);
        // myDouble에 4 저장
        myDouble = 4;

        // myDouble에 현재 값 출력
        System.out.println("myDouble의 현재 값");
        System.out.println(myDouble);

        // float 변수 myFloat 선언
        float myFloat;

        // myFloat 에 double 데이터타입의 값이 아닌
        // my Float에 3.14 저장
        // 이 때에는 실수 뒤에 f를 붙여준다.
        myFloat =3.14f;
    }
}
