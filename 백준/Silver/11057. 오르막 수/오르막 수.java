import java.util.*;
import java.io.*;

public class Main {
    static int[][] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            A[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    A[i][j] += A[i - 1][k];
                }
                A[i][j] %= 10007;
            }
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + A[N][i]) % 10007;
        }
        System.out.println(answer);
    }
}
