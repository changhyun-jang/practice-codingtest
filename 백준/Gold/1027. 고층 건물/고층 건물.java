import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double[] A;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new double[N];
        answer = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            answer[i] += 1;
            answer[i + 1] += 1;
            for (int j = i + 2; j < N; j++) {
                double Y = A[i] - ((A[i] - A[j]) / (i - j)) * i;
                boolean check = true;
                for (int k = i + 1; k < j; k++) {
                    if (((A[i] - A[j]) / (i - j)) * k + Y <= A[k]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    answer[i] += 1;
                    answer[j] += 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (answer[i] > max) max = answer[i];
        }
        System.out.println(max);

    }
}
