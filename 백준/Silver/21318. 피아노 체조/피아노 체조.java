import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q, answer;
    static long[] arr;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        count = new int[N + 1];
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            count[i] = count[i - 1];
            if (arr[i] > arr[i + 1]) count[i]++;
        }
        count[N] = count[N - 1];
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            answer = 0;
            if (x != y) {
                answer = count[y] - count[x - 1];
                if (count[y] != count[y - 1]) answer--;
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
