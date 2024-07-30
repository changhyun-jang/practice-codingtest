import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 가장 긴 바이토닉 수열은 가장긴 증가하는 수열 + 해당위치에서 가장 긴 감소하는 수열 일거 같은데..
        // 아니면 가장 긴 감소한느 수열 + 해당 위치까지 가장 긴 증가하는 수열
        int answer = 0;

        // 가장 긴 증가하는 수열 길이 저장 배열
        int[] dp = new int[N];

        // 가장 긴 증가하는 수열 구하기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        int[] dp2 = new int[N];

        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
            }
        }   
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i] + dp2[i]+1);
        }
        System.out.println(answer);
    }
}
