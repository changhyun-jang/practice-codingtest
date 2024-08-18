import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, before, after;
    static int[] A;
    static int[] temp;
    static PriorityQueue<Integer> check = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        temp = new int[N];
        before = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            before += A[i] + i * 10;
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            after = 0;
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (A[j] >= L && A[j] <= R) {
                    check.add(A[j]);
                    temp[j] = 0;
                } else {
                    temp[j] = A[j];
                }
            }
            for (int j = 0; j < N; j++) {
                if (temp[j] == 0) {
                    System.out.print(check.poll()+ " ");
                } else {
                    System.out.print(temp[j]+ " ");
                }
            }
            System.out.println();
        }
    }
}
