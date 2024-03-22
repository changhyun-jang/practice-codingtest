import java.util.*;
import java.io.*;

public class Main {
    /*
    D[i] 에서 i는 N의 값 이고 D[i]는 N일때의 이친수의 개수
    D[1] = 1;
    D[2] = 1;
    D[3] = 2;
    D[4] = 3;
    D[5] = 5;
    임을 보았을떄 D[i] = D[i-1]+D[i-2]임을 성립한다고 생각

     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] DP = new long[N + 1];
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
        System.out.println(DP[N]);
    }
}
