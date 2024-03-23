import java.util.*;
import java.io.*;

public class Main {
    /*
    N개의 수로 된 수열 A[N]이 있다. 이 수열의 i번째 수부터 j번째 수까지의
    합 이 M이되는 경우의 수를 구하시오.
     */
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        long sum = A[start];
        while (end < N) {
            if (sum == M) {
                count += 1;
                end += 1;
                if (end == N) break;
                sum += A[end];
            } else if (sum > M) {
                if(start == end) {
                    end++;
                    if (end == N) break;
                    sum += A[end];
                }
                sum -= A[start];
                start += 1;
                if (start > end) break;
            } else{
                end += 1;
                if (end == N) break;
                sum += A[end];
            }
        }
        System.out.println(count);
    }
}
