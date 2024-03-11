import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제 읽기
    N개의 도시, 도시는 0~N-1번호가 매겨짐
    일정은 A->B도시에서 끝남
    
    도시를 방문할때마다 벌 수 있는 돈을 알고 있음.
    도시마다 다르며 액수는 고정됌. 도시를 방문할 때마다 벌게됌
    
    도착 도시에 도착할때. 가지고 있는 돈의 액수를 최대로 하려고함
    이 최댓값을 구하는 프로그램
    
    버는 돈보다 쓰는 돈이 많다면 
    도착도시에 도착할때 가지고 있는 돈의 액수가 음수가 될 수 있음.
    
    같은 도시를 여러번 방문할 수 있으며, 도시를 방문할때마다 돈을 벌게됌.
    모든 교통 수단은 입력으로 주어진 방향으로만 이용할 수 있으며, 여러번 이용가능

    도착할때 가지고 있는 돈의 액수가 최댓값을 출력
    도착하는 것이 불가능하면 gg
    도착도시에서 돈이 무한하면 Gee

    --sudo
    도시의 수N과 시작도시S, 도착도시E, 교통수단의 개수 M이 주어짐
    for(M만큼) {
        교통수단의 정보 주어짐
        시작도시 끝도시 가격
    }
    for(N만큼) {
        각 도시에서 벌 수 있는 가격
    }
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
    }

    static int N, S, E, M;
    static Edge[] edges;
    static long[] distance;
    static long[] income;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        distance = new long[N];
        income = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);

        //도시들의 거리 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, weight);
        }

        st = new StringTokenizer(br.readLine());
        //도시에서 벌 수 있는 수익
        for (int i = 0; i < N; i++) {
            income[i] = Integer.parseInt(st.nextToken());
        }

        //시작도시에 0 대입
        distance[S] = income[S];
        //역벨만포드하기
        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] == Long.MIN_VALUE) continue;
                else if (distance[edge.start] == Long.MAX_VALUE) {
                    distance[edge.end] = Long.MAX_VALUE;
                } else if (distance[edge.end] < distance[edge.start] - edge.weight + income[edge.end]) {
                    distance[edge.end] = distance[edge.start] - edge.weight + income[edge.end];
                    if (i >= N - 1) distance[edge.end] = Long.MAX_VALUE;
                }
            }
        }


        if (distance[E] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if(distance[E] == Long.MAX_VALUE) {
            System.out.println("Gee");
        }else {
            System.out.println(distance[E]);
        }
    }
}
