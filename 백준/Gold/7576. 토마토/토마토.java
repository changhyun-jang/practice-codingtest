import java.util.*;
import java.io.*;


public class Main {
    static int N, M;
    static int[][] box;
    static boolean checkZero;
    static boolean checkOne;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Info> queue = new LinkedList<>();
    static boolean[][] visited;
    static int answer;

    static class Info {
        int x;
        int y;
        int depth;

        Info(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];
        visited = new boolean[M][N];
        answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) checkZero = true;
                if (box[i][j] == 1) {
                    checkOne = true;
                    queue.add(new Info(j, i, 0));
                    visited[i][j] = true;
                }
            }
        }
        if (!checkOne) System.out.println(-1);
        else if (!checkZero) System.out.println(0);
        else {
            BFS();
            checkZero = false;
            checkOne = false;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (box[i][j] == 0) checkZero = true;
                    if (box[i][j] == 1) checkOne = true;
                }
            }
            if (checkZero) System.out.println(-1);
            else System.out.println(answer);
        }
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            int X = now.x;
            int Y = now.y;
            int depth = now.depth;
            if (depth > answer) answer = depth;
            for (int i = 0; i < 4; i++) {
                int tempX = X + dx[i];
                int tempY = Y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < M && !visited[tempY][tempX] && box[tempY][tempX] == 0) {
                    visited[tempY][tempX] = true;
                    box[tempY][tempX] = 1;
                    queue.offer(new Info(tempX, tempY, depth + 1));
                }
            }
        }
    }
}
