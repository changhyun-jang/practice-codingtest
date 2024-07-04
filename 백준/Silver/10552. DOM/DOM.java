import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, P;

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        answer = 0;
        A = new ArrayList[M + 1];
        visited = new boolean[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int favorite = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());
            A[hate].add(favorite);
        }
        dfs(P);
        System.out.println(answer);

    }

    private static void dfs(int num) {
        if (visited[num]) {
            answer = -1;
            return;
        }
        if (A[num].isEmpty()) {
            return;
        }
        if (!visited[num]) {
            answer++;
            visited[num] = true;
            dfs(A[num].get(0));
        }
    }
}
