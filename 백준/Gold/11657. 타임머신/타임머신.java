import java.util.*;
import java.io.*;

public class Main {
    //간선을 나타내는 클래스 선언
    static class Edge {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    //도시의 개수, 버스노선의 개수 저장 변수 선언
    static int N, M;
    //최소 거리를 저장할 배열선언
    static long[] distance;
    //간선을 저장할 배열 선언
    static Edge[] edges;
    //음수 싸이클 확인 변수
    static boolean cycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];
        edges = new Edge[M + 1];
        //거리를 나타내는 배열에 최댓값 넣기
        Arrays.fill(distance, Long.MAX_VALUE);

        // 버스노선의 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, weight);
        }

        //벨만포드 알고리즘 수행하기
        distance[1] = 0;
        //N-1번 반복
        for (int i = 1; i < N; i++) {
            //edges 배열 순회하며 최솟값 갱신
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                if (distance[edge.start] != Long.MAX_VALUE
                        && distance[edge.end] > edge.weight + distance[edge.start]) {
                    distance[edge.end] = edge.weight + distance[edge.start];
                }
            }
        }

        //음수 싸이클이 순회하는지 확인(위작업 1번더)
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            //변하는 값이 있으면 cycle이 있는 것으로 확인
            if (distance[edge.start] != Long.MAX_VALUE
                    && distance[edge.end] > edge.weight + distance[edge.start]) {
                cycle = true;
            }
        }

        if (cycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Long.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        }

    }
}
