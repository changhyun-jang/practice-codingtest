import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int beforeMelt, time;

    static class Cheese {
        int x;
        int y;

        Cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int[][] temp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static Queue<Cheese> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        temp = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new Cheese(j, i));
                }
            }
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            temp[0][0] = 2;
            changeZeroToMinus(0, 0);
            beforeMelt = queue.size();
            for (int i = 0; i < beforeMelt; i++) {
                Cheese pollCheese = queue.poll();
                boolean check = false;
                for (int j = 0; j < 4; j++) {
                    int X = dx[j] + pollCheese.x;
                    int Y = dy[j] + pollCheese.y;
                    if (X >= 0 && X < W && Y >= 0 && Y < H && temp[Y][X] == 2) {
                        map[pollCheese.y][pollCheese.x] = 0;
                        check = true;
                        break;
                    }
                }
                if (!check) queue.offer(pollCheese);
            }
            time++;
        }
        System.out.println(time);
        System.out.println(beforeMelt);

    }

    private static void changeZeroToMinus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int X = dx[i] + x;
            int Y = dy[i] + y;
            if (X >= 0 && X < W && Y >= 0 && Y < H && temp[Y][X] == 0) {
                temp[Y][X] = 2;
                changeZeroToMinus(X, Y);
            }
        }
    }
}
