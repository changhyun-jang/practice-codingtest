import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            A[i] = temp;
        }
        Arrays.sort(A);
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < A.length - 1; i++) {
            queue.add(Math.abs(A[i] - A[i + 1]));
        }
        for (int i = 0; i < N - K; i++) {
            answer += queue.poll();
        }
        System.out.println(answer);
    }
}
