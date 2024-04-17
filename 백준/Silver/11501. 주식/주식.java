import java.util.*;
import java.io.*;

public class Main {
    static int T, N;
    static int[] Info;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            Info = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxValue = 0;
            int maxIdx = 0;
            for (int j = 0; j < N; j++) {
                Info[j] = Integer.parseInt(st.nextToken());
                if (maxValue <= Info[j]) {
                    maxValue = Info[j];
                    maxIdx = j;
                }
            }
            int start = 0;
            while (start != N - 1) {
                if (start != maxIdx) {
                    for (int j = start; j < maxIdx; j++) {
                        answer += (maxValue - Info[j]);
                    }
                }
                maxValue = 0;
                start = maxIdx;
                if (start == N - 1) break;
                for (int j = start + 1; j < N; j++) {
                    if (maxValue <= Info[j]) {
                        maxValue = Info[j];
                        maxIdx = j;
                    }
                }
                start += 1;
            }
            System.out.println(answer);
        }
    }

}
