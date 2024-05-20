import java.util.*;
import java.io.*;

public class Main {
    static int N, answer;
    static long M;
    static int[] Arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        answer = 0;
        Arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Arr);
        BinarySearch();
        System.out.println(answer);

    }

    private static void BinarySearch() {
        int start = 0;
        int end = Arr[N - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int i = N - 1; i >= 0; i--) {
                sum = sum + Math.max(0, (Arr[i] - mid));
            }
            if (sum == M) {
                answer = mid;
                break;
            } else if (sum < M) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
    }
}
