import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        paper = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N && j + 2 < M) {
                    answer = Math.max(answer, paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1]);
                }
                if (i - 1 >= 0 && j + 2 < M) {
                    answer = Math.max(answer, paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i - 1][j + 1]);
                }
                if (i + 2 < N && j + 1 < M) {
                    answer = Math.max(answer, paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 1][j + 1]);
                }
                if (i + 2 < N && j - 1 >= 0) {
                    answer = Math.max(answer, paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 1][j - 1]);
                }
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int y, int x, int temp, int count) {
        if (count == 4) {
            answer = Math.max(temp, answer);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int X = dx[i] + x;
            int Y = dy[i] + y;
            if (X >= 0 && Y >= 0 && Y < N && X < M && !visited[Y][X]) {
                visited[Y][X] = true;
                dfs(Y, X, temp + paper[Y][X], count + 1);
                visited[Y][X] = false;
            }
        }
    }
}
