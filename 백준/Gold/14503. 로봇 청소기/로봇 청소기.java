import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;

    static class Robot {
        int x;
        int y;
        int direction;

        Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(c, r, dir);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[robot.y][robot.x] == 0) {
                map[robot.y][robot.x] = -1;
                answer++;
            }
            boolean tempCheck = false;
            // 현재 칸의 주변 4칸의 상태를 확인한다.
            for (int i = 0; i < 4; i++) {
                int X = robot.x + dx[i];
                int Y = robot.y + dy[i];
                if (X >= 0 && Y >= 0 && X < M && Y < N && map[Y][X] != 1 && map[Y][X] != -1) {
                    // check하기
                    tempCheck = true;
                }
            }

            // 현재 칸의 주변 4칸중 청소 되지 않은 칸이 1칸이라도 있는 경우
            if (tempCheck) {
                if (robot.direction == 0) {
                    // 방향 북쪽 -> 서쪽
                    robot.direction = 3;
                    if (map[robot.y][robot.x - 1] == 0) robot.x--;
                } else if (robot.direction == 1) {
                    // 방향 동쪽 -> 북쪽
                    robot.direction = 0;
                    if (map[robot.y - 1][robot.x] == 0) robot.y--;
                } else if (robot.direction == 2) {
                    // 방향 남쪽 -> 동쪽
                    robot.direction = 1;
                    if (map[robot.y][robot.x + 1] == 0) robot.x++;
                } else {
                    // 방향 서쪽 -> 남쪽
                    robot.direction = 2;
                    if (map[robot.y + 1][robot.x] == 0) robot.y++;
                }
            } else {
                // 현재 칸의 주변 4칸중 청소 되지 않은 칸이 1칸도 없는 경우
                if (robot.direction == 0) {
                    // 방향 북쪽
                    if (map[++robot.y][robot.x] == 1) break;
                } else if (robot.direction == 1) {
                    // 방향 동쪽
                    if (map[robot.y][--robot.x] == 1) break;
                } else if (robot.direction == 2) {
                    // 방향 남쪽
                    if (map[--robot.y][robot.x] == 1) break;
                } else {
                    // 방향 서쪽
                    if (map[robot.y][++robot.x] == 1) break;
                }
            }
        }
        System.out.println(answer);


    }
}
