// 기본형 데이터타입 01
// 정수형 데이터타입

// 정수란? 소숫점이 존재하지 않는 온전한 숫자
// 프로그래밍의 경우, 정수형 기몬 데이터타입은 크게
// byte. short, int, long, 4가지 종류가 존재한다.

// byte: -127 ~ 127 -> 8비트
// short : -32768 ~ 32767 -> 16비트
// int: -20억 ~ 20억 -> 32비트
// long : -2^63 ~ 2^63 - 1 -> 64비트

// 단 , 범위를 벗어나는 값을 저장할려고 하면 에러가 발생하게 된다!
// 그로므로 +- 20억 사이의 숫자가 예상되면 int,
// 그 보다 클 것으로 예상되면 long 데이터타입을 사용하면 된다.
public class Ex07Integer {
    public static void main(String[] args) {
        // byte 변수 myByte를 선언하고 30을 저장해보자
        byte myByte = 30;
        // myByte의 현재 값을 출력해보자
        System.out.println("myByte의 현재 값");
        System.out.println(myByte);
        // 300은 byte의 범위를 벗어났으므로 에러가 발생
        // myByte= 300;

        //즉 에러가 발생하는 것을 걱정하면서
        //byte 혹은 short을 사용하지 말고
        //맘 편하게 int 혹은 long을 쓰면 된다.
    }
}
