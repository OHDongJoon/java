// 자바 콘솔에 출력을 하는 3가지 방법
// 1. print()
//    print()는 괄호안의 내용을 콘솔에 출력하고
//    만약 그 다음 출력할 것이 존재하면 출력된 내용 오른쪽에 이어서 출력을 시작한다.

// 2. println()
//     println() 은 print a line 의 줄임말로써
//      println()은 괄호안의 내용을 콘솔에 출력하고
//     만약 그 다음 출력할 것이 존재하면 출력된 내용의 다음줄 첫번째 칸부터 출력얼 시자한다.

// 3. printf()
//      printf() 는 괄호안의 내용을 "지정된 형식에 맞추어" 출력하고
//      만약 그다음 출력할 것이 존재하면 출력된 내용 오른쪽에 이어서 출력을 시작한다.

public class Vx05 {
    public static void main(String[] args) {
        /*String str1 = "abc";
        String str2 = "DEF";
        System.out.println("1.print()");
        System.out.print(str1);
        System.out.print(str2);
        System.out.println("======================");

        System.out.println("2. printf()");*/
        // 만약 10진법 정수를 출력해야 하면
        // %d를 사용한다.
        // 이 %d를 출력할 갯수만큼 printf에 넣어주고
        // 그리고 그 갯수만큼의 값을 넣어주면
        // printf가 형식을 맞춰준다.
        // 오른쪽 정렬 특정 자릿수 지정은 %와 d 사이에 양의 정수를 넣으면 된다.
        // 왼쪽 정렬 특정 자릿수 지정은 %와 d 사이에 음의 정수를 넣으면 된다.
        // 오른쪽 정렬의 경우, 왼쪽 빈 공간을 0으로 채울수도 있느데 이때에는
        // 양의 정수 앞에 0을 붙여주면 된다.
        // 단, 자릿수 지정의 경우 출력해야할 내용이 자릿수보다 많으면
        // 무시된다.

        /*System.out.printf("[%d]", 30);
        System.out.println();

        System.out.printf("[%d] [%4d]", 30, 32);
        System.out.println();

        System.out.printf("[%d] [%4d] [%-4d]", 30, 32, 34);
        System.out.println();

        System.out.printf("[%d] [%4d] [%-4d] [%04d]", 30, 32, 34, 36);
        System.out.println();*/

        // 이스케이프 문자
        // 이스케이프 문자는 \와 조합되서
        // 특수한 문자이다.
        // 대표적으로 개항문자, 탭 공백, "" 등을 사용할 때
        // 이스케이프 문자를 사용하게 된다.
        // 단, 이스케이프 문자는 우리가 볼때는 두글자이지만
        // 프로그래밍 내부적으론 한글자로 처리되기 때문에
        // char 공간에 저장할 수도 있다.

        // 1. \n
        // 개행문자. 줄을 강제로 바꾼다
        System.out.println("abc\ndef");
        // 2. \t
        // 탭공백. 스페이스 1개보다 큰 공백을 뜻한다.
        System.out.println("abc\tdef");
        // 3. \\
        // \를 글자 그대로 넣어야 할 경우에 사용된다.
        System.out.println("\\는 백슬러쉬 입니다.");
        // 4. \'
        // char 값 '를 출력해야할 경우가 있다면
        // \' 를 사용해야한다.
        // 왜냐하면 그냥 '는 자바 코드 상으로
        // char 값의 시작 혹은 끝을 뜻하기 때문에
        // '만 쓰면
        // char 값이 제대로 안끝났다라고 자바가 착각하기 때문이다.
        System.out.println(" ' ");
        // 5. \"
        // "를 사용하여 인용문을 적어야 하는 경우등이 존재하는데
        // " 자체는 자바 코드 상으로 String 값의 시작/끝을 뜻하게 된다.
        // 따라서 문자로써의 "를 써야하는 경우에는 \" 를 사용해야한다.
        System.out.println("\"내 사전에 불가능은 없다!\"");

    }
}
