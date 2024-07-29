import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] testCase;
    static long Mod = 1000000007L;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        // 나올 수 있는 경우의 수 정의
        testCase = new String[10][2];
        long[] dp = new long[10];
        for (int i = 1; i < 10; i++) {
            if (i < 4) {
                testCase[i][0] = "R";
            } else if (i < 7) {
                testCase[i][0] = "P";
            } else {
                testCase[i][0] = "S";
            }
            if (i % 3 == 1) {
                testCase[i][1] = "R";
            } else if (i % 3 == 2) {
                testCase[i][1] = "P";
            } else {
                testCase[i][1] = "S";
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // lighter 처음 내는 거 입력
        String L = br.readLine();
        // smallant가 결승에서 내는 거
        String S = br.readLine();
        String total_str = L + S;
        if (total_str.charAt(0) == 'R') dp[1] = 1;
        else if (total_str.charAt(0) == 'P') dp[5] = 1;
        else dp[9] = 1;

        // 이긴 뒤 곧바로 비기면 안됌.
        for (int i = 1; i < total_str.length(); i++) {
            if (total_str.charAt(i) == 'R') {
                dp[1] += dp[1] + dp[7];
                dp[4] += dp[2] + dp[5] + dp[8];
                dp[7] += dp[3] + dp[6] + dp[9];
                dp[1] %= Mod;
                dp[4] %= Mod;
                dp[7] %= Mod;
            } else if (total_str.charAt(i) == 'P') {
                dp[5] += dp[5] + dp[2];
                dp[2] += dp[1] + dp[4] + dp[7];
                dp[8] += dp[3] + dp[6] + dp[9];
                dp[5] %= Mod;
                dp[2] %= Mod;
                dp[8] %= Mod;
            } else {
                dp[9] += dp[9] + dp[6];
                dp[6] += dp[2] + dp[5] + dp[8];
                dp[3] += dp[1] + dp[4] + dp[7];
                dp[9] %= Mod;
                dp[6] %= Mod;
                dp[3] %= Mod;
            }
        }
        for (int i = 1; i < 10; i++) {
            answer += dp[i] % Mod;
        }
        System.out.println((answer%Mod)-1);
    }
}
