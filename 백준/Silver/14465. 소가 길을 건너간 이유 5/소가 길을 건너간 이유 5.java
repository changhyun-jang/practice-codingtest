import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, B, answer;
    static int[] dp;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dp = new int[N - K + 2];
        check = new boolean[N + 1];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(br.readLine());
            check[num] = true;
        }
        for (int i = 1; i <= K; i++) {
            if (check[i]) dp[1]++;
        }
        for (int i = 2; i <= N - K + 1; i++) {
            if (check[i-1]) {
                if (check[i + K - 1]) dp[i] = dp[i - 1];
                else dp[i] = dp[i - 1] - 1;
            } else {
                if (check[i + K - 1]) dp[i] = dp[i - 1] + 1;
                else dp[i] = dp[i - 1];
            }

            answer = Math.min(dp[i], answer);
        }
        System.out.println(answer);
    }
}
