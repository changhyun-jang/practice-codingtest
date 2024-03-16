import java.util.*;
import java.io.*;

public class Main {
    static int N, M, square, twoSquare;
    static long[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        square = 0;
        while (true) {
            if (Math.pow(2, square) >= N) {
                break;
            }
            square++;
        }
        twoSquare = (int) Math.pow(2, square);
        A = new long[twoSquare * 2];
        for (int i = 1; i < A.length; i++) {
            A[i] = Long.MAX_VALUE;
        }
        //데이터 배열에 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[twoSquare + i] = Long.parseLong(st.nextToken());
        }

        //배열 모두 채우기
        for (int i = A.length - 1; i > 1; i -= 2) {
            if (A[i] > A[i - 1]) {
                A[i / 2] = A[i - 1];
            } else {
                A[i / 2] = A[i];
            }
        }

        ArrayList<Long> A = new ArrayList<>();
        //범위 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long result = searchMin(start, end);
            A.add(result);
        }
        for (long temp : A) {
            System.out.println(temp);
        }
    }

    private static long searchMin(int a, int b) {
        long minResult = Long.MAX_VALUE;
        int start = twoSquare + a - 1;
        int end = twoSquare + b - 1;
        while (start <= end) {
            if (start % 2 == 1) {
                if (minResult > A[start]) {
                    minResult = A[start];
                }
                start++;
            }
            if (end % 2 == 0) {
                if (minResult > A[end]) {
                    minResult = A[end];
                }
                end--;
            }
//            if (A[start] > A[end]&& minResult>A[end]) {
//                minResult = A[end];
//            } else if(A[end] > A[start]&& minResult>A[start]){
//                minResult = A[start];
//            }
            start = start / 2;
            end = end / 2;

        }
        return minResult;
    }
}
