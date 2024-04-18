import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, answer;
    static int[][] arr;
    static int[][] rotate;
    static boolean[] visited;
    static int[][] temp;
    static boolean[][] tempVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        rotate = new int[K][3];
        visited = new boolean[K];
        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rotate[i][0] = Integer.parseInt(st.nextToken());
            rotate[i][1] = Integer.parseInt(st.nextToken());
            rotate[i][2] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0, new int[K]);
        System.out.println(answer);
    }

    private static void backTracking(int start, int depth, int[] tempOrder) {
        if (depth == K) {
            temp = new int[N + 1][M + 1];
            tempVisited = new boolean[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < tempOrder.length; i++) {
                rotates(rotate[tempOrder[i]][0], rotate[tempOrder[i]][1], rotate[tempOrder[i]][2]);
            }
            answer = Math.min(answer, getMin());

            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempOrder[depth] = i;
                backTracking(start, depth + 1, tempOrder);
                visited[i] = false;
            }
        }
    }

    private static int getMin() {
        int tableValue = Integer.MAX_VALUE;
        for (int k = 1; k <= N; k++) {
            int rowSum = 0;
            for (int j = 1; j <= M; j++) {
                rowSum += temp[k][j];
            }
            if (tableValue > rowSum) tableValue = rowSum;
        }
        return tableValue;
    }

    private static void rotates(int r, int c, int s) {
        if (s < 1) return;
        int startY = r - s;
        int startX = c - s;
        int endY = r + s;
        int endX = c + s;

        int upRightTemp = temp[startY][endX];
        for (int i = endX; i > startX; i--) {
            temp[startY][i] = temp[startY][i - 1];
        }
        int downRightTemp = temp[endY][endX];
        for (int i = endY; i > startY; i--) {
            temp[i][endX] = temp[i - 1][endX];
        }
        temp[startY + 1][endX] = upRightTemp;


        int downLeftTemp = temp[endY][startX];
        for (int i = startX; i < endX; i++) {
            temp[endY][i] = temp[endY][i + 1];
        }
        temp[endY][endX - 1] = downRightTemp;

        for (int i = startY; i < endY; i++) {
            temp[i][startX] = temp[i + 1][startX];
        }
        temp[endY - 1][startX] = downLeftTemp;


        rotates(r, c, s - 1);
    }
}
