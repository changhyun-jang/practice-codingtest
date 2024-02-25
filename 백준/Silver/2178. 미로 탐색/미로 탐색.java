import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] check;
    static int[][] A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //줄개수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N][M];
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String Line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(Line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        check[x][y] = true;
        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int X = temp[0] + dx[i];
                int Y = temp[1] + dy[i];
                if (X >= 0 && Y >= 0 && X < N && Y < M) {
                    if (check[X][Y] == false && A[X][Y] != 0) {
                        check[X][Y] = true;
                        A[X][Y] = A[temp[0]][temp[1]] + 1;
                        queue.add(new int[]{X, Y});
                    }
                }
            }
        }
    }
}
