import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] A;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        subset(0, 0);
        if (S == 0) count--;
        System.out.println(count);
    }

    private static void subset(int i, int sum) {
        if (i == N) {
            if (sum == S) count++;
            return;
        }
        visited[i] = true;
        subset(i + 1, sum + A[i]);
        visited[i] = false;
        subset(i + 1, sum);
    }
}
