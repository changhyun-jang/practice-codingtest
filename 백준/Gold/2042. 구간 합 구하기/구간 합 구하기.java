import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제풀이
    부분합인데, 중간에 값들이 변하므로 세그먼트 트리를 사용해야함
    
    -- sudo코드
    N,M,K입력
    배열 선언 및 크기 
    for(N만큼) { 
        숫자입력
        배열에 넣기
    }
    for(배열의 크기만큼) {
        부모 배열 모두 초기화
    }
    for(M+K만큼) {
        1이면 업데이트
        2면 구간합구하기
    }

    [업데이트 함수]

    [구간합 출력함수]
     */
    static long N, M, K;
    static int square, twoSquare;
    static long[] A;
    static ArrayList<Long> answer;

    public static void main(String[] args) throws IOException {
        answer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        square = 1;
        while (true) {
            if (Math.pow(2, square) >= N) {
                break;
            }
            square++;
        }
        twoSquare = (int)Math.pow(2, square);
        A = new long[twoSquare * 2];
        //배열에 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long number = Long.parseLong(st.nextToken());
            A[twoSquare + i] = number;
        }
        //부모 배열 값넣기
        for (int i = twoSquare * 2 - 1; i > 1; i -= 2) {
            A[i / 2] = A[i] + A[i - 1];
        }
        //업데이트와 구간합 명령 받기
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long command =  Long.parseLong(st.nextToken());
            long B =  Long.parseLong(st.nextToken());
            long C =  Long.parseLong(st.nextToken());
            if (command == 1) {
                update(B, C);
            } else if(command==2){
                long result = executeSum(B, C);
                answer.add(result);
            }else{
                return;
            }
        }
        for (long temp : answer) {
            System.out.println(temp);
        }

    }

    private static Long executeSum(long b, long c) {
        long sumResult = 0;
        long start = twoSquare + b - 1;
        long end = twoSquare + c - 1;

        while (start <= end) {
            if (start % 2 == 1) {
                sumResult += A[(int)start];
                start += 1;
            }
            if (end % 2 == 0) {
                sumResult += A[(int)end];
                end -= 1;
            }
            start = start / 2;
            end = end / 2;
        }
        return sumResult;
    }

    private static void update(long b, long c) {
        long index = twoSquare + b - 1;
        long sub = c - A[(int)index];
        for (long i = index; i > 1; i /= 2) {
            A[(int)i] = A[(int)i] + sub;
        }
    }
}
