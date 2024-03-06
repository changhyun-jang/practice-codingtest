import java.util.*;
import java.io.*;

public class Main {
    /*
        --문제 읽기
        그래프의 정점의 집합을 둘로 분할, 각 집합에 속한 정점끼리는
        인접하지 않도록 분할 할수 있을때, 해당 그래프를 이분그래프
        이분 그래프인지 판별

        -- 문제 해석
        1 -- 3          1 -- 2  ---
             |               |    |
             2               3 -- 4

        -- sudo 코드


        인접리스트 선언
        visited 방문 배열 선언
        check배열 선언
        answer = TRUE
        테스트 케이스 개수 K 입력
        for(K) {
            그래프의 정점의 개수V 와 간선의 개수 E가 주어짐
            인접리스트 크기V로 초기화
            for(V){
                인접리스트에 리스트 초기화
            }
            for(E) {
                u입력
                v입력
                인접리스트에 추가
            }
            BFS(1)
            for(int i = 1; i<= V; i++) {
                boolean now = check[i];
                for(int j : A[i]) {
                    if(now == check[j]) answer = false; break;
                }
            }
            if(answer) {
                YES
            } else{
                NO
                }
        }

        BFS() {
            Queue선언
            1큐에 넣기
            visited= true;
            while(큐가 비어있지 않은 동안) {
                now = queue.poll();
                for(int i : A[now]) {
                    if(visited == false) {
                        visited=true;
                        queue에 넣기
                        check[i] = !check[now];
                    }
                }
            }
        각 정점에는 1부터 V까지 차례로 번호가 붙음.
         */
    //인접리스트
    static ArrayList<Integer>[] A;
    //방문체크배열
    static boolean[] visited;
    //BFS결과를 저장할 result
    static boolean[] result;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            answer = true;
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A = new ArrayList[V + 1];
            result = new boolean[V + 1];
            visited = new boolean[V + 1];

            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(s);
            }

            for (int j = 1; j <= V; j++) {
                if (answer) {
                    BFS(j);
                } else {
                    break;
                }
            }

            if (answer == false) {
                bw.write("NO \n");
            } else {
                bw.write("YES \n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void DFS(int j) {
        visited[j] = true;
        for (int k : A[j]) {
            if (visited[k] == false) {
                result[k] = !result[j];
                DFS(j);
            } else if (result[k] == result[j]) {
                answer = false;
            }
        }
    }

    private static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int j : A[now]) {
                if (visited[j] == false) {
                    queue.offer(j);
                    visited[j] = true;
                    result[j] = !result[now];
                } else if (result[j] == result[now]) {
                    answer = false;
                }
            }

        }
    }
}
