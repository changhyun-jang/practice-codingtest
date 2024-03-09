import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제 해석
    1- 2 3 4
    2-
    3- 4 5
    4-
    5-

    1 2 3 4 5
    0 1 1 2 1
    --sudo코드
    문제개수N입력
    ArrayList 만들기
    2차원배열[N][N]만들기
    for(N만큼) {
        for(N만큼) {
            if -1이면 break;
        }
    }

    
     */
    static int N;
    static ArrayList<Integer>[] A;
    static int[] parent;
    static int[][] buildingInfo;
    static int[] result;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        parent = new int[N + 1];
        buildingInfo = new int[N + 1][N + 1];
        result = new int[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) {
                    break;
                } else {
                    if (j != 1) {
                        A[temp].add(i);
                        parent[i]++;
                    } else {
                        result[i] = temp;
                    }
                }
            }
        }

        //위상정렬 시작
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A[now]) {
                parent[next]--;
                answer[next] = Math.max(answer[next], result[now]+answer[now]);
                if (parent[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]+result[i]);
        }
    }
}
