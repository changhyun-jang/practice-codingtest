import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] DP = new long[N + 2];
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i-1] + DP[i-2])%10007;
        }
        System.out.println(DP[N]);
    }

}
