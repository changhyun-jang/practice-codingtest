import java.util.*;
import java.io.*;

public class Main {
    /*
    조약돌이 N개 있음
    색상은 1부터 M까지중 하나
    랜덤하게 K개를 뽑았을떄 조약돌이 모두 가은 색일 확률을 구하는 프로그램
    M<=50
     */
    static int N, K;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        color = new int[N];
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            count += color[i];
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        double answer = 0;
        for (int i = 0; i < N; i++) {
            double tempAnswer = 0;
            if (color[i] >= K) {
                tempAnswer = 1;
                for (int j = 0; j < K; j++) {
                    double temp = (double) (color[i] - j) / (double) (count - j);
                    tempAnswer *= temp;
                }
            }
            answer += tempAnswer;
        }
        if (answer > 1) {
            answer = 1;
        }
        System.out.println(answer);
    }
}
