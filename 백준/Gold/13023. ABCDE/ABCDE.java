import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];

        for (int i = 0; i < N; i++) {
            //인접리스트 생성
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            A[first].add(second);
            A[second].add(first);
        }

        int count = 1;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N + 1];
            dfs(i, count);
            if(result==true) break;
        }

        if (result == false) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    private static void dfs(int i, int count) {
        if (count > 4) {
            result = true;
            return;
        }
        visited[i] = true;
        for (int j : A[i]) {
            if (visited[j] == false) {
                dfs(j, count+1);
            }
        }
        //다시방문하기 위함
        visited[i]=false;
    }
}
