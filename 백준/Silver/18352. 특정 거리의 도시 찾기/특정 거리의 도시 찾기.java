import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] dis;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /*
        -- 문제읽기
        1번부터 N번까지의 도시와 M개의 단방향 도로가 존재
        모든 도로의 가중치는 1
        특정도시 X로 부터 출발시, 최단 거리가 K인 모든 도시들의 번호 출력
        N은30만, M은 100만, K는 30만,X는 N이하
        최단거리가 K인도시 한 줄에 하나씩 출력
        최단거리가 K인 도시가 존재하지 않으면 -1출력

        -- sudo
        ArrayList<Integer>[N] A;
        도시개수N, 도로개수M, 거리정보K,출발도시번호X 입력
        도시별 거리를 나타내는 배열 선언, N크기
        for(M) {
            S 시작 노드 입력받기
            E 끝 노드 입력받기
            A[S].add[E]
        }

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //도시개수 입력
        int N = Integer.parseInt(st.nextToken());
        //도로개수 입력
        int M = Integer.parseInt(st.nextToken());
        //거리정보 입력
        int K = Integer.parseInt(st.nextToken());
        //출발도시번호 입력
        int X = Integer.parseInt(st.nextToken());
        //노드별 연결 정보를 담을 ArrayList선언
        A = new ArrayList[N + 1];
        //시작 노드에서의 거리를 담을 배열;
        dis = new int[N + 1];
        //방문배열
        visited = new boolean[N + 1];

        boolean signal = false;

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }

        BFS(X);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == K) {
                signal= true;
                bw.write(Integer.toString(i)+"\n");
            }
        }
        if(signal==false) {
            System.out.println(-1);
        }else{
            bw.flush();
            bw.close();
        }

    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.offer(x);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < A[now].size(); i++) {
                if (visited[A[now].get(i)] == false) {
                    queue.offer(A[now].get(i));
                    dis[A[now].get(i)] = dis[now] + 1;
                    visited[A[now].get(i)] = true;
                }
            }
        }
    }
}
