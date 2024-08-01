import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int answer = 0;

        // 가장 긴 증가하는 수열 길이 저장 배열
        int[] dp = new int[N];

        // 가장 긴 증가하는 수열 구하기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer+1);

    }
}
