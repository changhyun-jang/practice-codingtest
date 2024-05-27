import java.util.*;
import java.io.*;

public class Main {
    static int N, M, answer;
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        value = new int[N];
        answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        binarySearch();
        System.out.println(answer);
    }

    private static void binarySearch() {
        int start = 1;
        int end = value[N - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            long temp = 0;
            for (int i = 0; i < N; i++) {
                if (value[i] <= mid) {
                    temp += value[i];
                } else {
                    temp += mid;
                }
            }
            if (temp > M) {
                end = mid - 1;
            } else if (temp == M) {
                answer = mid;
                break;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
    }
}
