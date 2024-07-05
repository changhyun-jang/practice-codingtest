import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제 읽기
    사전에 수록되어 있는 모든 문자열은 N개의 a와 M개의 z로 이루어져있음
    다른 문자는 없음
    알파벳 순서대로 수록되어 있음
    
    규완이는 완성
    동호는 완성 못함
    
    동호는 자신의 과제를 끝내기 위해 규완이 사전 참조
    문자열하나만 찾을 여유밖에없음

    N과 M이 주어졌을떄 K번째 문자열이 무엇인지 구하는 프로그램
    
    N = a개수 M은 = z개수, K번쨰 문자 구하기
    문자열의 개수가 K보다 작으면 -1
     */
    static int N, M;
    static long K;
    static String answer;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        dp = new long[N + 1][M + 1];
        answer = "";

        // a가 N개, z가 M개 일때 나올 수 있는 총 갯수 구하기
        dp[0][0] = 0;
        for (int i = 1; i <= M; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if(dp[i][j] > 1000000000) {
                    dp[i][j] = 1000000000;
                }
            }
        }

//        for (int i = 0; i <= N; i++) {
//            for (int j = 0; j <= M; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 만약 최대 갯수가 K보다 작다면 -1출력 아니면 실행
        if (dp[N][M] < K) {
            System.out.println(-1);
        } else {
            while (N + M > 1) {
                if (N > 0) {
                    if (dp[N - 1][M] < K) {
                        K -= dp[N - 1][M];
                        answer += "z";
                        M--;
                    } else {
                        answer += "a";
                        N--;
                    }
                    continue;
                }
                if (M > 0) {
                    if (dp[N][M - 1] < K) {
                        K -= dp[N][M - 1];
                        answer += "a";
                        N--;
                    } else {
                        answer += "z";
                        M--;
                    }
                }
            }
            if (N == 1) {
                answer += "a";
            } else {
                answer += "z";
            }
            System.out.println(answer);
        }
    }
}
