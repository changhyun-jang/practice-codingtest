import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    n개의 도시, n에서 출발하여 도른 도시에 도착하는 m개의 버스
    각 버스는 한 번 사용할 때 필요한 비용이 있음.

    모든 도시의 쌍에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값
     
    도시개수 n개 2<=n<=100
    출발해 다른 도시에 도착하는 m 1<=m<=100000;
    비용은 <= 100000
    시작도시와 도착도시를 연결하는 노선은 하나가 아닐 수 있음
     --sudo
     도시의 개수 n
     버스의 개수 m
     for(m){
        출발도시 도착도시 필요비용
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

    static int N, M;
    static int[][] A;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        for (int[] temp : A) {
            //무한대로 채우기
            Arrays.fill(temp, 10000001);
        }
        //스스로는 0으로 채우기
        for (int i = 1; i <= N; i++) {
            A[i][i] = 0;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (A[start][end] > weight) A[start][end] = weight;
        }

        //플로이드 워셜
        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    A[S][E] = Math.min(A[S][E], A[S][K] + A[K][E]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] >= 10000001) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
