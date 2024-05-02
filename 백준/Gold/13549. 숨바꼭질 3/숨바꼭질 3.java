import java.util.*;

public class Main {
    static int N, K;
    static int[] timeTable;
    static boolean[] visited;

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        timeTable = new int[100001];
        Arrays.fill(timeTable, Integer.MAX_VALUE);
        visited = new boolean[100001];
        if (K < N) {
            answer = N - K;
        } else {
            bfs(N);
//            dfs(N, 0);
            answer = timeTable[K];
        }
        System.out.println(answer);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        timeTable[n] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int tempTime = timeTable[poll];
            if (poll == K) {
                break;
            }
            if (poll + 1 <= 100000) {
                if (!(timeTable[poll + 1] <= tempTime + 1)) {
                    queue.offer(poll + 1);
                    timeTable[poll + 1] = tempTime + 1;
                }
            }
            if (poll * 2 <= 100000) {
                if (!(timeTable[poll * 2] <= tempTime)) {
                    queue.offer(poll * 2);
                    timeTable[poll * 2] = tempTime;
                }
            }
            if (poll - 1 >= 0) {
                if (!(timeTable[poll - 1] <= tempTime + 1)) {
                    queue.offer(poll - 1);
                    timeTable[poll - 1] = tempTime + 1;
                }
            }
        }
    }

    private static void dfs(int n, int time) {
        if (n == K) {
            timeTable[n] = Math.min(timeTable[n], time);
            return;
        }
        if (time > timeTable[K]) {
            return;
        }
        timeTable[n] = Math.min(timeTable[n], time);
        if (n + 1 <= 100000) {
            dfs(n + 1, time + 1);
        }
        if (n * 2 <= 100000) {
            dfs(n * 2, time);
        }
        if (n - 1 >= 0) {
            dfs(n - 1, time + 1);
        }
    }
}
