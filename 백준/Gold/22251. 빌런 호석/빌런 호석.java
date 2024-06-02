import java.util.*;
import java.io.*;

public class Main {
    static int K, P;
    static String N, X;
    static int[][] num = {{1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}};
    static int answer;
    static int[][] now;

    static String[] nowNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = st.nextToken();
        answer = 0;

        // 현재 값을 나타내는 배열에 0으로 다 채워넣기
        now = new int[K][7];
        while (X.length() < K) {
            X = "0" + X;
        }
        nowNum = X.split("");
        for (int i = 0; i < nowNum.length; i++) {
            now[i] = num[Integer.parseInt(nowNum[i])];
        }

        // N개의 숫자들과 비교
        for (int i = 1; i <= Integer.parseInt(N); i++) {
            if (i != Integer.parseInt(X)) {
                int diff = 0;
                int T = i;
                int[][] temp = new int[K][7];
                for (int j = K - 1; j >= 0; j--) {
                    temp[j] = num[T % 10];
                    T /= 10;
                }

                for (int j = 0; j < K; j++) {
                    for (int k = 0; k < 7; k++) {
                        if (temp[j][k] != now[j][k]) {
                            diff++;
                        }
                    }
                }
                if (diff <= P) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
