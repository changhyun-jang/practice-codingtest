import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            A[i][0] = 1;
            A[i][1] = i;
            A[i][i] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                A[i][j] = A[i-1][j] + A[i-1][j-1];
            }
        }
        System.out.println(A[N][K]);

    }
}
