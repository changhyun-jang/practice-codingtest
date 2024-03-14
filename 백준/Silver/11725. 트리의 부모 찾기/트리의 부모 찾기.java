import java.util.*;
import java.io.*;

public class Main {
    /*
    -- 문제 풀이
    인접리스트에 양방향 에지로 간주하고 저장
    루트는 1로 지정되어있으므로 내려가면서 각 노드의 부모를 저장하면 됌
     */
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int num) {
        visited[num] = true;
        for (int i : A[num]) {
            if (visited[i] == false) {
                parent[i] = num;
                dfs(i);
            }
        }
    }

}
