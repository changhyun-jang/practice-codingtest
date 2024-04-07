import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static double[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new double[N];
        st = new StringTokenizer(br.readLine());
        double answer = 0;
        int maxIdx = -1;
        for (int i = 0; i < N; i++) {
            A[i] = Double.parseDouble(st.nextToken());
            if (A[i] > answer) {
                answer = A[i];
                maxIdx = i;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i == maxIdx) continue;
            else {
                double temp = A[i]/2;
                answer += Math.round(temp*100000)/100000.0;
            }
        }
        System.out.println(answer);
    }
}
