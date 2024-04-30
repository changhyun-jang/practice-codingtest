import java.util.*;
import java.io.*;


public class Main {
    static int N, M, H;
    static int[][][] box;
    static boolean[][][] visited;
    static boolean checkZero;
    static boolean checkOne;
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Info> queue = new LinkedList<>();

    static int answer;

    static class Info {
        int z;
        int x;
        int y;
        int depth;

        Info(int x, int y, int z, int depth) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][M][N];
        visited = new boolean[H][M][N];
        answer = 0;
        for (int z = 0; z < H; z++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    box[z][i][j] = Integer.parseInt(st.nextToken());
                    if (box[z][i][j] == 0) checkZero = true;
                    if (box[z][i][j] == 1) {
                        checkOne = true;
                        queue.add(new Info(j, i, z, 0));
                        visited[z][i][j] = true;
                    }
                }
            }
        }

        if (!checkOne) System.out.println(-1);
        else if (!checkZero) System.out.println(0);
        else {
            BFS();
            checkZero = false;
            checkOne = false;
            for (int z = 0; z < H; z++) {
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        if (box[z][i][j] == 0) checkZero = true;
                    }
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
            int Z = now.z;
            int depth = now.depth;
            if (depth > answer) answer = depth;
            for (int i = 0; i < 6; i++) {
                int tempX = X + dx[i];
                int tempY = Y + dy[i];
                int tempZ = Z + dz[i];
                if (tempX >= 0 && tempY >= 0 && tempZ >= 0 && tempX < N && tempY < M && tempZ < H && !visited[tempZ][tempY][tempX] && box[tempZ][tempY][tempX] == 0) {
                    visited[tempZ][tempY][tempX] = true;
                    box[tempZ][tempY][tempX] = 1;
                    queue.offer(new Info(tempX, tempY, tempZ, depth + 1));
                }
            }
        }
    }
}

