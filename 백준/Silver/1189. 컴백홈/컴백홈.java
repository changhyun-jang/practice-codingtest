import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static String[][] map;
    static boolean[][] visited;
    static int R, C, K, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];
        count = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = split[j];
            }
        }
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 0);
        System.out.println(count);
    }

    private static void dfs(int y, int x, int distance) {
        if (distance == K-1) {
            if (y == 0 && x == C - 1) {
                count++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int X = dx[i] + x;
            int Y = dy[i] + y;
            if (X >= 0 && Y >= 0 && Y <= R - 1 && X <= C - 1 && !visited[Y][X] && !map[Y][X].equals("T")) {
                visited[Y][X] = true;
                dfs(Y, X, distance + 1);
                visited[Y][X] = false;
            }
        }

    }
}
