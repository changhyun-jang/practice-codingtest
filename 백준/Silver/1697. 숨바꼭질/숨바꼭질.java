import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    수빈이 점 N에 있음
    동생은 점 K에 잇음
    수빈이는 걷거나 순간이동할 수 있음
    수빈이 위치가 X일떄 걸으면 1초후 X-1,X+1
    1초후 2*X

    수빈이가 동생을 찾을 수 있는 가장 빠른시간
     */
    static int N;
    static int K;
    static boolean[] visited;
    static int[] A;

    static class Number {
        int number;
        int count;

        Number(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[200001];
        A = new int[200001];
        A[N] = 0;
        if (N == K) {
            System.out.println(A[K]);
        } else if (N > K) {
            System.out.println(N - K);
        } else {
            bfs(N);
            System.out.println(A[K]);
        }
    }

    private static void bfs(int N) {
        Queue<Number> queue = new LinkedList<>();
        queue.offer(new Number(N,0));
        while (!queue.isEmpty()) {
            Number nowQ = queue.poll();
            int number = nowQ.number;
            if(number<100001){
                visited[number] = true;
                if(number == K) {
                    A[K] = nowQ.count;
                    break;
                }
                int count = nowQ.count;
                if(number>0) if(!visited[number-1])  queue.offer(new Number(number-1,count+1));
                if(!visited[number+1])  queue.offer(new Number(number+1,count+1));
                if(!visited[number*2])  queue.offer(new Number(number*2,count+1));
            }
        }

    }
}
