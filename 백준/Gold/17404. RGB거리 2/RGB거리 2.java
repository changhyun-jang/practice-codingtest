import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] color;
    static boolean[][] check;
    static int[][] dp1;
    static int[][] dp2;
    static int[][] dp3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new int[N][3];
        check = new boolean[N][3];
        dp1 = new int[N][3];
        dp2 = new int[N][3];
        dp3 = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        dp1[0][0] = color[0][0];
        dp1[0][1] = dp1[0][2] = dp1[1][0] = dp1[N - 1][0] = 1001;

        for (int i = 1; i < N; i++) {
            if (i != N - 1) {
                dp1[i][0] = Math.min(dp1[i - 1][1], dp1[i - 1][2]) + color[i][0];
            }
            dp1[i][1] = Math.min(dp1[i - 1][0], dp1[i - 1][2]) + color[i][1];
            dp1[i][2] = Math.min(dp1[i - 1][0], dp1[i - 1][1]) + color[i][2];
        }

        dp2[0][1] = color[0][1];
        dp2[0][0] = dp2[0][2] = dp2[1][1] = dp2[N - 1][1] = 1001;

        for (int i = 1; i < N; i++) {
            if (i != N - 1) {
                dp2[i][1] = Math.min(dp2[i - 1][0], dp2[i - 1][2]) + color[i][1];
            }
            dp2[i][0] = Math.min(dp2[i - 1][1], dp2[i - 1][2]) + color[i][0];
            dp2[i][2] = Math.min(dp2[i - 1][0], dp2[i - 1][1]) + color[i][2];
        }

        dp3[0][2] = color[0][2];
        dp3[0][0] = dp3[0][1] = dp3[1][2] = dp3[N - 1][2] = 1001;
        for (int i = 1; i < N; i++) {
            if (i != N - 1) {
                dp3[i][2] = Math.min(dp3[i - 1][0], dp3[i - 1][1]) + color[i][2];
            }
            dp3[i][0] = Math.min(dp3[i - 1][1], dp3[i - 1][2]) + color[i][0];
            dp3[i][1] = Math.min(dp3[i - 1][0], dp3[i - 1][2]) + color[i][1];
        }
        int answer1 = Math.min(dp1[N - 1][1], dp1[N - 1][2]);
        int answer2 = Math.min(dp2[N - 1][0], dp2[N - 1][2]);
        int answer3 = Math.min(dp3[N - 1][0], dp3[N - 1][1]);
        System.out.println(Math.min(answer1, Math.min(answer2, answer3)));

    }
}
