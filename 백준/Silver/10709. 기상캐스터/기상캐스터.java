import java.util.*;
import java.io.*;

public class Main {
    static int H, W;
    static int[][] map;

    static class Place {
        int y;
        int x;

        Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Queue<Place> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            String[] temp = st.nextToken().split("");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals("c")) {
                    map[i][j] = 0;
                    queue.add(new Place(i, j));
                } else {
                    map[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            int X = poll.x;
            int Y = poll.y;
            if (X + 1 < W && map[Y][X + 1] == -1) {
                map[Y][X + 1] = map[Y][X] + 1;
                queue.add(new Place(Y, X + 1));
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
