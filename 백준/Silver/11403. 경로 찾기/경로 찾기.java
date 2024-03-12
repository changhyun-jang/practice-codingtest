import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    가중치가 없는 방향그래프 G가 주어졌을때
    모든 정점에 대해 i에서j로 가는 길이 양수인 경로가 있는지
    없는지 구하는 프로그램을 작성하시오.

    --sudo코드
    N입력
    for(N) {
        for(N
    }
     */
    static int N;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        for (int[] temp : A) {
            Arrays.fill(temp, N + 1);
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp != 0) A[i][j] = temp;
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    A[S][E] = Math.min(A[S][E], A[S][K] + A[K][E]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] >= N+1) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(1 + " ");
            }
            System.out.println();
        }
    }
}
