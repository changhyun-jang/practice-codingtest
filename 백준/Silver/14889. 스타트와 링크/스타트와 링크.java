import java.io.*;
import java.util.*;

public class Main {
    /*
    조합으로 N개 중 N/2개를 뽑고 해당 팀과 다른팀의 능력치 차이가 최소이면
    answer에 넣기

    1. 조합 뽑기,
    조합을 뽑는 즉시 합 구하기 - 시간초과

    2. 팀에 뽑힌 애들은 true 아닌 애들은 false로 표시 -> 시간초과
     */
    static int N;
    static int[][] A;
    static boolean[] P;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        P = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //조합 만들기
        makeTeam(1, 0);
        System.out.println(answer);

    }

    //각 조합별 팀만들기
    private static void makeTeam(int start, int depth) {
        if (depth == N / 2) {
            int teamA = 0;
            int teamB = 0;

            for (int i = 0; i < P.length - 1; i++) {
                for (int j = i + 1; j < P.length; j++) {
                    if (P[i] && P[j]) {
                        teamA += A[i][j] + A[j][i];
                    }
                    if (!P[i] && !P[j]) {
                        teamB += A[i][j] + A[j][i];
                    }
                }
            }
            answer = Math.min(Math.abs(teamA - teamB), answer);
            return;
        }
        for (int i = start; i <= N; i++) {
            if (!P[i]) {
                P[i] = true;
                makeTeam(i, depth + 1);
                P[i] = false;
            }
        }
    }
}
