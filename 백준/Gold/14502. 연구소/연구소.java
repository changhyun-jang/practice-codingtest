import java.util.*;
import java.io.*;

public class Main {
    /*
    -- 문제 풀이
    무조건 벽을 3개 세워야하므로 백트래킹을 통해 벽을 3개 세움.
    세운뒤 불들이 갈 수 있는 곳을 다 훑고 이때 안전지역이몇개인지 확인.
    바이러스의 위치는 queue에 미리 저장하고,
     */
    static int N, M;
    static int answer;
    static int[][] lab;
    static Queue<Place> queue = new LinkedList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class Place {
        int x;
        int y;

        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    queue.add(new Place(j, i));
                }
            }
        }
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    backtracking(depth + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][M];
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = lab[i][j];
            }
        }
        Queue<Place> tempQueue = new LinkedList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Place poll = queue.poll();
            tempQueue.offer(poll);
            queue.offer(poll);
        }
        while (!tempQueue.isEmpty()) {
            Place virus = tempQueue.poll();
            int X = virus.x;
            int Y = virus.y;
            for (int i = 0; i < 4; i++) {
                int tempX = X + dx[i];
                int tempY = Y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempY < N && tempX < M && temp[tempY][tempX] == 0 && !visited[tempY][tempX]) {
                    visited[tempY][tempX] = true;
                    temp[tempY][tempX] = 2;
                    tempQueue.offer(new Place(tempX, tempY));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) count++;
            }
        }
        answer = Math.max(answer, count);
    }
}
