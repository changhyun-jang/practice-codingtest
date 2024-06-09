import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, X, max, count;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sum = new int[N - X + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < X; i++) {
            sum[0] += arr[i];
        }
        max = sum[0];
        count = 1;

        for (int i = 1; i < N - X + 1; i++) {
            sum[i] = sum[i - 1] - arr[i - 1] + arr[i + X - 1];
            if (max < sum[i]) {
                max = sum[i];
                count = 1;
            } else if (max == sum[i]) {
                count++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
