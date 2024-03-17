import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, square, twoSquare;
    static long[] A;

    //정답출력 List
    static ArrayList<Long> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N,M:수의 변경이 일어나는 횟수,K : 구간의 곱을 구하는 횟수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //2의 square승이 N보다 크거나같을때의 값구하기
        square = 0;
        while (true) {
            if (Math.pow(2, square) >= N) break;
            square++;
        }
        //2의 square승 구하기
        twoSquare = (int) (Math.pow(2, square));
        //배열의 크기 2의 square승에 2를 곱한 크기로 초기화
        A = new long[twoSquare * 2];
        Arrays.fill(A, 1);
        //N만큼 입력받은 값을 A배열에 대입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[twoSquare + i] = Long.parseLong(st.nextToken());
        }
        //다른 모든 배열에 채워넣기
        for (int i = A.length - 1; i > 1; i -= 2) {
            A[i / 2] = A[i] * A[i - 1] % 1000000007;
        }
        //명령 입력받기
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            //command가 1이면 업데이트 수행
            if (command == 1) {
                update(first, second);
//                System.out.println();
//                //배열값 출력해보기
//                for (int j = 1; j < A.length; j++) {
//                    System.out.print(A[j]+" ");
//                }
                //command가 2이면 범위 곱셈 수행
            } else if (command == 2) {
                long result = multiply(first, second);
                answer.add(result);
            } else {
                return;
            }
        }
        for (long temp : answer) {
            System.out.println(temp);
        }

//        //배열값 출력해보기
//        for (int i = 1; i < A.length; i++) {
//            System.out.print(A[i]);
//        }
    }

    private static long multiply(int a, int b) {
        int startIdx = twoSquare + a - 1;
        int endIdx = twoSquare + b - 1;
        long multipleResult = 1;
        while (startIdx <= endIdx) {
            if (startIdx % 2 == 1) {
                multipleResult = multipleResult * A[startIdx] % 1000000007;
                startIdx++;
            }
            if (endIdx % 2 == 0) {
                multipleResult = multipleResult * A[endIdx] % 1000000007;
                endIdx--;
            }
            endIdx /= 2;
            startIdx /= 2;
        }
        return multipleResult;
    }

    //수정 로직
    private static void update(int a, int b) {
        //a의 인덱스 구하기
        int idx = twoSquare + a - 1;
        //현재 값에 b대입
        A[idx] = b;
        while (idx > 1) {
            idx /= 2;
            A[idx] = A[idx*2+1] % 1000000007 * A[idx*2] % 1000000007;
        }

    }
}
