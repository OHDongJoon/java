// 논리 연산자
// 논리 연산자는 boolean값에 대한 연산을 한다.

// &&: 왼쪽과 오른쪽이 모두 트루 일 때에만 결과값이 trune가 된다
// || : 왼쪽과 오른쪽 중 하나라도 true이면 결과갓이 trune가 된다.
// != true는 false로 false는 true로 연산한다.
public class Vx04 {
    public static void main(String[] args) {
        // 1. &&
       /* System.out.println("1. &&");
        System.out.println("true && true: " + (true && true));
        System.out.println("true && false: " + (true && false));
        System.out.println("false && true: " + (false && true));
        System.out.println("false && false: " + (false && false));

        // 2. ||
        System.out.println("2. ||");
        System.out.println("true || true: " + (true || false));
        System.out.println("true || true: " + (false || true));
        System.out.println("true || true: " + (false || true));
        System.out.println("true || true: " + (false || false));

        // 3. !=
        System.out.println("2. !=");
        System.out.println("!true: " + (!true));
        System.out.println("!falase: " + (!false));*/

        // int 값이 0 이하 10이하인지 체크하는 코드
        // 우리가 수학에서 배웟던 것은??
        // 0 <= x <= 10
        int x = 6;
        //System.out.println("0 <= x <= 10:" + (0 <= x <= 10));
        // 코드는 왼쪽에서 오른쪽으로 가기 때문에 0 <= x 먼저 실행된다 6은 0보다 크거나 작나 ? true
        // 근데 true <= 10 이게 말이 됭?? 노 안되
        // 위코드는 비고하여 boolean 결과 값이 나오는데
        // boolean 값은 int 와 비교할 수 없으므로 에러가 발생한다 시발


        //즉, 범위의 값을 체크한다고 한다면
        // x가 특정값 보다 크다 그리고 특정값보다 작다 가 모두 true가 나올 때에만
        // 결과값이 true가 나오게 논리 연산자를 만들어주어야 한다.
        System.out.println("0 <= x && x <= 10: " + (0 <= x && x <= 10));
        // && 둘다 true 일때만  고고링

    }
}
