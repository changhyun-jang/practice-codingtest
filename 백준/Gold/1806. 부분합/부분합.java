import java.util.*;
import java.io.*;


public class Main {
    static int N, S;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        long sum = A[start];

        while (end < N) {
            if (sum >= S) {
                length = Math.min(length, end + 1 - start);
                if (sum > S) {
                    if (start == end) {
                        end += 1;
                        if (end == N) break;
                        sum += A[end];
                    } else {
                        sum -= A[start];
                        start += 1;
                        if (start > end) break;
                    }
                } else {
                    end++;
                    if (end == N) break;
                    sum += A[end];
                }
            } else {
                end++;
                if (end == N) break;
                sum += A[end];
            }
        }
        if (length == Integer.MAX_VALUE) {
            length = 0;
        }
        System.out.println(length);
    }
}
