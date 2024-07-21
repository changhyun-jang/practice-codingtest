import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static long[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new long[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            return 1;
        }
        // 이미 지나가서 목적지에 도달한 적이 있는 것
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if (X >= 0 && Y >= 0 && X < N && Y < M && map[Y][X] < map[y][x]) {
                dp[y][x] += dfs(X, Y);
            }
        }
        return dp[y][x];
    }
}
