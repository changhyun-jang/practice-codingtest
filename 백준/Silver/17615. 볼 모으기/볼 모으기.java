import java.util.*;
public class Main {
    /*
    --문제 읽기
    같은 색끼리 인접하게 놓이도록 하려고함

     */
    static int N;
    static String[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new String[N];
        String temp = sc.next();
        A = temp.split("");
        int B = Blue();
        int R = Red();
        System.out.println(Math.min(B, R));
    }

    private static int Red() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i].equals("R")) count++;
        }
        int countFirst = 0;
        for (int i = 0; i < N; i++) {
            if (A[i].equals("B")) break;
            countFirst++;
        }
        int countEnd = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i].equals("B")) break;
            countEnd++;
        }

        return Math.min(count - countFirst, count - countEnd);
    }

    private static int Blue() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i].equals("B")) count++;
        }
        int countFirst = 0;
        for (int i = 0; i < N; i++) {
            if (A[i].equals("R")) break;
            countFirst++;
        }
        int countEnd = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i].equals("R")) break;
            countEnd++;
        }

        return Math.min(count - countFirst, count - countEnd);
    }
}
