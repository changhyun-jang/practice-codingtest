import java.util.*;
import java.io.*;

public class Main {
    /*
    1로 만들기
    --문제풀이
    D[1] = 0;
    D[i] 는 i를 1로만드는데 드는 비용을 의미
    D[i] = D[i-1] +1; -> -1을 했을때 이전 값보다 +1;
    D[i] = Math.min(D[i],D[i/2]+1)  -> -1 한값보다 /2한값이 더 작으면 해당 값을 넣기
    D[i] = Math.min(D[i],D[i/3]+1) -. -1한값 또는 /2보다 /3한값이 더 작으면 해당 값을 넣기
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            A[i] = A[i - 1] + 1;
            if (i % 2 == 0) {
                A[i] = Math.min(A[i], A[i / 2] + 1);
            }
            if (i % 3 == 0) {
                A[i] = Math.min(A[i], A[i / 3] + 1);
            }
        }
        System.out.println(A[N]);
    }
}
