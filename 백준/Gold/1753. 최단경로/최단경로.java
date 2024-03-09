import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int end;
        int value;

        Node(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }

    static int V, E, K;
    static ArrayList<Node>[] A;
    static int[] arr;
    static boolean[] visited;
    static PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.value - o2.value);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //정점의 개수 입력
        V = Integer.parseInt(st.nextToken());
        //간선의 개수 입력
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        //시작 정점의 번호 입력
        K = Integer.parseInt(st.nextToken());
        //그래프를 나타낼 인접리스트 초기화
        A = new ArrayList[V + 1];
        //가중치 배열 초기화
        arr = new int[V + 1];
        //방문 배열 초기화
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
            arr[i] = Integer.MAX_VALUE;
        }
        //시작점 0으로 가중치 초기화
        arr[K] = 0;
        //간선의 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            A[start].add(new Node(end, value));
        }

        queue.add(new Node(K, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int end = node.end;
            if (visited[end]) continue;
            visited[end] = true;

            for (Node nextNode : A[end]) {
                int next = nextNode.end;
                int value = nextNode.value;
                if (arr[next] > arr[end] + value) {
                    arr[next] = arr[end] + value;
                    queue.add(new Node(next,arr[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}
