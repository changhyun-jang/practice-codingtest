import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] table;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        table = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = table[0][0];
        dp[0][1] = table[0][1];
        dp[0][2] = table[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + table[i][0], dp[i - 1][1] + table[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + table[i][1], Math.min(dp[i - 1][1] + table[i][1], dp[i - 1][2] + table[i][1]));
            dp[i][2] = Math.min(dp[i - 1][1] + table[i][2], dp[i - 1][2] + table[i][2]);
        }
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minNum = Math.min(minNum, dp[N - 1][i]);
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 0);
        }

        dp[0][0] = table[0][0];
        dp[0][1] = table[0][1];
        dp[0][2] = table[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + table[i][0], dp[i - 1][1] + table[i][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + table[i][1], Math.max(dp[i - 1][1] + table[i][1], dp[i - 1][2] + table[i][1]));
            dp[i][2] = Math.max(dp[i - 1][2] + table[i][2], dp[i - 1][1] + table[i][2]);
        }
        int maxNum = 0;
        for (int i = 0; i < 3; i++) {
            maxNum = Math.max(maxNum, dp[N - 1][i]);
        }
        System.out.println(maxNum + " " + minNum);
    }
}
