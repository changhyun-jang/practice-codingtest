import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    M*N 모눈종이 가있다.
    K개의 직사각형을 그릴때, `
     */

    static int M, N, K;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    map[k][j] = 1;
                }
            }
        }

//        for (int i = 0; i <M ; i++) {
//            for (int j = 0; j <N ; j++) {
//                System.out.print(map[i][j]+" ");
//
//            }
//            System.out.println();
//
//        }
        int count = 0;
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && map[i][j] == 0) {
                    A.add(dfs(j, i, 1));
                    count++;
                }
            }
        }
        System.out.println(count);

        Collections.sort(A);
        for(Integer i : A) {
            System.out.print(i+" ");
        }

    }

    private static Integer dfs(int a, int b, int size) {
        visited[b][a] = true;
        int temp = size;
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (x > -1 && y > -1 && x < N && y < M && visited[y][x] == false && map[y][x] == 0) {
                temp = dfs(x, y, temp + 1);
            }
        }
        return temp;
    }

}
