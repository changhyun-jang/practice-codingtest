import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static String[][] arr;
    static Set<String> check;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R + 1][C + 1];
        answer = 0;

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 0; j < split.length; j++) {
                arr[i][j + 1] = split[j];
            }
        }
        check = new HashSet<>();
        check.add(arr[1][1]);

        dfs(1, 1, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int depth) {
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempY >= 1 && tempX >= 1 && tempX <= C && tempY <= R) {
                if (!check.contains(arr[tempY][tempX])) {
                    check.add(arr[tempY][tempX]);
                    dfs(tempX, tempY, depth + 1);
                    check.remove(arr[tempY][tempX]);
                }
            }
        }
        answer = Math.max(answer, depth);
    }
}
