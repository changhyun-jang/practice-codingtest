import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int num;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static ArrayList<Integer> answer = new ArrayList<>();

    static class place {
        int x;
        int y;

        place(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        map = new int[num][num];
        visited = new boolean[num][num];
        count = 0;
        for (int i = 0; i < num; i++) {
            String temp = sc.next();
            String[] split = temp.split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void bfs(int y, int x) {
        Queue<place> queue = new LinkedList<>();
        queue.add(new place(y, x));
        visited[y][x] = true;
        int temp = 0;
        while (!queue.isEmpty()) {
            place poll = queue.poll();
            temp++;
            int X = poll.x;
            int Y = poll.y;

            for (int i = 0; i < 4; i++) {
                int tempX = X + dx[i];
                int tempY = Y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < num && tempY < num && !visited[tempY][tempX] && map[tempY][tempX] == 1) {
                    queue.offer(new place(tempY, tempX));
                    visited[tempY][tempX] = true;
                }
            }
        }
        answer.add(temp);
    }
}
