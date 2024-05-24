import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] color = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = color[0][i];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + color[i][0], dp[i - 1][2] + color[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + color[i][1], dp[i - 1][2] + color[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + color[i][2], dp[i - 1][1] + color[i][2]);
        }
        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}
