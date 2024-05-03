import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited;
    static int count, answer;

    static class Info {
        int place;
        int time;

        Info(int place, int time) {
            this.place = place;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        answer = Integer.MAX_VALUE;
        count = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[100001];
        if (K < N) {
            answer = N - K;
            count = 1;
        } else {
            bfs(N);
        }
        System.out.println(answer);
        System.out.println(count);
    }

    private static void bfs(int n) {
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(n, 0));
        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            visited[poll.place] = true;
            if (poll.place == K) {
                if (answer > poll.time) {
                    answer = poll.time;
                    count = 1;
                } else if (answer == poll.time) {
                    count++;
                }
            }
            if (poll.place + 1 <= 100000 && !visited[poll.place + 1]) {
                if (poll.time + 1 <= answer) {
                    queue.offer(new Info(poll.place + 1, poll.time + 1));
                }
            }
            if (poll.place * 2 <= 100000 && !visited[poll.place * 2]) {
                if (poll.time * 2 <= answer) {
                    queue.offer(new Info(poll.place * 2, poll.time + 1));
                }
            }
            if (poll.place - 1 >= 0 && !visited[poll.place - 1]) {
                if (poll.place - 1 <= answer) {
                    queue.offer(new Info(poll.place - 1, poll.time + 1));
                }
            }
        }
    }
}
