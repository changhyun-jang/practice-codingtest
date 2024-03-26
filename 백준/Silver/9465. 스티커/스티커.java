import java.util.*;

public class Main {
    /*
    --문제 읽기
    스티커 2n개 구매
    한장을 떼면 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용 X
    
    각 스티커에 점수를 매기고 점수의 합이 최대가 되게 스티커를 떼고싶음
    T, n<100000, n개의 정수가 주어짐
    변을 공유하지 않는 스티커 점수의 최댓값을 출력하시오.
    */
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] dp = new int[3][N + 1];
            int[][] A = new int[3][N + 1];
            for (int j = 1; j <= 2; j++) {
                for (int k = 1; k <= N; k++) {
                    A[j][k] = sc.nextInt();
                }
            }
            dp[1][1] = A[1][1];
            dp[2][1] = A[2][1];

            for (int j = 2; j <= N; j++) {
                dp[1][j] = Math.max(dp[2][j - 2], dp[2][j - 1]) + A[1][j];
                dp[2][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + A[2][j];
            }
            System.out.println(Math.max(dp[1][N], dp[2][N]));
        }
    }
}
