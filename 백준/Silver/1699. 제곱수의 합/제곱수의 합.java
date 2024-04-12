import java.util.*;

public class Main {
    /*
    --문제 접근
    문제를 읽고 최소 개수를 구하므로 그리디 일수도 있고,
    DP일 수 도 있을 거라 생각했다.
    먼저 dp로 한번 접근해보자

     */
    static int N;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[160001];
        Arrays.fill(A, Integer.MAX_VALUE);
        A[1] = 1;
        for (int i = 1; i <= 400; i++) {
            A[(int) Math.pow(i, 2)] = 1;
        }
        for (int i = 2; i <= N; i++) {
            if (A[i] != 1) {
                for (int j = 1; j <= i / 2; j++) {
                    A[i] = Math.min(A[i], A[i - j] + A[j]);
                }
            }
        }
        System.out.println(A[N]);

    }
}
