import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, S, max, answer;
    static String[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    static Queue<Place> queue = new LinkedList<>();

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
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new String[R][S];
        answer = 0;
        visited = new boolean[R][S];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            A[i] = temp.split("");
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if (A[i][j].equals("o")) queue.offer(new Place(j, i));
            }
        }
        while (!queue.isEmpty()) {
            max += bfs();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if (A[i][j].equals(".")) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer+max);
    }

    private static int bfs() {
        int count = 0;
        Place poll = queue.poll();
        visited[poll.y][poll.x] = true;
        for (int i = 0; i < 8; i++) {
            int tempX = poll.x + dx[i];
            int tempY = poll.y + dy[i];
            if (tempX >= 0 && tempX < S && tempY >= 0 && tempY < R && !visited[tempY][tempX] && A[tempY][tempX].equals("o")) {
                count++;
            }
        }
        return count;
    }

    private static int bfs(int y, int x) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX >= 0 && tempX < S && tempY >= 0 && tempY < R && A[tempY][tempX].equals("o")) {
                count++;
            }
        }
        return count;
    }
}
