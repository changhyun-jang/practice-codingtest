import java.util.*;
import java.io.*;

public class Main {
    /*
    루피 , 도둑루피
    도둑루피만 가득한 NxN 크기의 동굴의 제일 왼쪽 위에 있다.
    [0][0] => [N-1][N-1]까지 이동해야한다.
    동굴의 각 칸마다 도둑루피가 있는데, 이칸을 지나면 도둑루피의
    크기만큼 소지금을 잃게 된다.
    링크는 잃는 금액을 최소로하여 동굴 건너편까지 이동해야함
    한번에 상하좌우 인접한 곳으로 1칸씩 이동
    링크가 잃을 수 밖에 없는 최소 금액은 얼마 일까?
     */

    static class Space {
        int x;
        int y;
        int value;

        Space(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;
    static boolean[][] visited;
    static int[][] map;
    static int[][] distance;
    static ArrayList<Integer> Answer = new ArrayList<>();
    static PriorityQueue<Space> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            visited = new boolean[N][N];
            map = new int[N][N];
            distance = new int[N][N];
            for (int[] temp : distance) {
                Arrays.fill(temp, Integer.MAX_VALUE);
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs(new Space(0, 0, map[0][0]));
//            for (int i = 0; i < N; i++) {
//                System.out.println();
//                for (int j = 0; j < N; j++) {
//                    System.out.print(distance[i][j]);
//                }
//            }
            Answer.add(distance[N - 1][N - 1]);
        }
        for (int i = 0; i < Answer.size(); i++) {
            System.out.println("Problem " + (i + 1) + ": " + Answer.get(i));
        }
    }

    private static void bfs(Space space) {
        queue.add(space);
        distance[0][0] = map[0][0];
        while (!queue.isEmpty()) {
            Space nowSpace = queue.poll();
            visited[nowSpace.x][nowSpace.y] = true;
            for (int i = 0; i < 4; i++) {
                int x = nowSpace.x + dx[i];
                int y = nowSpace.y + dy[i];
                if (x >= 0 && y >= 0 && x < N && y < N && visited[x][y] == false && distance[x][y] > distance[nowSpace.x][nowSpace.y] + map[x][y]) {
                    distance[x][y] = distance[nowSpace.x][nowSpace.y] + map[x][y];
                    queue.add(new Space(x, y, distance[x][y]));
                }
            }
        }
    }
}
