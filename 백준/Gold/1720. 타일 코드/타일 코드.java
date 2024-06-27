import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[31];
        int[] dp2 = new int[31];
        dp[1] = 1;
        dp[2] = 3;
        dp2[1] = 1;
        dp2[2] = 3;

        for (int i = 3; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 2];
            if (i % 2 == 1) {
                dp2[i] = dp[(i - 1) / 2];
            } else {
                dp2[i] = dp[(i - 2) / 2] * 2 + dp[i / 2];
            }
        }
        System.out.println((dp[N] - dp2[N]) / 2 + dp2[N]);
    }
}
