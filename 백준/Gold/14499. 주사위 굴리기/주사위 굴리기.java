import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;

    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static int[] dice = new int[7];
    static StringBuffer sb = new StringBuffer();
    // 1 위, 2 남, 3 동, 4 서, 5 북, 6 바닥
    // 남으로 뒤집기
    // 2 -> 6, 6 -> 5, 5 -> 1, 1 -> 2

    // 북으로 뒤집기
    // 5 -> 6, 6 -> 2, 2 -> 1, 1 -> 5

    // 동으로 뒤집기
    // 3-> 6, 6-> 4, 4 -> 1, 1-> 3

    // 서로 뒤집기
    // 4->6, 6->3, 3-> 1, 1-> 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());
            int X = y + dx[command];
            int Y = x + dy[command];
            if (X >= 0 && X < M && Y >= 0 && Y < N) {
                int temp;
                if (command == 1) {
                    // 동으로 뒤집기
                    // 3-> 6, 6-> 4, 4 -> 1, 1-> 3
                    temp = dice[3];
                    dice[3] = dice[1];
                    dice[1] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = temp;
                } else if (command == 2) {
                    // 서로 뒤집기
                    // 4->6, 6->3, 3-> 1, 1-> 4
                    temp = dice[4];
                    dice[4] = dice[1];
                    dice[1] = dice[3];
                    dice[3] = dice[6];
                    dice[6] = temp;
                } else if (command == 3) {
                    // 북으로 뒤집기
                    // 5 -> 6, 6 -> 2, 2 -> 1, 1 -> 5
                    temp = dice[5];
                    dice[5] = dice[1];
                    dice[1] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = temp;
                } else {
                    // 남으로 뒤집기
                    // 2 -> 6, 6 -> 5, 5 -> 1, 1 -> 2
                    temp = dice[2];
                    dice[2] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = temp;
                }
                if (map[Y][X] != 0) {
                    dice[6] = map[Y][X];
                    map[Y][X] = 0;
                    x = Y;
                    y = X;
                } else {
                    map[Y][X] = dice[6];
                    x = Y;
                    y = X;
                }
                sb.append(dice[1] + "\n");
            }
        }
        System.out.println(sb);
    }
}
