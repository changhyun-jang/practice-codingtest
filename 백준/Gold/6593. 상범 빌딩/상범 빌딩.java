import java.util.*;
import java.io.*;

public class Main {
    static int L, R, C;
    static String[][][] building;
    static boolean[][][] visited;
    static int endZ = 0, endY = 0, endX = 0;
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int answer;

    static class Place {
        int z;
        int y;
        int x;
        int time;

        Place(int z, int y, int x, int time) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            building = new String[33][33][33];
            visited = new boolean[33][33][33];
            answer = 0;
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            int startZ = 0, startY = 0, startX = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String temp = br.readLine();
                    String[] split = temp.split("");
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = split[k];
                        if (building[i][j][k].equals("S")) {
                            startZ = i;
                            startY = j;
                            startX = k;
                        }
                        if (building[i][j][k].equals("E")) {
                            endZ = i;
                            endY = j;
                            endX = k;
                        }
                    }
                }
                br.readLine();
            }
            BFS(startZ, startY, startX, 0);
            if (answer == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s).");
            }
        }
    }

    private static void BFS(int z, int y, int x, int time) {
        Queue<Place> queue = new LinkedList<>();
        queue.add(new Place(z, y, x, time));
        visited[z][y][x] = true;
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            int Z = poll.z;
            int Y = poll.y;
            int X = poll.x;
            int T = poll.time;
            if (Z == endZ && Y == endY && X == endX) {
                answer = T;
                return;
            }
            for (int i = 0; i < 6; i++) {
                int tempZ = Z + dz[i];
                int tempY = Y + dy[i];
                int tempX = X + dx[i];
                if (tempZ >= 0 && tempZ < L && tempY >= 0 && tempY < R && tempX >= 0 && tempX < C &&
                        !visited[tempZ][tempY][tempX] && !building[tempZ][tempY][tempX].equals("#")) {
                    queue.offer(new Place(tempZ, tempY, tempX, T + 1));
                    visited[tempZ][tempY][tempX] = true;
                }
            }
        }
    }
}
