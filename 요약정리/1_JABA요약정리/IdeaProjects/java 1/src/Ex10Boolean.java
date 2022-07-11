// 기본형 데이터타입 04
// 논리형 데이터타입

// 논리형 데이터타입인 boolean은 정확히 2개의 값만 존재할 수 있다.
// 참 혹은 거짓을 뜻하는 true/false 인데,
//boolean 데이터타입의 값을 우리가 정말 많이 사용하지만
// 변수에 저장하기 보다는 우리가 나중에 배우게 될 연산자 혹은 메소드의 결과값을
// 그대로 쓰는 경우가 대부분이다.
public class Ex10Boolean {
    public static void main(String[] args) {
        // boolen 변수 myBool 선언
        boolean myBool;

        //myBool 에 true wjwkd
        myBool = true;

        // myBool의 현재 값 출력
        System.out.println("myBool의 현재값");
        System.out.println(myBool);

        // myBool 에 false 저장
        myBool = false;

        // myBool의 현재 값 출력
        System.out.println("myBool의 현재값 출력");
        System.out.println(myBool);
    }
}
