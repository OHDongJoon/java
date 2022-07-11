import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
       System.out.println("영어 단어와 한글 단어 하나씩 입력해봐");
       Scanner scanner = new Scanner(System.in);

       String engLishWord = scanner.next();
       String koreaWord = scanner.next();

       System.out.println("입력된 영단어 : "+ engLishWord);
       System.out.println("입력된 한글 단어: "+ koreaWord);
    }
}
