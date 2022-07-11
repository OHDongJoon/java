// 형변환(Type Casting)
// 형변환이란, 특정 데이터타입의 값을
// 가능하다면 다른 데이터타입의 값으로 변환하는 코드이다.
// 형변환에는 암시적 형벼환과 명시적 형변환 두가지 종류가 존재한다.

// 더 작은 데이터타입의 값을 더 큰 데이터타입으로 변환하거나
// 정수를 실수로 바꿀 때에는 암시적 형변환이 발생한다.
// 이때에는 우리가 특별히 코드를 적지 않더라도 자바가 알아서 형변환을 해준다.

// 하지만 더 큰 데이터타입의 값을 더 작은 데이터타입으로 변환하거나
// 실수를 정수로 바꿀 때에는 우리가 명시적 형변환을 실행해야 한다.
// 이때에는 바꿀 대상의 값 앞에 바꿀 데이터타입의 종류를() 안에 넣어서 형변환을
// 우리가 직접 해주어야 한다.
// 변수/상수 = (데이터타입)바꿀 값;
public class Vx01TypeCasting {
    public static void main(String[] args) {
        // byte 변수 myByte를 선언하고 10을 넣어보자
        byte myByte = 10;
        // int 변수 number1에 myByte의 현재 값을 저장해보자
        /*int number1 = myByte;
        //number1의 현재 값을 화면에 출력해 보자
        System.out.println("number1의 현재값: " + number1);

        // myByte에 number1의 현재 값을 저장해보자
        // 더 큰 데이터타입의 값을 더 작은 데이터타입의 변수에 저장해야하므로
        // 명시적 형변환이 필요하다.
        myByte = (byte)number1;
        System.out.println("myByte의 현재 값 : " + myByte);*/

        // 평균을 구하는 코드
        int korean = 80;
        int english = 80 ;
        int math = 81;

        // 국영수의 합을 int 변수 sum에 저장해보자
        int sum = korean + english + math;

        // 평균을 계산하여 daouble 변수 변수 average에 저장
        double average = (double)sum / 3;
        System.out.println("평균: " + average);
    }
}
