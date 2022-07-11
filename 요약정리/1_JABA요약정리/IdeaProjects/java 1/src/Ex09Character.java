// 기본형 데이터타입 03
// 문자형 데이터타입

// 문자형 데이터 티입은 char 데이터타입만 존재한다.
// 단, 해당 데이터타입은 "차" 라고 읽는 것이아니라
//"캐리터" 라고 읽는 것이 맞다.

// 캐릭터 데이터타입의 값은
// 따옴표로 감싸진 한개의 문자이다.
// 만약 따옴표 안에 여러개의 글자를 넣으면?
// 에러 발생

// 즉, char는 한번의 한개의 글자만 다룰 수 있기 때문에
// 우리가 사용하지 않는 데이터타입이다.

// 대신, 한번에 여러개의 글자를 다룰 수 있는
// String 데이터타입의 값을 사용하는데,
// String 데이터타입의 값은 쌍따옴표 로 감싸주게 된다.

public class Ex09Character {
    public static void main(String[] args) {
        // char 변수 myChar 선언
        char myChar;
        // myChar에 대문자 A를 저장해보자
        myChar = 'A';
        // myChar의 현재 값을 출력해보자
        System.out.println(myChar);

        //''는 한번의 한개의 글자만 다룰 수 있는
        // char 데이터타입의 값이므로 아랫처럼
        // 2개의 이상의 글자를 char 값으로 지정할 수 없다.
       // myChar = 'AB';

        //myChar는 기본형 데이터타입이고
        //한번의 한개의 글자만 다룰 수 있다.
        // 하지만 "AB"는 Strinf 데이터 값으러써
        // 참조형 데이터타입이므로 기본형 데이터타입의 공간에
        //저장할 수 없다.

        //myChar = "AB";

        // 번외) String 데이터타입의 변수를 만들어서
        // 여러개의 글자를 저장해보자
        // String 변수 name을 선언
        String name;

        // name에 각자 자기 이름 저장
        name = "오동준";

        // name에 화면 출력
        System.out.println("name의 현재 값");
        System.out.println(name);

        // 번외2) char에 숫자값 넣어서 글자 출력하기
        myChar = 98;
        System.out.println("myChar의 현재 값");
        System.out.println(myChar);

    }
}
