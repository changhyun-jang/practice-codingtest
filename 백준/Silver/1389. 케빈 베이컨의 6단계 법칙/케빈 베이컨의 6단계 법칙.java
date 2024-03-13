import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제 읽기 
    2사람이 최소 몇단계만에 이어질 수 있는지 계산하는 게임
    1 3,1 4, 4 2, 3 4, 4 5
    모두 연결되어있음

    --문제풀이
    최단거리 구하기, N이 100보다 작은 경우 대부분 플루이드
    M<=5000
    방향없는 양방향 연결
    
    --sudo코드
    N입력과 M입력
    for(M){
    친구 관계 입력
    }
     */
    static int N, M;
    static int[][] A;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        for (int[] temp : A) {
            Arrays.fill(temp, 500001);
        }
        for (int i = 1; i <= N; i++) {
            A[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (A[start][end] == 500001 && A[end][start] == 500001) {
                A[start][end] = 1;
                A[end][start] = 1;
            }
        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(A[i][j]+" ");
//            }
//            System.out.println();
//        }

        //플루이드 워셜
        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    A[S][E] = Math.min(A[S][E], A   [S][K] + A[K][E]);
                }
            }
        }

//        System.out.println(); System.out.println(); System.out.println();
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(A[i][j]+" ");
//            }
//            System.out.println();
//        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int tempMin = 0;
            for (int j = 1; j <= N; j++) {
                if (A[i][j] != 500001) tempMin += A[i][j];
            }
            if (min > tempMin) {
                min = tempMin;
                answer = new ArrayList<>();
                answer.add(i);
            } else if (min == tempMin) {
                answer.add(i);
            }
        }
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}
