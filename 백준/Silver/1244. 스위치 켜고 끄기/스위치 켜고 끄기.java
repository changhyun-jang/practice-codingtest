import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] S = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == 0) {
                S[i] = false;
            } else {
                S[i] = true;
            }
        }
        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (num == 2) {
                S[M] = !S[M];
                int L = M - 1;
                int R = M + 1;
                while (L > 0 && R <= N) {
                    if (S[L] != S[R]) {
                        break;
                    } else {
                        S[L] = !S[L];
                        S[R] = !S[R];
                        L--;
                        R++;
                    }
                }
            } else {
                for (int j = M; j <= N; j += M) {
                    S[j] = !S[j];
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (count == 20) {
                System.out.println();
                count=0;
            }
            if (S[i]) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
            count++;
        }
    }
}
