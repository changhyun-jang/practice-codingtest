import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    N개의 도시,한도시에서 출발해 다른 도시에 도착하는 M개의 버스
    A->B로 가는 비용을 최소화
    
    --문제풀이 
    
    --sudo코드
    N입력
    M입력
    for(M동안) {
    인접리스트 저장
    }
    출발점과 도착점 도시번호 주어짐
    다익스트라 출발점으로 돌린 뒤, 거리배열에서 도시번호 출력
     */
    private static class Node {
        int end;
        int value;

        Node(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }

    static int N, M, S, E;
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.value - o1.value);
    static ArrayList<Node>[] A;

    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            A[start].add(new Node(end, value));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance[S] = 0;
        //다익스트라 알고리즘
        Dijkstra(S);
        System.out.println(distance[E]);
    }

    private static void Dijkstra(int s) {
        queue.add(new Node(s, 0));
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            if (visited[nowNode.end] == true) continue;
            visited[nowNode.end] = true;
            for (Node tempNode : A[nowNode.end]) {
                int end = tempNode.end;
                int val = tempNode.value;
                if(distance[end] > val+distance[nowNode.end]){
                    distance[end]=val+distance[nowNode.end];
                    visited[end] = false;
                    queue.add(new Node(end,distance[end]));
                }
            }
        }
    }


}
