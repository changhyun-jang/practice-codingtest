import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
   서쪽점 N개 동쪽 점 M개
   다리끼리 겹칠 수 없음 다리를 지을 수 있는 경우의 수를 구하시오
   서쪽과 모든 점이 연결되어야함.
   
   --문제풀이
   서쪽 4개 동쪽 7개 일떄
   동쪽에서 서쪽을 뽑는 다는 생각으로 가기
   7개에서 4개를 뽑기?
     */
    static int T;
    static long[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        A = new long[31][31];
        for (int i = 0; i < 31; i++) {
            A[i][0] = 1;
            A[i][i] = 1;
            A[i][1] = i;
        }
        for (int i = 1; i < 31; i++) {
            for (int j = 1; j < i; j++) {
                A[i][j] = A[i - 1][j] + A[i - 1][j - 1];
            }
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(A[M][N]);
        }

    }
}
