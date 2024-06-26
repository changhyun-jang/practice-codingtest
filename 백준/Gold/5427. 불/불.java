import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;

    static String[][] building;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class Sang {
        int x;
        int y;

        Sang(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class fire {
        int x;
        int y;

        fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Sang sang;
    static Queue<fire> fireQueue;
    static Queue<Sang> sangQueue;
    static boolean[][] visited;
    static int answer;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            fireQueue = new LinkedList();
            sangQueue = new LinkedList();
            // 몇 초 걸리는지 확인 변수
            answer = 0;
            // 나갈 수 있는지 확인 플래그
            flag = false;
            // 빌딩의 상태 배열
            building = new String[h][w];
            visited = new boolean[h][w];

            for (int height = 0; height < h; height++) {
                st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                for (int width = 0; width < w; width++) {
                    building[height][width] = String.valueOf(temp.charAt(width));
                    if (building[height][width].equals("@")) {
                        sangQueue.add(new Sang(width, height));
                        visited[height][width] = true;
                    }
                    if (building[height][width].equals("*")) {
                        fireQueue.add(new fire(width, height));
                    }
                }
            }
//            for (int j = 0; j < h; j++) {
//                for (int k = 0; k < w; k++) {
//                    System.out.print(building[j][k]);
//                }
//                System.out.println();
//            }

            while (!sangQueue.isEmpty()) {
                answer++;
                int tempSize = fireQueue.size();
                for (int j = 0; j < tempSize; j++) {
                    fire poll = fireQueue.poll();
                    for (int cnt = 0; cnt < 4; cnt++) {
                        int tempX = poll.x + dx[cnt];
                        int tempY = poll.y + dy[cnt];
                        if (tempX >= 0 && tempX < w && tempY >= 0 && tempY < h && (".".equals(building[tempY][tempX]) || building[tempY][tempX].equals("@"))) {
                            building[tempY][tempX] = "*";
                            fireQueue.add(new fire(tempX, tempY));
                        }
                    }
                }

                tempSize = sangQueue.size();
                for (int j = 0; j < tempSize; j++) {
                    Sang poll = sangQueue.poll();
                    if (poll.x == 0 || poll.x == w - 1 || poll.y == 0 || poll.y == h - 1) {
                        flag = true;
                    }
                    for (int cnt = 0; cnt < 4; cnt++) {
                        int tempX = poll.x + dx[cnt];
                        int tempY = poll.y + dy[cnt];
                        if (tempX >= 0 && tempX < w && tempY >= 0 && tempY < h && ".".equals(building[tempY][tempX]) && !visited[tempY][tempX]) {
                            sangQueue.add(new Sang(tempX, tempY));
                            visited[tempY][tempX] = true;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }

            if (flag) {
                System.out.println(answer);
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }
}
