import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제풀이
    대놓고 최소신장트리를 구하는 문제
     */
    static class Edge {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    static int V, E;
    static Edge[] edges;
    static int[] parent;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, weight);
        }
        //가중치로 정렬
        Arrays.sort(edges, (o1, o2) -> {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        });

        for (int i = 0; i < E; i++) {
            int start = edges[i].start;
            int end = edges[i].end;
            boolean temp = union(start, end);
            if (temp) answer += edges[i].weight;
        }

        System.out.println(answer);

//        for (int i = 0; i < E; i++) {
//            System.out.println(edges[i].getWeight());
//        }
    }

    private static boolean union(int A, int B) {
        A = find(A);
        B = find(B);
        if (A != B) {
            parent[B] = A;
            return true;
        }
        return false;
    }

    private static int find(int num) {
        if (parent[num] == num) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }

}
