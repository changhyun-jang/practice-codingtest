import java.util.*;

public class Main {
    static String A, B;
    static int tempA, tempB;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        B = sc.next();
        tempA = Integer.parseInt(A);
        tempB = Integer.parseInt(B);
        int answer = 1;
        while (true) {
            if (tempA == tempB) {
                break;
            }
            if (tempB % 2 == 1 && B.charAt(B.length() - 1) != '1' || tempB < tempA) {
                answer = -1;
                break;
            } else if (tempB % 2 == 1 && B.charAt(B.length() - 1) == '1') {
                B = B.substring(0, B.length() - 1);
                tempB = Integer.parseInt(B);
                answer++;
            } else if (tempB % 2 == 0) {
                tempB /= 2;
                B = String.valueOf(tempB);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
