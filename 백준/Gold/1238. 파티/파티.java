import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;

    static class Village {
        int end;
        int time;

        public Village(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }

    static boolean[] visited;
    static int[] dist;
    static int[] answer;

    static ArrayList<Village>[] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            map[start].add(new Village(end, time));
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i);
            if (i == X) {
                for (int j = 1; j <= N; j++) {
                    answer[j] += dist[j];
                }
            } else {
                answer[i] += dist[X];
            }
        }
        int temp = 0;
        for (int i = 1; i <= N; i++) {
            temp = Math.max(temp, answer[i]);
        }
        System.out.println(temp);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Village> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        q.add(new Village(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Village poll = q.poll();
            if (!visited[poll.end]) {
                visited[poll.end] = true;
            }
            for (Village v : map[poll.end]) {
                if (!visited[v.end] && dist[v.end] > poll.time + v.time) {
                    dist[v.end] = poll.time + v.time;
                    q.add(new Village(v.end, dist[v.end]));
                }
            }
        }
    }
}
