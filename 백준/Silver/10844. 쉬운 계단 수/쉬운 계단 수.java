import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    인접한 모든자리의 차이가 1이면 계단 수
    길이가 N인 계단수가 총 몇개 있는지 확인
    0으로 시작하는 수는 계단수가 아님

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] DP = new long[N + 1][10];
        for (int i = 0; i < 10; i++) {
            DP[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    DP[i][j] = DP[i - 1][1] %1000000000;
                } else if (j == 9) {
                    DP[i][j] = DP[i - 1][8] %1000000000;
                } else {
                    DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) %1000000000;
                }
            }
        }
        long sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += DP[N][i];
            sum %= 1000000000;
        }
        System.out.println(sum);
    }
}
