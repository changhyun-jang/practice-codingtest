import java.util.*;

public class Main {
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int K = sc.nextInt();
            boolean result = false;
            int start = 0;
            int end = A.length-1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (K == A[mid]) {
                    result = true;
                    break;
                } else if (K < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
