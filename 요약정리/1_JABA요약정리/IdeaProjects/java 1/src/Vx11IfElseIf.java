// if - else if 구조
// 만약, 우리가 뽑아내야할 결과가 true/false 두가지만 존재하는 것이 아니라
// 1번 조건 체크 -> 2번 조건 체크 -> 3번 조건 체크...
// 이런식으로 다양한 결과를 처리해야할 경우
// 우리는 if -else if 는 다음과 같은 구조를 가진다.

// if - else if 는 다음과 같은 구조를 가진다.
// if (조건식1){
// 조건식이1이 참일때 실행할 코드
// } else if( 조건식2 ) {
//  조건식1이 false가 나왔고
// 조건식2가 true가 나왔을때 실행할 코드

//} else if( 조건식 3) {
// 조건식1, 조건식2가 false가 나왔고
// 조건식3이 true가 나왔을때 실행할 코드
//} else {
// 위의 모든 조건식이 false가 나왔을 때 실행할 코드
// }
public class Vx11IfElseIf {
    public static void main(String[] args) {
        int age = 43;

        if(age <= 5) {
            System.out.println("유아입니다.");
        }else if(age <= 13){
            System.out.println("어린이입니다.");
        } else if( age <=18 ) {
            System.out.println("청소년입니다.");
        } else{
            System.out.println("성인입니다.");
        }
    }
}
