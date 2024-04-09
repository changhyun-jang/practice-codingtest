import java.util.*;

public class Main {
    static int N;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[1001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 1;
        for (int i = 3; i < 1001; i++) {
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][2] + dp[i - 2][3]) % 10007;
            dp[i][3] = (dp[i - 2][1] + dp[i - 2][2] + dp[i - 2][3]) % 10007;
        }
        System.out.println((dp[N][1] + dp[N][2] + dp[N][3])%10007);
    }
}
