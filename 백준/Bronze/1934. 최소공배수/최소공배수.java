import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        -- 문제 읽기
        A와 B가 주어졌을때 최소 공배수를 구하는 프로그램을 작성
        테스트 케이스의 개수는 T
        T<=1000
        A,B <=45000

        -- 문제 풀기
        유클리드 호제법을 사용하기

        큰수를 1,2,3,4,5..와 곱했을때 그 결과 값이 작은 수로 나눴을때
        나머지가 0이면 공배수. 그게 처음인 수가 최소공배수이다.

        -- sudo코드
        T입력받기
        Queue선언
        for(T동안) {
            int N 입력받기
            int M 입력받기
            int multiple = 1;
            while(true) {
                temp = 큰수 * multiple
                if(temp % N == 0) {
                    Queue에 넣기
                    break;
                }
                multiple ++;
            }
        }
        while(queue가 비어있지 않은동안) {
            하나씩꺼내며 출력
        }
         */
        Scanner sc = new Scanner(System.in);
        //T입력받기
        int T = sc.nextInt();
        //Queue선언
        Queue<Integer> queue = new LinkedList<>();
        //T 동안
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int cal = 1;
            while(true) {
                int temp = M * cal;
                if(temp % N ==0) {
                    queue.offer(temp);
                    break;
                }
                cal++;
            }
        }
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
