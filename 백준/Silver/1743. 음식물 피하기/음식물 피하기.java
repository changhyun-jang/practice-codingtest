import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] A;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x][y] = 1;
        }

        int maxSize = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && A[i][j] == 1) {
                    int size = dfs(i, j, 1);
                    if (maxSize < size) maxSize = size;
                }
            }
        }
        System.out.println(maxSize);

    }

    private static int dfs(int y, int x, int size) {
        visited[y][x] = true;
        int tempSize = size;
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX > 0 && tempY > 0 && tempX <= M && tempY <= N && !visited[tempY][tempX] && A[tempY][tempX] == 1) {
                tempSize = dfs(tempY, tempX, tempSize + 1);
            }
        }
        return tempSize;
    }
}
