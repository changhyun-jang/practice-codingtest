import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Triangle;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Triangle = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                Triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j <= N - 1; j++) {
            dp[N - 1][j] = Triangle[N - 1][j];
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(Triangle[i][j] + dp[i + 1][j], Triangle[i][j] + dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
