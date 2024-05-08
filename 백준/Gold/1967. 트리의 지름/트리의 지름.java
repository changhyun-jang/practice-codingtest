import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Node>[] A;
    static boolean[] visited;

    static int answer;
    static int second;

    static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = 0;
        second = 0;

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            A[S].add(new Node(E, W));
            A[E].add(new Node(S, W));
        }
        if (N != 1) {
            visited[1] = true;
            dfs(1, 0);
            visited = new boolean[N + 1];
            visited[second] = true;
            dfs(second,0);
        }
        System.out.println(answer);

    }

    private static void dfs(int start, int w) {
        if (answer < w) {
            answer = w;
            second = start;
        }
        for (Node temp : A[start]) {
            if (!visited[temp.end]) {
                visited[temp.end] = true;
                dfs(temp.end, w + temp.weight);
                visited[temp.end] = false;
            }
        }
    }
}
