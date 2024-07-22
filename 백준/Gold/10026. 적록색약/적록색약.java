import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int noneBlind = 0;
    static int Blind = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = split[j];
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                    noneBlind++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("R")) {
                    map[i][j] = "G";
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                    Blind++;
                }
            }
        }
        System.out.println(noneBlind + " " + Blind);
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int Y = y + dy[i];
            int X = x + dx[i];
            if (X >= 0 && X < N && Y >= 0 && Y < N && !visited[Y][X] && map[Y][X].equals(map[y][x])) {
                visited[Y][X] = true;
                dfs(Y, X);
            }
        }
    }
}
