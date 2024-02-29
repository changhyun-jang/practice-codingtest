import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        -- 문제 해석 --
        10 20 30 40
        이 있을떄 2개씩 합쳐야함
        이때 가장 작은 2개의 묶음을 가져와서 합치고 그다음 작은 것들끼리 합친다.

        -- sudo코드 --
        N입력 받기
        작은 수부터 먼저 나가는 큐를 선언
        for(N) {
            입력 받으면 큐에 넣기
        }
        while(큐의 크기가 1이 되기 전까지) {
            큐에서 하나뽑아
            큐에서 하나뽑아
            둘이 더해
            다시 넣어
        }
        출력
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }
        int result = 0;
        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second;
            result = result +sum;
            queue.add(sum);
        }
        System.out.println(result);
    }
}
