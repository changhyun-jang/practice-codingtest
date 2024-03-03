import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //T입력받기
        int T = sc.nextInt();
        //T 동안
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            //최소공배수 = 주어진 두수의 곱 / 최대공약수
            int result = M * N / gcd(N, M);
            System.out.println(result);
        }

    }

    private static int gcd(int n, int m) {
        //이전 계산의 나머지가 0이면 n이 최대공약수
        if (m == 0) {
            return n;
        } else {
            // 이전계산의 나머지가 0이 아니면 다시 재귀
           return gcd(m, n % m);
        }
    }
}