import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static int[][] map;
    static int[][] check;
    static String[] changeInfo;

    static class Snake {
        int headX;
        int headY;
        int tailX;
        int tailY;
        String direction;

        Snake(int headX, int headY, int tailX, int tailY, String direction) {
            this.direction = direction;
            this.headX = headX;
            this.headY = headY;
            this.tailX = tailX;
            this.tailY = tailY;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = 0;
        Snake snake = new Snake(1, 1, 1, 1, "r");
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        check = new int[N + 1][N + 1];
        check[1][1] = 1;
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            map[Y][X] = 1;
        }
        L = Integer.parseInt(br.readLine());
        changeInfo = new String[10001];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            changeInfo[X] = st.nextToken();
        }
        while (true) {
            time++;
            // 머리 옮기기
            if (snake.direction.equals("r")) {
                if (snake.headX + 1 > N) {
                    break;
                }
                snake.headX++;
            } else if (snake.direction.equals("l")) {
                if (snake.headX - 1 == 0) {
                    break;
                }
                snake.headX--;
            } else if (snake.direction.equals("d")) {
                if (snake.headY + 1 > N) {
                    break;
                }
                snake.headY++;
            } else {
                if (snake.headY - 1 == 0) {
                    break;
                }
                snake.headY--;
            }

            //머리를 옮겼을 때 해당 위치가 몸이 위치한 곳이었다면
            if (check[snake.headY][snake.headX] != 0) {
                break;
            }
            // 머리 옮긴 곳 현재시간+1 입력
            check[snake.headY][snake.headX] = time + 1;

            // 만약 머리 옮긴곳에 사과가 없다면 꼬리도 1칸씩 옮겨야하므로 진행
            if (map[snake.headY][snake.headX] != 1) {
                int tailCheck = check[snake.tailY][snake.tailX];
                check[snake.tailY][snake.tailX] = 0;
                int[] dx = {0, 1, 0, -1};
                int[] dy = {1, 0, -1, 0};
                for (int i = 0; i < 4; i++) {
                    int X = dx[i] + snake.tailX;
                    int Y = dy[i] + snake.tailY;
                    if (X > 0 && X <= N && Y > 0 && Y <= N && check[Y][X] == tailCheck + 1) {
                        snake.tailX = X;
                        snake.tailY = Y;
                        break;
                    }
                }
            } else {
                map[snake.headY][snake.headX] = 0;
            }
            // 방향전환해야되는 타이밍이면 
            if (changeInfo[time] != null) {
                String s = changeInfo[time];
                //오른쪽으로 90도 회전
                if (s.equals("D")) {
                    if (snake.direction.equals("r")) {
                        snake.direction = "d";
                    } else if (snake.direction.equals("l")) {
                        snake.direction = "u";
                    } else if (snake.direction.equals("d")) {
                        snake.direction = "l";
                    } else {
                        snake.direction = "r";
                    }
                    // 왼쪽으로 90도 회전
                } else {
                    if (snake.direction.equals("r")) {
                        snake.direction = "u";
                    } else if (snake.direction.equals("l")) {
                        snake.direction = "d";
                    } else if (snake.direction.equals("d")) {
                        snake.direction = "r";
                    } else {
                        snake.direction = "l";
                    }
                }
            }
        }
        System.out.println(time);
    }
}
