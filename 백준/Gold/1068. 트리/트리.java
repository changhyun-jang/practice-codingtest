import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, D;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count = 0;
    static int start = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int child = i;
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                A[parent].add(child);
                A[child].add(parent);
            } else {
                start = i;
            }
        }
        D = Integer.parseInt(br.readLine());
        dfs(start, 1);
        System.out.println(count);
    }

    private static void dfs(int num, int check) {
        if (num == D) {
            return;
        }
        int temp = check;
        visited[num] = true;
        for (int i : A[num]) {
            if (visited[i] == false && i != D) {
                check++;
                dfs(i, check);
            }
        }
        if (temp == check) {
            count++;
        }
    }
}
