import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        -- 문제 읽기
        모든 자리가 1로만 이루어진 자연수 A,B의 최대공약수
        
        A와 B를 이루는 1의 개수가 주어짐.
        2의 63승보다 작은 자연수
        
        --문제 해석
        입력되는 갯수를 이루는 두 수의 최대공약수를 구하면 그게 정답
        입력되는 두수의 최대공약수 구하기
        
        -- sudo코드
        N,M 입력받기
        두수의 최대공약수 구하기
        결과 만큼 1출력하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int result = gcd(N, M);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < result; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    private static int gcd(long n, long m) {
        if (m == 0) {
            return(int) n;
        } else {
            return gcd(m, n % m);
        }
    }
}
