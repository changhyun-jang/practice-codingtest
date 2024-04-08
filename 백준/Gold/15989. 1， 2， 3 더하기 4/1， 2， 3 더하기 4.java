import java.util.*;

public class Main {
    static int T, N;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int j = 4; j < 10001; j++) {
            dp[j][1] = dp[j - 1][1];
            dp[j][2] = dp[j - 2][1] + dp[j - 2][2];
            dp[j][3] = dp[j - 3][1] + dp[j - 3][2] + dp[j - 3][3];
        }
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            System.out.println(dp[N][1]+dp[N][2]+dp[N][3]);
        }
    }
}
