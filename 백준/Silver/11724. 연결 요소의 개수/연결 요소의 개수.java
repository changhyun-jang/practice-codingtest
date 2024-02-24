import java.util.*;
import java.io.*;

public class Main {
    //방문 했는지 확인 배열
    static boolean visited[];

    //인접리스트
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
//      노드의 개수
        int N = Integer.parseInt(st.nextToken());
//      에지의 개수
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            //인접리스트 생성
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            //인접리스트에 추가
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            A[first].add(second);
            A[second].add(first);
        }

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j : A[i]) {
            if (visited[j] == false) {
                dfs(j);
            }
        }
    }
}
