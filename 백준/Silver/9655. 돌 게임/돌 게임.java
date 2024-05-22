import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] dp = new boolean[N + 3];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        for (int i = 4; i <= N; i++) {
            dp[i] = !dp[i - 3] || !dp[i - 1];
        }
        if (dp[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
