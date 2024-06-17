import java.util.Scanner;

public class Main {
    static int N;
    static long answer = 0;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 50; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 1) % 1000000007;
        }
        System.out.println(dp[N]);


    }

    private static int fibonacci(int n) { // 호출
        answer += 1;
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
