import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    N+1일째 되는날 퇴사를 하기 위해 남은 N일 동안 최대한 많은 상담을 하려함
    하루에 하나씩 다른 사람의 상담을 잡아놈
    
    상담은 상담 완료하는데 걸리는 기간 T와 상담시 받는 금액P로 이루어짐
    
    n=7인경우 상담일정표
    거꾸로 해서 수익을 구하기
    https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-14501-%ED%87%B4%EC%82%AC-Java%EC%9E%90%EB%B0%94
     */
    static class Call {
        int time;
        int income;

        public Call(int time, int income) {
            this.time = time;
            this.income = income;
        }
    }

    static int N;
    static Call[] A;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new Call[N+2];
        D = new int[N+2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int income = Integer.parseInt(st.nextToken());
            A[i] = new Call(time, income);
        }
        for (int i = N; i > 0; i--) {
            if(N-i+1>=A[i].time) {
                D[i] = Math.max(D[i+1],D[i+A[i].time] + A[i].income);
            } else {
                D[i] = D[i+1];
            }
        }
        System.out.println(D[1]);
    }
}
