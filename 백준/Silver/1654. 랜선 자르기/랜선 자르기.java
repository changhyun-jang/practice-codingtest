import java.io.*;
import java.util.*;

public class Main {
    /*
    --문제 읽기
    N개의 랜선을 만들어야함 너무 바쁨
    영식이 k개의 랜선을 갖고 있음
    K개의 랜선은 길이가 제각각임.
    랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에
    k개의 랜선을 잘라서 만들어야 함.
    
    N개보다 많이 만드는 것도 N개를 만드는 것에 포함됨
    최대 랜선의 길이를 구하는 프로그램을 작성
     */
    static int K, N;
    static long[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new long[K];
        long sum = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            sum += A[i];
        }
        long start = 1;
        long end = sum / N;
        long answer = BinarySearch(start, end);
        System.out.println(answer);

    }

    private static long BinarySearch(long a, long b) {
        long start = a;
        long end = b;
        while (start <= end) {
            int count = 0;
            long temp = (start + end) / 2;
            for (int i = 0; i < K; i++) {
                count += A[i] / temp;
            }
            if (count >= N) {
                start = temp + 1;
                if(start > end) {
                    break;
                }
            } else {
                end = temp - 1;
            }
        }
        return start-1;
    }
}
