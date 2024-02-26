
import java.util.*;
import java.io.*;

public class Main {
    //노드 개수
    static int N;
    //그래프 데이터 저장 인접 리스트
    static ArrayList<Edge>[] A;
    //방문배열
    static boolean[] visited;
    //거리 저장 인접리스트
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= N; i++) {
            int S = sc.nextInt();
            while (true) {
                int D = sc.nextInt();
                if (D == -1) {
                    break;
                }
                int V = sc.nextInt();
                Edge edge = new Edge(D, V);
                A[S].add(edge);
            }
        }
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        BFS(1);
        int max_index = 1;
        for (int i = 2; i < distance.length ; i++) {
            if(distance[i]> distance[max_index]) {
                max_index = i;
            }
        }
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(max_index);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (Edge e : A[num]) {
                if(!visited[e.e]) {
                    queue.offer(e.e);
                    visited[e.e]=true;
                    distance[e.e] = distance[num] +e.value;
                }
            }
        }

    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
