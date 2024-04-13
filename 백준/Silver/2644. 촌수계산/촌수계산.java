import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, P1, P2, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        P1 = Integer.parseInt(st.nextToken());
        P2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        dfs(P1);
        if (depth[P2] == 0) {
            System.out.println(-1);
        }else{
            System.out.println(depth[P2]);
        }
    }

    private static void dfs(int p1) {
        if (p1 == P2) {
            return;
        }
        visited[p1] = true;
        for (int temp : A[p1]) {
            if (!visited[temp]) {
                depth[temp] = depth[p1] + 1;
                dfs(temp);
            }
        }
    }
}
