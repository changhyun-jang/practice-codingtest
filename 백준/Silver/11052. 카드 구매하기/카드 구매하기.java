import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] A;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        DP = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        DP[1] = A[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                DP[i] = Math.max(DP[i], (DP[i - j] + A[j]));
            }
        }
        System.out.println(DP[N]);
    }
}
