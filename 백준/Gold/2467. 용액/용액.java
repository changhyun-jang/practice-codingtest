import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long answer, A, B;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int start = 0;
        int end = N - 1;
        A = 0;
        B = 0;
        answer = Long.MAX_VALUE;
        while (start < end) {
            if (answer > Math.abs(arr[start] + arr[end])) {
                A = arr[start];
                B = arr[end];
                answer = Math.abs(arr[start] + arr[end]);
            }

            if (arr[start] + arr[end] < 0) {
                start++;
            } else if (arr[start] + arr[end] > 0) {
                end--;
            } else {
                A = arr[start];
                B = arr[end];
                break;
            }
        }
        System.out.println(A + " " + B);
    }

}
