import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Baby baby;

    static class Place {
        int y;
        int x;
        int time;

        Place(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }


    static class Baby {
        int y;
        int x;
        int size;
        int eatCount;

        Baby(int y, int x, int size, int eatCount) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.eatCount = eatCount;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    baby = new Baby(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            int temp = answer;
            bfs();
            if (baby.eatCount == baby.size) {
                baby.eatCount = 0;
                baby.size++;
            }
            if (temp == answer) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void bfs() {
        visited = new boolean[N][N];
        visited[baby.y][baby.x] = true;
        PriorityQueue<Place> queue = new PriorityQueue<Place>((o1, o2) -> {
            if (o1.time == o2.time) {
                if (o1.y == o2.y) {
                    return o1.x - o2.x;
                } else {
                    return o1.y - o2.y;
                }
            } else {
                return o1.time - o2.time;
            }
        });
        queue.add(new Place(baby.y, baby.x, 0));

        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (map[poll.y][poll.x] < baby.size && map[poll.y][poll.x] != 0) {
                map[baby.y][baby.x] = 0;
                answer += poll.time;
                baby.y = poll.y;
                baby.x = poll.x;
                baby.eatCount += 1;
                map[poll.y][poll.x] = 0;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int tempY = poll.y + dy[i];
                int tempX = poll.x + dx[i];
                if (tempY >= 0 && tempX >= 0 && tempY < N && tempX < N && !visited[tempY][tempX] && map[tempY][tempX] <= baby.size) {
                    visited[tempY][tempX] = true;
                    queue.offer(new Place(tempY, tempX, poll.time + 1));
                }
            }
        }
    }

}
