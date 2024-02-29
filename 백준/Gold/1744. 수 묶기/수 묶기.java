import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        -- 문제 읽기 --
        길이가 N인 수열, 수열의 합을 구하려함
        위치에 상관없이 2수를 묶음, 같은 위치 수는 못묶음.
        묶은 수는 서로 곱한 뒤 더함.
        수열의 모든 수는 한번만 묶거나 묶지 않아야함
        합이 최대가 되게 하는 프로그램
        N < 50
        수열의 수는 -1000보다 크거나 가토, 1000보다 작거나 같음

        -- 문제 해석 --
       너무 어렵다..
       나중에 다시 풀어보기
       양수만 갖는 우선순위 큐
       음수만 갖는 우선순위 큐
       0을 카운트하는 변수
       1을 카운트 하는 변수를 이용하기
        
        -- sudo 코드 --
        N 입력받기
        최댓값 양수 2개를 꺼내는 우선 순위 큐
        최솟값 음수 2개를 꺼내는 우선 순위 큐
        0을 카운트 하는 변수 선언
        1을 카운트 하는 변수 선언
        for( N ) {
         if( 입력받은 수가 양수면) {
            양수 저장 큐에 저장
         } else if( 입력받은 수가 음수면) {
            음수 저장 큐에 저장
         } else if( 1이면 ) {
            1카운트 변수에 +1
         } else {
            0카운트 변수에 저장
         }
        }
        result변수 선언
        while(양수큐의 크기가 1보다 클동안만) {
            가장큰거 뽑기
            두번쨰로 큰거 뽑기
            곱하기
            result와 더하기
        }
        양수큐의 크기가 1이면 뽑아서 result에 더하기
        wihle(음수큐의 크기가 1보다 클동안만) {
            가장 작은거 뽑기
            두번쨰로 작은거 뽑기
            곱하기
            result와 더하기
        }
        음수큐의 크기가 1이면 0이 있으면 같이 곱한뒤 result와 더하기
        1을 count한만큼 result와 더하기
        sout(result)
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (1 < num) {
                plusQueue.add(num);
            } else if (1 == num) {
                oneCount += 1;
            } else if (0 == num) {
                zeroCount += 1;
            } else {
                minusQueue.add(num);
            }
        }
        int result = 0;
        while (plusQueue.size() > 1) {
            int first = plusQueue.poll();
            int second = plusQueue.poll();
            int multiple = first * second;
            result += multiple;
        }
        while (minusQueue.size() > 1) {
            int first = minusQueue.poll();
            int second = minusQueue.poll();
            int multiple = first * second;
            result += multiple;
        }
        if (plusQueue.size() == 1) {
            result += plusQueue.poll();
        }
        if (minusQueue.size() == 1) {
            if (zeroCount > 0) {
                zeroCount -= 1;
            } else {
                result += minusQueue.poll();
            }
        }
        result += oneCount;
        System.out.println(result);
    }
}
