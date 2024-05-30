import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] sum;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        sum = new int[N];
        sum[0] = value[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + value[i];
        }
        answer = new int[N - K + 1];
        answer[0] = sum[K - 1];
        for (int i = 1; i < N - K + 1; i++) {
            answer[i] = sum[i + K - 1] - sum[i - 1];
        }
        Arrays.sort(answer);
        System.out.println(answer[N - K]);

    }
}
