import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;

    static int AY, answer;

    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        answer = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    AY = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            dust();
            temp[AY][0] = -1;
            temp[AY - 1][0] = -1;
            airCleaner();
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    map[j][k] = temp[j][k];
                }
            }
        }
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if (map[j][k] > 0) {
                    answer += map[j][k];
                }
            }
        }
        System.out.println(answer);
    }

    private static void airCleaner() {
        for (int i = AY + 1; i < R - 1; i++) {
            temp[i][0] = temp[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            temp[R - 1][i] = temp[R - 1][i + 1];
        }
        for (int i = R - 1; i >= AY + 1; i--) {
            temp[i][C - 1] = temp[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            temp[AY][i] = temp[AY][i - 1];
        }
        temp[AY][1] = 0;
        AY--;
        for (int i = AY - 1; i > 0; i--) {
            temp[i][0] = temp[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            temp[0][i] = temp[0][i + 1];
        }
        for (int i = 0; i <= AY - 1; i++) {
            temp[i][C - 1] = temp[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            temp[AY][i] = temp[AY][i - 1];
        }
        temp[AY][1] = 0;
        AY++;
    }

    private static void dust() {
        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int X = j + dx[k];
                        int Y = i + dy[k];
                        if (X >= 0 && X < C && Y >= 0 && Y < R && map[Y][X] != -1) {
                            temp[Y][X] += map[i][j] / 5;
                            count++;
                        }
                    }
                    temp[i][j] += map[i][j] - ((map[i][j] / 5) * count);
                }
            }
        }
    }
}
